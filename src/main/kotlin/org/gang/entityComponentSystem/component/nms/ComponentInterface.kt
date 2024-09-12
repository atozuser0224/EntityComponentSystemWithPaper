package org.gang.entityComponentSystem.component.nms

import org.bukkit.entity.Entity
import org.gang.entityComponentSystem.entity.delegate.inter.DelegateInterface
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0

interface ComponentInterface{
    var entity: net.minecraft.world.entity.Entity
    fun <T> delegateEntity(property: KMutableProperty0<T>) : DelegateInterface<T>


}