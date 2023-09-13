package com.crispytwig.dwellers.client.model;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.crispytwig.dwellers.Dwellers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GrubModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Dwellers.MODID, "grub"), "main");
	private final ModelPart left_legs;
	private final ModelPart right_legs;
	private final ModelPart bb_main;

	public GrubModel(ModelPart root) {
		this.left_legs = root.getChild("left_legs");
		this.right_legs = root.getChild("right_legs");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_legs = partdefinition.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 23.25F, -4.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition left_front_leg = left_legs.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(22, 32).addBox(-1.2706F, 0.0761F, -0.2706F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition left_back_leg = left_legs.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(22, 32).addBox(-0.2706F, 0.0761F, 0.2706F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition left_middle_leg = left_legs.addOrReplaceChild("left_middle_leg", CubeListBuilder.create().texOffs(22, 32).addBox(-0.3827F, 0.0761F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition right_legs = partdefinition.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5F, 23.25F, -4.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_front_leg = right_legs.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(22, 32).mirror().addBox(-1.7294F, 0.0761F, -0.2706F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition right_back_leg = right_legs.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(22, 32).mirror().addBox(-2.7294F, 0.0761F, 0.2706F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition right_middle_leg = right_legs.addOrReplaceChild("right_middle_leg", CubeListBuilder.create().texOffs(22, 32).mirror().addBox(-2.6173F, 0.0761F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -4.0F, -8.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(-4, 30).addBox(-4.0F, -1.0F, -11.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}