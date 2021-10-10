package com.moddedmc.std.resources

import net.minecraft.world.item.ItemStack
import java.util.*
import java.util.regex.Pattern

data class ResourceType<C> internal constructor(
    val id: String,
    val defaultCreator: (ResourceMaterial) -> C,
    val stackFunction: (C) -> ItemStack
) {
    companion object {
        private val VALID_NAME = Pattern.compile("[^a-z_]")
        private val TYPES: MutableMap<String, ResourceType<*>> = TreeMap()

        operator fun <C> invoke(
            id: String, defaultCreator: (ResourceMaterial) -> C,
            stackFunction: (C) -> ItemStack
        ): ResourceType<C> {
            require(!VALID_NAME.matcher(id).matches()) { "Type id must be [^a-z_], got $id" }
            return TYPES.computeIfAbsent(id) {
                ResourceType(id, defaultCreator, stackFunction)
            } as ResourceType<C>
        }

        operator fun <X> invoke(id: String): ResourceType<X>? {
            return TYPES[id] as ResourceType<X>?
        }
    }
}
