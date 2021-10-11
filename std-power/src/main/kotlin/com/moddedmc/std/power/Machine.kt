package com.moddedmc.std.power

interface Machine {
    val active: Boolean
    val paused: Boolean

    fun canAcceptAugment(augment: Augment): Boolean

    operator fun contains(augment: Augment): Boolean
}