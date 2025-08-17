package org.mattev02.kotetris

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform