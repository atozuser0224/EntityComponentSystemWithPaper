package org.gang.entityComponentSystem.component.inter

import net.minecraft.world.entity.Entity
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.gang.entityComponentSystem.component.nms.ComponentInterface
import org.gang.entityComponentSystem.entity.delegate.nms.NMSEntityDelegate
import org.gang.entityComponentSystem.entity.delegate.nms.NMSEntityFunctionDelegate
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0

open class NMSComponent(entity: EntityType) : ComponentInterface {
    val entity = Bukkit.getWorlds()[0].spawnEntity(Location(Bukkit.getWorlds()[0], 1.0, 1.0, 1.0),entity) as Entity
    override fun <T> delegateEntity(property: KMutableProperty0<T>) : NMSEntityDelegate<T> {
        return NMSEntityDelegate(entity = entity, property0 = property)
    }
    override fun <T> delegateEntity(kFunction: KFunction<T>) : NMSEntityFunctionDelegate<T> {
        return NMSEntityFunctionDelegate(entity = entity, kFunction = kFunction)
    }
}

