package org.mattev02.kotetris.tetrominos

import androidx.compose.ui.graphics.Color
import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point

/**
 * Implements a Rectangular tetromino
 * @property topLeft top left point of the square tetromino
 * @property bottomRight bottom right point of the square tetromino
 * @property orientation orientation of the tetromino
 */
class RectangularTetromino(
    topLeft: Point,
    bottomRight: Point,
    orientation: Orientation,
    color: Color
) : AbstractTetromino(topLeft, bottomRight, orientation, color) {
    override fun getOccupiedPoints(): Set<Point> {
        val occupiedPointsSet = mutableSetOf<Point>()

        for (ix in topLeft.x..bottomRight.x) {
            for (iy in bottomRight.y..topLeft.y) {
                occupiedPointsSet.add(Point(ix, iy))
            }
        }

        return occupiedPointsSet
    }
}