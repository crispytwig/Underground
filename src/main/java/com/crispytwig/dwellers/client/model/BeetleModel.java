package com.crispytwig.dwellers.client.model;


import com.crispytwig.dwellers.Dwellers;
import com.crispytwig.dwellers.client.animation.BeetleAnimation;
import com.crispytwig.dwellers.entity.Beetle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BeetleModel <T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Dwellers.MODID, "beetle"), "main");
	private final ModelPart left_legs;
	private final ModelPart right_legs;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftFrontLeg;
	private final ModelPart leftMiddleLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart rightMiddleLeg;
	private final ModelPart rightHindLeg;

	public BeetleModel(ModelPart root) {
		this.left_legs = root.getChild("left_legs");
		this.right_legs = root.getChild("right_legs");
		this.head = root.getChild("head");
		this.body = root.getChild("body");


		this.leftFrontLeg = this.left_legs.getChild("left_front_leg");
		this.leftMiddleLeg = this.left_legs.getChild("left_middle_leg");
		this.leftHindLeg = this.left_legs.getChild("left_back_leg");
		this.rightFrontLeg = this.right_legs.getChild("right_front_leg");
		this.rightMiddleLeg = this.right_legs.getChild("right_middle_leg");
		this.rightHindLeg = this.right_legs.getChild("right_back_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_legs = partdefinition.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition left_front_leg = left_legs.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(21, 31).addBox(-0.2706F, -1.9239F, -1.2706F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition left_back_leg = left_legs.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(21, 31).addBox(-0.2706F, -1.9239F, -0.7294F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition left_middle_leg = left_legs.addOrReplaceChild("left_middle_leg", CubeListBuilder.create().texOffs(21, 31).addBox(-0.3827F, -1.9239F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition right_legs = partdefinition.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_front_leg = right_legs.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(21, 31).mirror().addBox(-7.7294F, -1.9239F, -1.2706F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition right_back_leg = right_legs.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(21, 31).mirror().addBox(-7.7294F, -1.9239F, -0.7294F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition right_middle_leg = right_legs.addOrReplaceChild("right_middle_leg", CubeListBuilder.create().texOffs(21, 31).mirror().addBox(-7.6173F, -1.9239F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 35).addBox(-1.0F, -6.75F, -4.75F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(42, 22).addBox(-5.0F, -11.75F, -3.75F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(-3.0F, -2.75F, -3.75F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(-4, 30).addBox(-5.0F, 0.25F, -6.75F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.75F, -4.25F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.0F, -4.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -12.0F, -4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.body;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(Beetle.walkAnimationState, BeetleAnimation.WALK, pAgeInTicks);
	}
}