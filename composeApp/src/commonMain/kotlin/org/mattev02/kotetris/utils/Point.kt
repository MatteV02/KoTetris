package org.mattev02.kotetris.utils

import androidx.compose.ui.graphics.Color

data class Point(
    var x: Int,
    var y: Int,
    val color: Color
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}
