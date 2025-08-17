package org.mattev02.kotetris.tetrominos

import org.mattev02.kotetris.utils.Point

interface Tetromino {
    /**
     * Returns a set of the occupied points by the tetromino
     * @return A set of the occupied points by the tetromino
     */
    fun getOccupiedPoints(): Set<Point>

    /**
     * Apply the offset to the tetromino position.
     * @param dx x offset
     * @param dy y offset
     * @throws RuntimeException after moving to an illegal region
     */
    fun move(dx: Int, dy: Int)

    /**
     * Rotate clockwise the tetromino
     */
    fun rotateClockwise()

    /**
     * Rotate anticlockwise the tetromino
     */
    fun rotateAnticlockwise()
}