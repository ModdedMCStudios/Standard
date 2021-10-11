package com.moddedmc.std.power.block.entity

import com.moddedmc.std.lib.block.entity.AdvancedBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class PoweredBlockEntity<T : PoweredBlockEntity<T>>(
    blockEntityType: BlockEntityType<*>,
    blockPos: BlockPos,
    blockState: BlockState
) : AdvancedBlockEntity<T>(blockEntityType, blockPos, blockState) {
}