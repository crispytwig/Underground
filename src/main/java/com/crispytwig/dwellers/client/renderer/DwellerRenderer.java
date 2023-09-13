package com.crispytwig.dwellers.client.renderer;

import com.crispytwig.dwellers.client.model.DwellerModel;
import com.crispytwig.dwellers.entity.Dweller;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.VillagerProfessionLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DwellerRenderer extends MobRenderer<Dweller, DwellerModel<Dweller>> {
    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("dwellers:textures/entity/dweller/dweller.png");


    public DwellerRenderer(EntityRendererProvider.Context ctx) {

        super(ctx, new DwellerModel<>(ctx.bakeLayer(DwellerModel.LAYER_LOCATION)), 0.5F);
        this.addLayer(new CustomHeadLayer<>(this, ctx.getModelSet(), ctx.getItemInHandRenderer()));
        // this.addLayer(new CrossedArmsItemLayer<>(this, ctx.getItemInHandRenderer()));
        this.addLayer(new ItemInHandLayer<>(this, ctx.getItemInHandRenderer()) {
            public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, Dweller dweller, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
                if (dweller.isAggressive()) {
                    super.render(pMatrixStack, pBuffer, pPackedLight, dweller, pLimbSwing, pLimbSwingAmount, pPartialTicks, pAgeInTicks, pNetHeadYaw, pHeadPitch);
                }

            }
        });
    }


    public @NotNull ResourceLocation getTextureLocation(@NotNull Dweller pEntity) {
        return RESOURCE_LOCATION;
    }


    protected void scale(Dweller pLivingEntity, @NotNull PoseStack pMatrixStack, float pPartialTickTime) {
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