package org.gang.entityComponentSystem

import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.Level
import org.bukkit.World
import org.bukkit.craftbukkit.CraftWorld
import org.bukkit.plugin.java.JavaPlugin
import org.gang.entityComponentSystem.entity.Entity
import org.gang.entityComponentSystem.world.ECSWorld

class ECSSystem(val plugin: JavaPlugin) {
    val entityList = mutableListOf<Entity>()

    val world : ECSWorld
        get() = ECSWorld(this,(plugin.server.getWorld("world") as CraftWorld).handle)
    val netherWorld : ECSWorld
        get() = ECSWorld(this,(plugin.server.getWorld("world_nether") as CraftWorld).handle)
    val enderWorld : ECSWorld
        get() = ECSWorld(this,(plugin.server.getWorld("world_the_end") as CraftWorld).handle)
}

val JavaPlugin.ecs: ECSSystem
    get() = ECSSystem(this)