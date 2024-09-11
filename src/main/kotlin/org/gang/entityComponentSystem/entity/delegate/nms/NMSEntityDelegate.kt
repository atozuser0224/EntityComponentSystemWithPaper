package org.gang.entityComponentSystem.entity.delegate.nms

import net.minecraft.world.entity.Entity
import org.gang.entityComponentSystem.entity.delegate.inter.DelegateInterface
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

class NMSEntityDelegate<T>(private val entity: Entity, private val property0: KMutableProperty0<T>) : DelegateInterface<T> {
    override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return property0.getter.call(entity)
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        property0.setter.call(entity, value)
    }
}


class NMSEntityFunctionDelegate<T>(private val entity: Entity, private val kFunction: KFunction<T>) : DelegateInterface<T> {
    override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return kFunction.call(entity)
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        kFunction.call(entity, value)
    }
}
