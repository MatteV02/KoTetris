package org.mattev02.kotetris.tetrominos

import androidx.compose.ui.graphics.Color
import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point

/**
 * Abstract tetromino base class
 * @property topLeft top left point of the abstract tetromino
 * @property bottomRight bottom right point of the abstract tetromino
 * @property orientation starting orientation of the tetromino
 * @throws IllegalArgumentException when `topLeft` or `bottomRight` points mismatch or point colors mismatch
 */
abstract class AbstractTetromino(
    topLeft: Point,
    bottomRight: Point,
    orientation: Orientation
) : Tetromino {
    var topLeft = topLeft
        protected set

    var bottomRight = bottomRight
        protected set

    var orientation = orientation
        protected set

    override val color: Color = topLeft.color

    init {
        if (topLeft.x >= bottomRight.x || bottomRight.y >= topLeft.y) {
            throw IllegalArgumentException()
        }
        if (topLeft.color != bottomRight.color) {
            throw IllegalArgumentException()
        }
    }

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