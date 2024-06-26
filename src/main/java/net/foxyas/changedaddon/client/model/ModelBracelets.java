package net.foxyas.changedaddon.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBracelets<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("changed_addon", "model_bracelets"), "main");
	public final ModelPart Body;
	public final ModelPart Bracelets;
	public final ModelPart RightArmBracelet;
	public final ModelPart LeftArmBracelet;

	public ModelBracelets(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Bracelets = root.getChild("Bracelets");
		this.RightArmBracelet = Bracelets.getChild("RightArmBracelet");
		this.LeftArmBracelet = Bracelets.getChild("LeftArmBracelet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));
		PartDefinition Bracelets = partdefinition.addOrReplaceChild("Bracelets", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightArmBracelet = Bracelets.addOrReplaceChild("RightArmBracelet", CubeListBuilder.create().texOffs(16, 10).addBox(-4.0F, 6.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.08F)).texOffs(12, 27)
				.addBox(-4.425F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.08F)).texOffs(18, 29).addBox(-4.575F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.08F)), PartPose.offset(-4.0F, 2.0F, 0.0F));
		PartDefinition LeftArmBracelet = Bracelets.addOrReplaceChild("LeftArmBracelet", CubeListBuilder.create().texOffs(18, 27).addBox(3.375F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.08F)).texOffs(12, 23)
				.addBox(3.425F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.08F)).texOffs(18, 29).mirror().addBox(3.575F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.08F)).mirror(false), PartPose.offset(4.0F, 2.0F, 0.0F));
		PartDefinition LeftArmBracelet_r1 = LeftArmBracelet.addOrReplaceChild("LeftArmBracelet_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.08F)),
				PartPose.offsetAndRotation(2.0F, 7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bracelets.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
