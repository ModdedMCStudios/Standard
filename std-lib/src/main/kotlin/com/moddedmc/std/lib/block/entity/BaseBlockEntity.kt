package com.moddedmc.std.lib.block.entity

import com.moddedmc.std.lib.util.Side
import com.moddedmc.std.lib.util.isClient
import com.moddedmc.std.lib.util.isServer
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

open class BaseBlockEntity<T : BaseBlockEntity<T>>(
    blockEntityType: BlockEntityType<*>,
    blockPos: BlockPos,
    blockState: BlockState
) : BlockEntity(blockEntityType, blockPos, blockState) {
    protected val world: Level
        get() = level!!

    protected val isClient: Boolean
        get() = world.isClient
    protected val isServer: Boolean
        get() = world.isServer

    open fun tickClient() {
        error("${javaClass.simpleName} is marked as server tickable but does not override tickServer")
    }

    open fun tickServer() {
        error("${javaClass.simpleName} is marked as server tickable but does not override tickServer")
    }

    fun tick(side: Side) = if (side.isClient) tickClient() else tickServer()
}