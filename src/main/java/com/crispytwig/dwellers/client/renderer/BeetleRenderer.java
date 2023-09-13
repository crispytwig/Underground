package com.crispytwig.dwellers.client.renderer;

import com.crispytwig.dwellers.client.model.BeetleModel;
import com.crispytwig.dwellers.entity.Beetle;
import com.crispytwig.dwellers.entity.Dweller;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class BeetleRenderer extends MobRenderer<Beetle, BeetleModel<Beetle>> {
    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("dwellers:textures/entity/beetle.png");


    public BeetleRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new BeetleModel<>(ctx.bakeLayer(BeetleModel.LAYER_LOCATION)), 0.5F);
    }


    public @NotNull ResourceLocation getTextureLocation(@NotNull Beetle pEntity) {
        return RESOURCE_LOCATION;
    }


    protected void scale(Beetle pLivingEntity, @NotNull PoseStack pMatrixStack, float pPartialTickTime) {
        float f = 0.9375F;
        if (pLivingEntity.isBaby()) {
            f *= 0.5F;
            this.shadowRadius = 0.25F;
        } else {
            this.shadowRadius = 0.5F;
        }

        pMatrixStack.scale(f, f, f);
    }

}