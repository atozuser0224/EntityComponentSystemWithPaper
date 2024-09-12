package org.gang.entityComponentSystem


import net.minecraft.world.entity.EntityType
import org.bukkit.plugin.java.JavaPlugin
import org.gang.entityComponentSystem.component.inter.NMSComponent
import org.gang.entityComponentSystem.entity.posX
import org.gang.entityComponentSystem.entity.posY
import org.gang.entityComponentSystem.entity.posZ

class EntityComponentSystem : JavaPlugin() {

    override fun onEnable() {

        val entity = ecs.world.entity(EntityType.ZOMBIE)
            .component {
                + LocationComponent(entity).apply {
                    x = 10.0
                    y = 10.0
                    z = 10.0
                }
            }
        entity.spawn()


    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}


class LocationComponent(entity: net.minecraft.world.entity.Entity): NMSComponent(entity){
    var x : Double by delegateEntity(entity::posX)
    var y : Double by delegateEntity(entity::posY)
    var z : Double by delegateEntity(entity::posZ)
}
