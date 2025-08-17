package org.mattev02.kotetris.tetrominos

import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AbstractTetrominoTest {

    @Test
    fun testValidConstruction() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        assertEquals(Point(0, 2), tetromino.topLeft)
        assertEquals(Point(1, 0), tetromino.bottomRight)
    }

    @Test
    fun testInvalidConstructionX() {
        assertFailsWith<IllegalArgumentException> {
            RectangularTetromino(
                topLeft = Point(2, 0),
                bottomRight = Point(1, 0),
                orientation = Orientation.UP
            )
        }
    }

    @Test
    fun testInvalidConstructionY() {
        assertFailsWith<IllegalArgumentException> {
            RectangularTetromino(
                topLeft = Point(0, 0),
                bottomRight = Point(0, 1),
                orientation = Orientation.UP
            )
        }
    }

    @Test
    fun testMove() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.move(2, 3)
        assertEquals(Point(2, 5), tetromino.topLeft)
        assertEquals(Point(3, 3), tetromino.bottomRight)
    }

    @Test
    fun testMoveToNegativeCoordinatesThrows() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        assertFailsWith<RuntimeException> {
            tetromino.move(-1, -1)
        }
    }

    @Test
    fun testRotateClockwise() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateClockwise()
        assertEquals(Orientation.RIGHT, tetromino.orientation)
        assertEquals(Point(0, 1), tetromino.topLeft)
        assertEquals(Point(2, 0), tetromino.bottomRight)
    }

    @Test
    fun testRotateAnticlockwise() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateAnticlockwise()
        assertEquals(Orientation.LEFT, tetromino.orientation)
        assertEquals(Point(0, 1), tetromino.topLeft)
        assertEquals(Point(2, 0), tetromino.bottomRight)
    }

    @Test
    fun testMoveToNegativeTopLeftX() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        assertFailsWith<RuntimeException> {
            tetromino.move(-1, 0) // Moves topLeft.x to -1
        }
    }

    @Test
    fun testMoveToNegativeBottomRightY() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        assertFailsWith<RuntimeException> {
            tetromino.move(0, -1) // Moves bottomRight.y to -1
        }
    }
}