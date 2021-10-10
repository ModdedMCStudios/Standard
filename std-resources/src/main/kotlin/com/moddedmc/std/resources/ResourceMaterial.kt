package com.moddedmc.std.resources

import java.util.*
import java.util.regex.Pattern

data class ResourceMaterial internal constructor(val id: String) {
    companion object {
        private val VALID_NAME = Pattern.compile("[^a-z_]")
        private val MATERIALS: MutableMap<String, ResourceMaterial> = TreeMap()

        operator fun invoke(id: String): ResourceMaterial {
            require(!VALID_NAME.matcher(id).matches()) { "Material id must be [^a-z_], got $id" }
            return MATERIALS.computeIfAbsent(id, ::ResourceMaterial)
        }
    }
}
