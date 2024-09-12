package org.gang.entityComponentSystem.entity.delegate.inter

import kotlin.reflect.KProperty

interface DelegateInterface<T> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T)
}
