
package net.foxyas.changedaddon.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.client.model.BioSynthSnowLeopardMaleModel;
import net.foxyas.changedaddon.client.model.SnowLeopardPartialModel;
import net.foxyas.changedaddon.entity.SnowLeopardPartialEntity;
import net.ltxprogrammer.changed.client.renderer.LatexHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleCatModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.Random;

public class SnowLeopardPartialRenderer extends LatexHumanoidRenderer<SnowLeopardPartialEntity, SnowLeopardPartialModel, ArmorLatexMaleCatModel<SnowLeopardPartialEntity>> {


	/*public SnowLeopardPartialRenderer(EntityRendererProvider.Context context) {
		super(context, SnowLeopardPartialModel.human(context.bakeLayer(SnowLeopardPartialModel.LAYER_LOCATION_HUMAN)),
				ArmorLatexMaleCatModel::new, ArmorLatexMaleCatModel.INNER_ARMOR, ArmorLatexMaleCatModel.OUTER_ARMOR, 0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, getModel()));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor,CustomEyesLayer::glowingIrisColorLeft,CustomEyesLayer::glowingIrisColorRight));
		this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
	}*/

	public SnowLeopardPartialRenderer(EntityRendererProvider.Context context, boolean slim) {
		super(context, SnowLeopardPartialModel.human(context.bakeLayer(
						slim ? SnowLeopardPartialModel.LAYER_LOCATION_HUMAN_SLIM : SnowLeopardPartialModel.LAYER_LOCATION_HUMAN)),
				ArmorLatexMaleCatModel::new, ArmorLatexMaleCatModel.INNER_ARMOR, ArmorLatexMaleCatModel.OUTER_ARMOR, 0.5f);
		var partialModel = new LatexPartialLayer<>(this, SnowLeopardPartialModel.latex(
				context.bakeLayer(slim ? SnowLeopardPartialModel.LAYER_LOCATION_LATEX_SLIM : SnowLeopardPartialModel.LAYER_LOCATION_LATEX)),
				slim ? new ResourceLocation("changed_addon", "snow_leopard_partial_slim") : new ResourceLocation("changed_addon", "snow_leopard_partial"));
		this.addLayer(partialModel);
		this.addLayer(new LatexParticlesLayer<>(this).addModel(partialModel.getModel(), entity -> partialModel.getTexture()));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new DarkLatexMaskLayer<>(this, context.getModelSet()));
		this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(SnowLeopardPartialEntity partial) {
		return partial.getSkinTextureLocation();
	}

	@Override
	public void render(SnowLeopardPartialEntity latex, float yRot, float p_115457_, PoseStack p_115458_, MultiBufferSource bufferSource, int p_115460_) {
		if (latex.getUnderlyingPlayer() instanceof AbstractClientPlayer clientPlayer)
			this.model.setModelProperties(clientPlayer);
		else
			this.model.defaultModelProperties();
		super.render(latex, yRot, p_115457_, p_115458_, bufferSource, p_115460_);
	}

	@Override
	protected void scale(SnowLeopardPartialEntity entity, PoseStack pose, float partialTick) {
		float f = 0.9375F;
		pose.scale(0.9375F, 0.9375F, 0.9375F);
	}
}