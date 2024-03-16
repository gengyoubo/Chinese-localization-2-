package net.foxyas.changedaddon.procedures;

import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.foxyas.changedaddon.init.ChangedAddonModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.tom.cpm.client.PlayerRenderManager.entity;

@Mod.EventBusSubscriber
public class LatexTotemKeepConcienceProcedure {
	@SubscribeEvent
	public static void execute(ProcessTransfur.KeepConsciousEvent event) {
		if (event.player == null)
			return;
		if (event.player.getInventory().contains(new ItemStack(ChangedAddonModItems.TRANSFUR_TOTEM.get()))) {
			if (!event.keepConscious) {
				event.shouldKeepConscious = true;
				if (!event.player.level.isClientSide())
					event.player.displayClientMessage(new TextComponent("§o§n§l§3§n I Don't gonna let you die for that!"), false);
			}
		}
	}
}
