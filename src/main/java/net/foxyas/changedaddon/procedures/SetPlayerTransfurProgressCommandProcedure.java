package net.foxyas.changedaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetPlayerTransfurProgressCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double Number = 0;
		Entity EntityTarget = null;
		Number = DoubleArgumentType.getDouble(arguments, "Number");
		EntityTarget = new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "Target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity();
		if (entity == entity) {
			AddTransfurProgressProcedure.set(EntityTarget, Number);
		}
	}
}
