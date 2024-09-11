package org.gang.entityComponentSystem.component.nms

import org.gang.entityComponentSystem.entity.delegate.inter.DelegateInterface
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty0

interface ComponentInterface{
    fun <T> delegateEntity(property: KMutableProperty0<T>) : DelegateInterface<T>
    fun <T> delegateEntity(kFunction: KFunction<T>) : DelegateInterface<T>
}