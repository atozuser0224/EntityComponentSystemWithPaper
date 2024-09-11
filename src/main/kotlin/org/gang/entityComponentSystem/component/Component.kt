package org.gang.entityComponentSystem.component

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.gang.entityComponentSystem.component.nms.ComponentInterface
import org.gang.entityComponentSystem.entity.delegate.EntityDelegate
import org.gang.entityComponentSystem.entity.delegate.EntityFunctionDelegate
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0

open class Component(entity: EntityType) : ComponentInterface{
    val entity = Bukkit.getWorlds()[0].spawnEntity(Location(Bukkit.getWorlds()[0], 1.0, 1.0, 1.0),entity)
    override fun <T> delegateEntity(property: KMutableProperty0<T>) : EntityDelegate<T> {
        return EntityDelegate(entity = entity, property0 = property)
    }
    override fun <T> delegateEntity(kFunction: KFunction<T>) : EntityFunctionDelegate<T> {
        return EntityFunctionDelegate(entity = entity, kFunction = kFunction)
    }
}