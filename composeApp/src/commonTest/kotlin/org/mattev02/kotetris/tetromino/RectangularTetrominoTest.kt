package org.mattev02.kotetris.tetrominos

import org.mattev02.kotetris.utils.Orientation
import org.mattev02.kotetris.utils.Point
import kotlin.test.Test
import kotlin.test.assertEquals

class RectangularTetrominoTest {

    @Test
    fun testGetOccupiedHorizontal() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(2, 0),
            orientation = Orientation.UP
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(6, occupiedPoints.size)
        assertEquals(
            setOf(
                Point(0, 1),
                Point(1, 1),
                Point(2, 1),
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsVertical() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(6, occupiedPoints.size)
        assertEquals(
            setOf(
                Point(0, 2),
                Point(1, 2),
                Point(0, 1),
                Point(1, 1),
                Point(0, 0),
                Point(1, 0),
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsAfterRotation() {
        val tetromino = RectangularTetromino(
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
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPoints2x2() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(4, occupiedPoints.size)
        assertEquals(
            setOf(
                Point(0, 1),
                Point(1, 1),
                Point(0, 0),
                Point(1, 0)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsNonZeroOrigin() {
        val tetromino = RectangularTetromino(
            topLeft = Point(2, 4),
            bottomRight = Point(3, 2),
            orientation = Orientation.UP
        )
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(6, occupiedPoints.size)
        assertEquals(
            setOf(
                Point(2, 4),
                Point(3, 4),
                Point(2, 3),
                Point(3, 3),
                Point(2, 2),
                Point(3, 2)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsAfterMove() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 1),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.move(2, 3)
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(4, occupiedPoints.size)
        assertEquals(
            setOf(
                Point(2, 4),
                Point(3, 4),
                Point(2, 3),
                Point(3, 3)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsAfterTwoRotations() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateClockwise()
        tetromino.rotateClockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 2),
                Point(1, 2),
                Point(0, 1),
                Point(1, 1),
                Point(0, 0),
                Point(1, 0)
            ),
            occupiedPoints
        )
    }

    @Test
    fun testGetOccupiedPointsAfterFourRotations() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        val originalPoints = tetromino.getOccupiedPoints()
        tetromino.rotateClockwise()
        tetromino.rotateClockwise()
        tetromino.rotateClockwise()
        tetromino.rotateClockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(originalPoints, occupiedPoints)
    }

    @Test
    fun testGetOccupiedPointsAfterAnticlockwiseRotation() {
        val tetromino = RectangularTetromino(
            topLeft = Point(0, 2),
            bottomRight = Point(1, 0),
            orientation = Orientation.UP
        )
        tetromino.rotateAnticlockwise()
        val occupiedPoints = tetromino.getOccupiedPoints()
        assertEquals(
            setOf(
                Point(0, 1),
                Point(1, 1),
                Point(2, 1),
                Point(0, 0),
                Point(1, 0),
                Point(2, 0)
            ),
            occupiedPoints
        )
    }
}