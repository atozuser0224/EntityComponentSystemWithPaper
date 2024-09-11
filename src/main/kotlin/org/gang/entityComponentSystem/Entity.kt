package org.gang.entityComponentSystem

import org.gang.entityComponentSystem.component.nms.ComponentInterface

open class Entity(val id : Int) {
    val componentManager = ComponentManager()

    fun component(scope : ComponentManager.()->Unit): Entity {
        componentManager.scope()
        return this
    }
}

class ComponentManager(){
    private val list = mutableListOf<ComponentInterface>()

    operator fun ComponentInterface.unaryPlus() {
        list.add(this)
    }

}
fun entity(id : Int) : Entity = Entity(id)
fun test(){
    val entity = entity(1)
        .component {
        + TestNMS("Test")
        + Test("test2")
        }
}