package net.foxyas.changedaddon.procedures;

import net.ltxprogrammer.changed.entity.variant.LatexVariant;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AddTransfurProgressProcedure {
	public static void add(Entity entity,float amount) {
		if (entity == null) {
			return;
		}

		if (entity instanceof Player player){
			if (ProcessTransfur.getPlayerTransfurProgress(player).variant() != null){
			ProcessTransfur.progressTransfur(player,amount, ProcessTransfur.getPlayerTransfurProgress(player).variant());
			}else {
			ProcessTransfur.progressTransfur(player,amount, LatexVariant.FALLBACK_VARIANT);
			}
		}
	}

	public static void set(Entity entity, float Amount){
		if (entity == null){
			return;
		}

		if (entity instanceof Player _entity) {
			ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(Amount,//amount
		/*Variant Check*/ProcessTransfur.getPlayerTransfurProgress(_entity).variant() == null ? LatexVariant.FALLBACK_VARIANT : ProcessTransfur.getPlayerTransfurProgress(_entity).variant());
			ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
		}

	}

	public static void set(Entity entity, double Amount){
		if (entity == null){
			return;
		}
		float FAmount = (float) Amount;
		if (entity instanceof Player _entity) {
			ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(FAmount,//amount
					/*Variant Check*/ProcessTransfur.getPlayerTransfurProgress(_entity).variant() == null ? LatexVariant.FALLBACK_VARIANT : ProcessTransfur.getPlayerTransfurProgress(_entity).variant());
			ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
		}

	}

	public static void minus(Entity entity,float amount) {
		if (entity == null) {
			return;
		}
		float negative = -amount;
		if (entity instanceof Player player){
			if (ProcessTransfur.getPlayerTransfurProgress(player).variant() != null){
				ProcessTransfur.progressTransfur(player,negative, ProcessTransfur.getPlayerTransfurProgress(player).variant());
			}else {
				ProcessTransfur.progressTransfur(player,negative, LatexVariant.FALLBACK_VARIANT);
			}
		}
	}

	public static void minus(Entity entity,double amount) {
		if (entity == null) {
			return;
		}
		float negative = (float) -amount;
		if (entity instanceof Player player){
			if (ProcessTransfur.getPlayerTransfurProgress(player).variant() != null){
				ProcessTransfur.progressTransfur(player,negative, ProcessTransfur.getPlayerTransfurProgress(player).variant());
			}else {
				ProcessTransfur.progressTransfur(player,negative, LatexVariant.FALLBACK_VARIANT);
			}
		}
	}

	public static void setminus(Entity entity, float Amount){
		if (entity == null){
			return;
		}
		float negative = (float) -Amount;
		if (entity instanceof Player _entity) {
			if (ProcessTransfur.getPlayerTransfurProgress(_entity) != null){
			float Progress = ProcessTransfur.getPlayerTransfurProgress(_entity).progress();
			LatexVariant Variant = ProcessTransfur.getPlayerTransfurProgress(_entity).variant();

			ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(Progress + negative,//amount
					/*Variant Check*/ProcessTransfur.getPlayerTransfurProgress(_entity).variant() == null ? LatexVariant.FALLBACK_VARIANT : ProcessTransfur.getPlayerTransfurProgress(_entity).variant());
			ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
		}
		}

	}

	public static void setminus(Entity entity, double Amount){
		if (entity == null){
			return;
		}
		float FAmount = (float) -Amount;
		if (entity instanceof Player _entity) {
			if (ProcessTransfur.getPlayerTransfurProgress(_entity) != null){
				float Progress = ProcessTransfur.getPlayerTransfurProgress(_entity).progress();
				LatexVariant Variant = ProcessTransfur.getPlayerTransfurProgress(_entity).variant();

			ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(Progress + FAmount,//amount
					/*Variant Check*/ProcessTransfur.getPlayerTransfurProgress(_entity).variant() == null ? LatexVariant.FALLBACK_VARIANT : ProcessTransfur.getPlayerTransfurProgress(_entity).variant());
			ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
			}
		}

	}

	public static void Exp009LatexDmg(Entity entity,double amountB) {
		if (entity == null) {
			return;
		}
		if (entity instanceof Player player){
			if (ProcessTransfur.getPlayerTransfurProgress(player).variant() != null){
		float amount = (float) amountB + ProcessTransfur.getPlayerTransfurProgress(player).progress();
		ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(amount,//amount
		/*Variant Check*/ProcessTransfur.getPlayerTransfurProgress(player).variant() != LatexVariant.LIGHT_LATEX_WOLF.male() ? LatexVariant.LIGHT_LATEX_WOLF.male() : ProcessTransfur.getPlayerTransfurProgress(player).variant());
		ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
			} else {
				float amount = (float) amountB + ProcessTransfur.getPlayerTransfurProgress(player).progress();
				ProcessTransfur.TransfurProgress transfurProgress = new ProcessTransfur.TransfurProgress(amount,//amount
						/*Variant Check*/LatexVariant.LIGHT_LATEX_WOLF.male());
				ProcessTransfur.setPlayerTransfurProgress((Player) entity, transfurProgress);
			}
		}
	}
}