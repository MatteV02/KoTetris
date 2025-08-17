package org.mattev02.kotetris.utils

enum class Orientation {
    UP, LEFT, DOWN, RIGHT;

    fun nextClockwise() = when(this) {
        UP -> RIGHT
        RIGHT -> DOWN
        DOWN -> LEFT
        LEFT -> UP
    }

    fun nextAnticlockwise() = when(this) {
        UP -> LEFT
        LEFT -> DOWN
        DOWN -> RIGHT
        RIGHT -> UP
    }
}