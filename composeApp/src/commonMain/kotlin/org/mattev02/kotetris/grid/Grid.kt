package org.mattev02.kotetris.grid

import org.mattev02.kotetris.tetrominos.Tetromino
import org.mattev02.kotetris.utils.Point

/**
 * Represents the grid where the dropped tetrominos are lying
 */
interface Grid {
    val width: Int

    val height: Int

    /**
     * Returns a set of point of the occupied positions of the grid
     * @return Set of occupied points of the grid
     */
    fun getOccupiedPoints(): Set<Point>

    /**
     * Add a landed tetromino to the grid. After a tetromino is landed, if a line of the grid is full it is eliminated
     * @param tetromino landed tetromino
     */
    fun addLandedTetromino(tetromino: Tetromino)
}