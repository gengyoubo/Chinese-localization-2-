package net.foxyas.changedaddon.procedures;

import net.minecraft.world.entity.Entity;

public class FoxyasguiThisGUIIsClosedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("FoxyasGui_open", false);
	}
}
