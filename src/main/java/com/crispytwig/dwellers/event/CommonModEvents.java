package com.crispytwig.dwellers.event;

import com.crispytwig.dwellers.Dwellers;
import com.crispytwig.dwellers.entity.Beetle;
import com.crispytwig.dwellers.entity.Dweller;
import com.crispytwig.dwellers.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Dwellers.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.DWELLER.get(), Dweller.createAttributes().build());
        event.put(EntityInit.BEETLE.get(), Beetle.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(EntityInit.DWELLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Dweller::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        // OR specifies "that placement OR this placement" if a placement already exists.
    }
}
