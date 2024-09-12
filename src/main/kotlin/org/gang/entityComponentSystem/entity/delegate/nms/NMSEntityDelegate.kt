package org.gang.entityComponentSystem.entity.delegate.nms

import net.minecraft.world.entity.Entity
import org.gang.entityComponentSystem.entity.delegate.inter.DelegateInterface
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty
class NMSEntityDelegate<T>(
    private val entity: Entity,
    private val property0: KMutableProperty0<T>
) : DelegateInterface<T> {

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // 'getter.call' 대신 'property0.get()'을 사용합니다.
        return property0.get()
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        // 'setter.call' 대신 'property0.set(value)'을 사용합니다.
        property0.set(value)
    }
}