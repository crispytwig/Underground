package com.crispytwig.dwellers.client.renderer;

import com.crispytwig.dwellers.client.model.GrubModel;
import com.crispytwig.dwellers.entity.Grub;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class GrubRenderer extends MobRenderer<Grub, GrubModel<Grub>> {
    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("dwellers:textures/entity/grub.png");


    public GrubRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new GrubModel<>(ctx.bakeLayer(GrubModel.LAYER_LOCATION)), 0.5F);
    }


    public @NotNull ResourceLocation getTextureLocation(@NotNull Grub pEntity) {
        return RESOURCE_LOCATION;
    }


    protected void scale(Grub pLivingEntity, @NotNull PoseStack pMatrixStack, float pPartialTickTime) {
        float f = 1.0F;

        pMatrixStack.scale(f, f, f);
    }

}