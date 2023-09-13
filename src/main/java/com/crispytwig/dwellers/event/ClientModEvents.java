package com.crispytwig.dwellers.event;

import com.crispytwig.dwellers.Dwellers;
import com.crispytwig.dwellers.client.model.BeetleModel;
import com.crispytwig.dwellers.client.model.DwellerModel;
import com.crispytwig.dwellers.client.model.GrubModel;
import com.crispytwig.dwellers.client.renderer.BeetleRenderer;
import com.crispytwig.dwellers.client.renderer.DwellerRenderer;
import com.crispytwig.dwellers.client.renderer.GrubRenderer;
import com.crispytwig.dwellers.entity.Dweller;
import com.crispytwig.dwellers.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Dwellers.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.DWELLER.get(), DwellerRenderer::new);
        event.registerEntityRenderer(EntityInit.BEETLE.get(), BeetleRenderer::new);
        event.registerEntityRenderer(EntityInit.GRUB.get(), GrubRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DwellerModel.LAYER_LOCATION, DwellerModel::createBodyLayer);
        event.registerLayerDefinition(BeetleModel.LAYER_LOCATION, BeetleModel::createBodyLayer);
        event.registerLayerDefinition(GrubModel.LAYER_LOCATION, GrubModel::createBodyLayer);
    }
}
