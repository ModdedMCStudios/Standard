package com.moddedmc.std.lib

import net.minecraft.core.Registry
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraft.world.level.block.Block

val ItemStack.isNotEmpty
    get() = !isEmpty

operator fun ItemStack.plusAssign(count: Int) = grow(count)
operator fun ItemStack.minusAssign(count: Int) = shrink(count)

fun ItemStack.getEnchantmentLevel(enchantment: Enchantment): Int =
    EnchantmentHelper.getItemEnchantmentLevel(enchantment, this)

operator fun ItemStack.contains(enchantment: Enchantment): Boolean = getEnchantmentLevel(enchantment) > 0

val Block.identifier
    get() = Registry.BLOCK.getKey(this)
val Item.identifier
    get() = Registry.ITEM.getKey(this)