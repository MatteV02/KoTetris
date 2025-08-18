package org.mattev02.kotetris.tetrominos

import androidx.compose.ui.graphics.Color
import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point

/**
 * L shaped tetromino
 * @param topLeft top left corner of the L-tetromino bounding box
 * @param bottomRight bottom right corner of the L-tetromino bounding box
 * @param orientation starting orientation of the L-tetromino
 */
class LTetromino(
    topLeft: Point,
    bottomRight: Point,
    orientation: Orientation
) :
    AbstractTetromino(topLeft, bottomRight, orientation) {
    override fun getOccupiedPoints(): Set<Point> = when(orientation) {
        Orientation.UP -> UPOccupiedPoints()
        Orientation.DOWN -> DOWNOccupiedPoints()
        Orientation.RIGHT -> RIGHTOccupiedPoints()
        Orientation.LEFT -> LEFTOccupiedPoints()
    }

    private fun UPOccupiedPoints(): Set<Point> {
        val occupiedPointsSet = mutableSetOf<Point>()

        for (iy in bottomRight.y..topLeft.y) {
            if (iy == bottomRight.y) {
                // fill the line
                for (ix in topLeft.x..bottomRight.x) {
                    occupiedPointsSet.add(Point(ix, iy, color))
                }
            } else {
                // align left
                occupiedPointsSet.add(Point(topLeft.x, iy, color))
            }
        }

        return occupiedPointsSet
    }

    private fun DOWNOccupiedPoints(): Set<Point> {
        val occupiedPointsSet = mutableSetOf<Point>()

        for (iy in bottomRight.y..topLeft.y) {
            if (iy == topLeft.y) {
                for (ix in topLeft.x..bottomRight.x) {
                    occupiedPointsSet.add(Point(ix, iy, color))
                }
            } else {
                occupiedPointsSet.add(Point(bottomRight.x, iy, color))
            }
        }

        return occupiedPointsSet
    }

    private fun RIGHTOccupiedPoints(): Set<Point> {
        val occupiedPointsSet = mutableSetOf<Point>()

        for (ix in topLeft.x..bottomRight.x) {
            if (ix == topLeft.x) {
                for (iy in bottomRight.y..topLeft.y) {
                    occupiedPointsSet.add(Point(ix, iy, color))
                }
            } else {
                occupiedPointsSet.add(Point(ix, topLeft.y, color))
            }
        }

        return occupiedPointsSet
    }

    private fun LEFTOccupiedPoints(): Set<Point> {
        val occupiedPointsSet = mutableSetOf<Point>()

        for (ix in topLeft.x..bottomRight.x) {
            if (ix == bottomRight.x) {
                for (iy in bottomRight.y..topLeft.y) {
                    occupiedPointsSet.add(Point(ix, iy, color))
                }
            } else {
                occupiedPointsSet.add(Point(ix, bottomRight.y, color))
            }
        }

        return occupiedPointsSet
    }
}