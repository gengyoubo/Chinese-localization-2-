
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foxyas.changedaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.foxyas.changedaddon.block.UnifuserBlock;
import net.foxyas.changedaddon.block.PainiteOreBlock;
import net.foxyas.changedaddon.block.PainiteBlockBlock;
import net.foxyas.changedaddon.block.LitixCamoniaFluidBlock;
import net.foxyas.changedaddon.block.LatexInsulatorBlock;
import net.foxyas.changedaddon.block.GeneratorBlock;
import net.foxyas.changedaddon.block.DarklatexpuddleBlock;
import net.foxyas.changedaddon.block.CatlyzerBlock;
import net.foxyas.changedaddon.ChangedAddonMod;

public class ChangedAddonModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChangedAddonMod.MODID);
	public static final RegistryObject<Block> LATEX_INSULATOR = REGISTRY.register("latex_insulator", () -> new LatexInsulatorBlock());
	public static final RegistryObject<Block> PAINITE_ORE = REGISTRY.register("painite_ore", () -> new PainiteOreBlock());
	public static final RegistryObject<Block> PAINITE_BLOCK = REGISTRY.register("painite_block", () -> new PainiteBlockBlock());
	public static final RegistryObject<Block> LITIX_CAMONIA_FLUID = REGISTRY.register("litix_camonia_fluid", () -> new LitixCamoniaFluidBlock());
	public static final RegistryObject<Block> CATLYZER = REGISTRY.register("catlyzer", () -> new CatlyzerBlock());
	public static final RegistryObject<Block> UNIFUSER = REGISTRY.register("unifuser", () -> new UnifuserBlock());
	public static final RegistryObject<Block> DARKLATEXPUDDLE = REGISTRY.register("darklatexpuddle", () -> new DarklatexpuddleBlock());
	public static final RegistryObject<Block> GENERATOR = REGISTRY.register("generator", () -> new GeneratorBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			LatexInsulatorBlock.registerRenderLayer();
			DarklatexpuddleBlock.registerRenderLayer();
		}
	}
}
