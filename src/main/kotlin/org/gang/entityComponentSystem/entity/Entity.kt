package org.gang.entityComponentSystem.entity

import net.minecraft.server.level.ServerLevel
import org.gang.entityComponentSystem.component.nms.ComponentInterface
import kotlin.reflect.KClass

open class Entity(val id : Int,private val entity: net.minecraft.world.entity.Entity,val level: ServerLevel) {
    val componentManager = ComponentManager(entity)

    fun component(scope : ComponentManager.()->Unit): Entity {
        componentManager.scope()
        return this
    }

    fun spawn(){
        entity.setPos(1.0,64.0,1.0)
        level.addFreshEntity(entity)
    }
}

class ComponentManager(val entity: net.minecraft.world.entity.Entity){
    val list = mutableListOf<ComponentInterface>()
    operator fun <T : ComponentInterface> get(clazz : KClass<T>) : T? {
        return list.firstOrNull { clazz.isInstance(it)} as? T
    }
    operator fun ComponentInterface.unaryPlus() {
        list.add(this)
    }

}

var net.minecraft.world.entity.Entity.posX : Double
    get() = this.x
    set(value) {
        this.setPos(value, this.y, this.z)
    }


var net.minecraft.world.entity.Entity.posY : Double
    get() = this.y
    set(value) {
        this.setPos(this.x,value, this.z)
    }


var net.minecraft.world.entity.Entity.posZ : Double
    get() = this.z
    set(value) {
        this.setPos(this.x,this.y,value)
    }
