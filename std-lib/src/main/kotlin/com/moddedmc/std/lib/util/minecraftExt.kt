package com.moddedmc.std.lib.util

import net.minecraft.core.BlockPos
import net.minecraft.core.Registry
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntity

val ItemStack.isNotEmpty
    get() = !isEmpty

operator fun ItemStack.plusAssign(count: Int) = grow(count)
operator fun ItemStack.minusAssign(count: Int) = shrink(count)

fun ItemStack.getEnchantmentLevel(enchantment: Enchantment): Int =
    EnchantmentHelper.getItemEnchantmentLevel(enchantment, this)

operator fun ItemStack.contains(enchantment: Enchantment): Boolean = getEnchantmentLevel(enchantment) > 0

inline fun <reified T : BlockEntity> LevelReader.getBlockEntity(pos: BlockPos): T? {
    val be = getBlockEntity(pos)
    return if (be is T) be else null
}

val Block.identifier
    get() = Registry.BLOCK.getKey(this)
val Item.identifier
    get() = Registry.ITEM.getKey(this)
val Level.isClient
    get() = isClientSide
val Level.isServer
    get() = !isClientSide