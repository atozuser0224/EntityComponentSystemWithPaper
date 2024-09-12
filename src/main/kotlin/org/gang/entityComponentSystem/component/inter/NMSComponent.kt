package org.gang.entityComponentSystem.component.inter

import net.minecraft.world.entity.Entity
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.gang.entityComponentSystem.component.nms.ComponentInterface
import org.gang.entityComponentSystem.entity.delegate.nms.NMSEntityDelegate
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0

open class NMSComponent(override var entity: Entity) : ComponentInterface {
    override fun <T> delegateEntity(property: KMutableProperty0<T>) : NMSEntityDelegate<T> {
        return NMSEntityDelegate(entity = entity, property0 = property)
    }
}

