package org.mattev02.kotetris.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class PointTest {

    @Test
    fun testProperties() {
        val point = Point(5, 10)
        assertEquals(5, point.x)
        assertEquals(10, point.y)
    }

    @Test
    fun testCopy() {
        val original = Point(3, 7)
        val copy = original.copy(x = 8)
        assertEquals(8, copy.x)
        assertEquals(7, copy.y)
    }
}