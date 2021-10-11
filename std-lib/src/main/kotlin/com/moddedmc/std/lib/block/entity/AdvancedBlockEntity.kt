package com.moddedmc.std.lib.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

open class AdvancedBlockEntity<T : AdvancedBlockEntity<T>>(
    blockEntityType: BlockEntityType<*>,
    blockPos: BlockPos,
    blockState: BlockState
) : BaseBlockEntity<T>(blockEntityType, blockPos, blockState) {
    override fun tickServer() {

    }
}