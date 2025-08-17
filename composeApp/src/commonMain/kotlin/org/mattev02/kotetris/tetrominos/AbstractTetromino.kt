package org.mattev02.kotetris.tetrominos

import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point

/**
 * Abstract tetromino base class
 * @property topLeft top left point of the abstract tetromino
 * @property bottomRight bottom right point of the abstract tetromino
 * @property orientation starting orientation of the tetromino
 * @throws IllegalArgumentException when `topLeft` or `bottomRight` points mismatch
 */
abstract class AbstractTetromino: Tetromino {
    constructor(topLeft: Point, bottomRight: Point, orientation: Orientation) {
        if (topLeft.x >= bottomRight.x || bottomRight.y >= topLeft.y) {
            throw IllegalArgumentException()
        }

        this.topLeft = topLeft
        this.bottomRight = bottomRight
        this.orientation = orientation
    }

    var topLeft = Point(0, 0)
        protected set

    var bottomRight = Point(0, 0)
        protected set

    var orientation = Orientation.UP
        protected set

    override fun move(dx: Int, dy: Int) {
        topLeft.x += dx
        topLeft.y += dy

        bottomRight.x += dx
        bottomRight.y += dy

        if (topLeft.x < 0 || bottomRight.y < 0) {
            throw RuntimeException()
        }
    }

    private fun orthogonalPointRotation() {
        val length = bottomRight.x - topLeft.x
        val height = topLeft.y - bottomRight.y

        topLeft.y = bottomRight.y + length

        bottomRight.x = topLeft.x + height
    }

    override fun rotateClockwise() {
        orientation = orientation.nextClockwise()

        orthogonalPointRotation()
    }

    override fun rotateAnticlockwise() {
        orientation = orientation.nextAnticlockwise()

        orthogonalPointRotation()
    }
}