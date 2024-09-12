package org.gang.entityComponentSystem.world

import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.Level
import org.gang.entityComponentSystem.ECSSystem
import org.gang.entityComponentSystem.LocationComponent
import org.gang.entityComponentSystem.entity.Entity


class ECSWorld(private val ecsSystem: ECSSystem, val level: ServerLevel) {


    fun <T : net.minecraft.world.entity.Entity> entity(type : EntityType<T>): Entity {
        val entityImpl = type.create(level)?: throw IllegalArgumentException("stop")
        val ent = Entity(ecsSystem.entityList.size,entityImpl,level)
        ecsSystem.entityList.add(ent)
        return ent
    }

}