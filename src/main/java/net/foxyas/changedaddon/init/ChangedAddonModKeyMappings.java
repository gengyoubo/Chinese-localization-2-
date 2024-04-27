
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.foxyas.changedaddon.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.foxyas.changedaddon.network.TurnOffTransfurMessage;
import net.foxyas.changedaddon.network.PatKeyMessage;
import net.foxyas.changedaddon.network.OpengrabescapeguiMessage;
import net.foxyas.changedaddon.network.OpenExtraDetailsMessage;
import net.foxyas.changedaddon.network.LeapKeyMessage;
import net.foxyas.changedaddon.network.DuctProneMessage;
import net.foxyas.changedaddon.ChangedAddonMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ChangedAddonModKeyMappings {
	public static final KeyMapping OPENGRABESCAPEGUI = new KeyMapping("key.changed_addon.opengrabescapegui", GLFW.GLFW_KEY_B, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new OpengrabescapeguiMessage(0, 0));
				OpengrabescapeguiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_EXTRA_DETAILS = new KeyMapping("key.changed_addon.open_extra_details", GLFW.GLFW_KEY_J, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new OpenExtraDetailsMessage(0, 0));
				OpenExtraDetailsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DUCT_PRONE = new KeyMapping("key.changed_addon.duct_prone", GLFW.GLFW_KEY_V, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new DuctProneMessage(0, 0));
				DuctProneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				DUCT_PRONE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - DUCT_PRONE_LASTPRESS);
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new DuctProneMessage(1, dt));
				DuctProneMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LEAP_KEY = new KeyMapping("key.changed_addon.leap_key", GLFW.GLFW_KEY_C, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new LeapKeyMessage(0, 0));
				LeapKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TURN_OFF_TRANSFUR = new KeyMapping("key.changed_addon.turn_off_transfur", GLFW.GLFW_KEY_UNKNOWN, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new TurnOffTransfurMessage(0, 0));
				TurnOffTransfurMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PAT_KEY = new KeyMapping("key.changed_addon.pat_key", GLFW.GLFW_KEY_UNKNOWN, "key.categories.changed_addon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedAddonMod.PACKET_HANDLER.sendToServer(new PatKeyMessage(0, 0));
				PatKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long DUCT_PRONE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(OPENGRABESCAPEGUI);
		ClientRegistry.registerKeyBinding(OPEN_EXTRA_DETAILS);
		ClientRegistry.registerKeyBinding(DUCT_PRONE);
		ClientRegistry.registerKeyBinding(LEAP_KEY);
		ClientRegistry.registerKeyBinding(TURN_OFF_TRANSFUR);
		ClientRegistry.registerKeyBinding(PAT_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				OPENGRABESCAPEGUI.consumeClick();
				OPEN_EXTRA_DETAILS.consumeClick();
				DUCT_PRONE.consumeClick();
				LEAP_KEY.consumeClick();
				TURN_OFF_TRANSFUR.consumeClick();
				PAT_KEY.consumeClick();
			}
		}
	}
}
