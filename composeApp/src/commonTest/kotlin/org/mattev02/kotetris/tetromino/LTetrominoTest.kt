package org.mattev02.kotetris.tetrominos

import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point
import kotlin.test.Test
import kotlin.test.assertEquals

class LTetrominoTest {

    @Test
    fun testGetOccupiedPointsUP() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 0),
                Point(1, 0),
                Point(0, 1),
                Point(0, 2)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsDOWN() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.DOWN
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 2),
                Point(1, 2),
                Point(1, 1),
                Point(1, 0)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsRIGHT() {
        val tetromino = LTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(2, 0),
            orientation = Orientation.RIGHT
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 1),
                Point(0, 0),
                Point(1, 1),
                Point(2, 1)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsLEFT() {
        val tetromino = LTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(2, 0),
            orientation = Orientation.LEFT
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
                Point(2, 1)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testRotateClockwiseFromUP() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateClockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 1),
                Point(1, 1),
                Point(2, 1),
                Point(0, 0)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testRotateClockwiseFromRIGHT() {
        val tetromino = LTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(2, 0),
            orientation = Orientation.RIGHT
        )
        tetromino.rotateClockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 2),
                Point(1, 2),
                Point(1, 1),
                Point(1, 0)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testRotateAnticlockwiseFromUP() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateAnticlockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
                Point(2, 1)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testRotateFullCircleClockwise() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val originalPoints = tetromino.getOccupiedPoints()
        repeat(4) { tetromino.rotateClockwise() }
        assertEquals(originalPoints, tetromino.getOccupiedPoints())
    }

    @Test
    fun testRotateFullCircleAnticlockwise() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val originalPoints = tetromino.getOccupiedPoints()
        repeat(4) { tetromino.rotateAnticlockwise() }
        assertEquals(originalPoints, tetromino.getOccupiedPoints())
    }

    @Test
    fun testMoveOperation() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.move(3, 4)
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(3, 4),
                Point(4, 4),
                Point(3, 5),
                Point(3, 6)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testMoveAfterRotation() {
        val tetromino = LTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateClockwise()
        tetromino.move(2, 3)
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(2, 4),
                Point(2, 3),
                Point(3, 4),
                Point(4, 4)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testNonStandardBoundingBox() {
        val tetromino = LTetromino(
            topLeft = Point(3, 5),
            bottomRight = Point(5, 3),
            orientation = Orientation.RIGHT
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(3, 5),
                Point(3, 4),
                Point(4, 5),
                Point(5, 5),
                Point(3,3)
            ),
            occupiedPoints
        )
    }
}