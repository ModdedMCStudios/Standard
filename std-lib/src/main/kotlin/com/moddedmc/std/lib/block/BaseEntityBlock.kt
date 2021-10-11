package com.moddedmc.std.lib.block

import com.moddedmc.std.lib.block.entity.BaseBlockEntity
import com.moddedmc.std.lib.util.Side
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityTicker
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

abstract class BaseEntityBlock<T : BaseBlockEntity<T>>(properties: Properties) : BaseBlock(properties), EntityBlock {
    open fun doesTick(side: Side): Boolean = false

    abstract override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): T

    override fun <V : BlockEntity> getTicker(
        level: Level,
        blockState: BlockState,
        blockEntityType: BlockEntityType<V>
    ): BlockEntityTicker<V>? {
        val side = if (level.isClientSide) Side.CLIENT else Side.SERVER
        return if (doesTick(side)) {
            BlockEntityTicker<V> { _, _, _, be -> (be as T).tick(side) }
        } else null
    }
}