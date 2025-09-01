package org.mattev02.kotetris.grid

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.mattev02.kotetris.tetrominos.Tetromino
import org.mattev02.kotetris.utils.Point

class GridTest {

    @Test
    fun shouldHaveCorrectDimensions() {
        val grid = TestGrid()
        assertEquals(10, grid.width)
        assertEquals(20, grid.height)
    }

    @Test
    fun shouldReturnEmptyOccupiedPositionsInitially() {
        val grid = TestGrid()
        assertTrue(grid.getOccupiedPositions().isEmpty())
    }

    @Test
    fun shouldAddTetrominoBlocksToOccupiedPositions() {
        val grid = TestGrid()
        val blocks = setOf(Point(0, 0), Point(1, 0), Point(0, 1), Point(1, 1))
        val tetromino = TestTetromino(blocks)

        grid.addLandedTetromino(tetromino)

        assertEquals(blocks, grid.getOccupiedPositions())
    }

    @Test
    fun shouldClearCompletedRows() {
        val grid = TestGrid()
        // Create a completed row
        val blocks = (0 until grid.width).map { x -> Point(x, grid.height - 1) }.toSet()
        val tetromino = TestTetromino(blocks)

        grid.addLandedTetromino(tetromino)

        // After adding, the completed row should be cleared
        assertTrue(grid.getOccupiedPositions().none { it.y == grid.height - 1 })
    }

    @Test
    fun shouldShiftBlocksDownAfterRowClearance() {
        val grid = TestGrid()
        // Add blocks above a completed row
        val blocks = setOf(
            Point(0, grid.height - 2), // Above bottom row
            *((0 until grid.width).map { Point(it, grid.height - 1) }.toTypedArray()) // Complete row
        )
        val tetromino = TestTetromino(blocks)

        grid.addLandedTetromino(tetromino)

        // Verify top block shifted down to bottom
        assertTrue(Point(0, grid.height - 1) in grid.getOccupiedPositions())
        assertTrue(Point(0, grid.height - 2) !in grid.getOccupiedPositions())
    }

    @Test
    fun shouldHandleMultipleRowClearance() {
        val grid = TestGrid()
        val blocks = mutableSetOf<Point>().apply {
            // Add two complete rows
            addAll((0 until grid.width).map { Point(it, grid.height - 1) })
            addAll((0 until grid.width).map { Point(it, grid.height - 2) })
            // Add a block above
            add(Point(0, grid.height - 3))
        }
        val tetromino = TestTetromino(blocks)

        grid.addLandedTetromino(tetromino)

        assertEquals(1, grid.getOccupiedPositions().size)
        assertTrue(Point(0, grid.height - 1) in grid.getOccupiedPositions())
    }
}