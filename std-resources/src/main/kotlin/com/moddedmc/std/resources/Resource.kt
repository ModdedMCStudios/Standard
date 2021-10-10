package com.moddedmc.std.resources

import net.minecraft.resources.ResourceLocation
import java.util.*
import kotlin.reflect.KProperty

class Resource<C>(val material: ResourceMaterial, val type: ResourceType<C>, comparator: Comparator<Variant<C>>) {
    private val variants: SortedSet<Variant<C>> = TreeSet(comparator)
    private var chosenVariant: Variant<C>? = null

    fun get(): Variant<C> {
        if (chosenVariant == null) chosenVariant = variants.first()
        return chosenVariant!!
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Variant<C> = get()

    fun addVariant(variant: Variant<C>) = variants.add(variant)
}

data class Variant<C>(val id: ResourceLocation, val supplier: () -> C) {
    operator fun invoke(): C = supplier()
}