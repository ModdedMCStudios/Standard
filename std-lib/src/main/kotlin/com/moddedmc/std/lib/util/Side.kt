package com.moddedmc.std.lib.util

enum class Side {
    CLIENT,
    SERVER;

    val isClient by lazy { this == CLIENT }
    val isServer by lazy { this == SERVER }
}