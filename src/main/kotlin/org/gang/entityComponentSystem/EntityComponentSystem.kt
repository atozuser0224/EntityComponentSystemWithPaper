package org.gang.entityComponentSystem

import org.bukkit.entity.EntityType
import org.bukkit.plugin.java.JavaPlugin
import org.gang.entityComponentSystem.component.Component
import org.gang.entityComponentSystem.component.inter.NMSComponent

class EntityComponentSystem : JavaPlugin() {

    override fun onEnable() {

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}

class Test(
    val str : String
) : Component(EntityType.ZOMBIE){
    val a : Double by delegateEntity(entity::getX)
}



class TestNMS(
    val str : String
) : NMSComponent(EntityType.ZOMBIE){
    val a : Double by delegateEntity(entity::getEyeY)
}

