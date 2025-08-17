package org.mattev02.kotetris.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class OrientationTest {

    @Test
    fun testNextClockwise() {
        assertEquals(Orientation.LEFT, Orientation.DOWN.nextClockwise())
        assertEquals(Orientation.DOWN, Orientation.RIGHT.nextClockwise())
        assertEquals(Orientation.RIGHT, Orientation.UP.nextClockwise())
        assertEquals(Orientation.UP, Orientation.LEFT.nextClockwise())
    }

    @Test
    fun testNextAnticlockwise() {
        assertEquals(Orientation.RIGHT, Orientation.DOWN.nextAnticlockwise())
        assertEquals(Orientation.DOWN, Orientation.LEFT.nextAnticlockwise())
        assertEquals(Orientation.LEFT, Orientation.UP.nextAnticlockwise())
        assertEquals(Orientation.UP, Orientation.RIGHT.nextAnticlockwise())
    }
}