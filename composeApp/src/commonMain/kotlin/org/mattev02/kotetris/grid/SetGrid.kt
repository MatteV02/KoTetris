package org.mattev02.kotetris.grid

import org.mattev02.kotetris.tetrominos.Tetromino
import org.mattev02.kotetris.utils.Point

class SetGrid(
    override val width: Int,
    override val height: Int
) : Grid {
    val occupiedPoints = mutableSetOf<Point>()

    override fun getOccupiedPoints(): Set<Point> {
        return occupiedPoints
    }

    override fun addLandedTetromino(tetromino: Tetromino) {
        val tetrominoPoints = tetromino.getOccupiedPoints()

        occupiedPoints.addAll(tetrominoPoints)

        deleteFullLines()
    }

    /**
     * Checks if there is any full line. Once a full line is detected, that line is deleted
     */
    private fun deleteFullLines() {
        val rowCounts = (1..width).map { 0 }.toMutableList()

        occupiedPoints.forEach { point ->
            rowCounts[point.y]++
            if (rowCounts[point.y] >= height) {
                rowCounts[point.y] = 0
                occupiedPoints.removeAll(
                    occupiedPoints.filter { (x, y, color) -> y == point.y }.toSet()
                )
            }
        }
    }
}