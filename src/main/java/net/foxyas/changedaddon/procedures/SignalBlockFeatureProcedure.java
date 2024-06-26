package net.foxyas.changedaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.foxyas.changedaddon.init.ChangedAddonModItems;
import net.foxyas.changedaddon.init.ChangedAddonModBlocks;

public class SignalBlockFeatureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ChangedAddonModItems.SIGNAL_CATCHER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ChangedAddonModItems.SIGNAL_CATCHER.get()) {
			if (!(entity instanceof Player _player ? _player.getCooldowns().isOnCooldown(ChangedAddonModItems.SIGNAL_CATCHER.get()) : false)) {
				if (entity.isShiftKeyDown()) {
					sx = -64;
					found = false;
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("\u00A7o\u00A7n\u00A7bSuper Scam"), true);
					for (int index0 = 0; index0 < 128; index0++) {
						sy = -64;
						for (int index1 = 0; index1 < 128; index1++) {
							sz = -64;
							for (int index2 = 0; index2 < 128; index2++) {
								if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ChangedAddonModBlocks.SIGNAL_BLOCK.get()) {
									found = true;
									if (found == true) {
										if (entity instanceof Player _player && !_player.level.isClientSide())
											_player.displayClientMessage(new TextComponent(("Location Found in " + Math.floor(x + sx) + " " + Math.floor(y + sy) + " " + Math.floor(z + sz))), false);
										itemstack.getOrCreateTag().putDouble("x", Math.floor(x + sx));
										itemstack.getOrCreateTag().putDouble("y", Math.floor(y + sy));
										itemstack.getOrCreateTag().putDouble("z", Math.floor(z + sz));
										itemstack.getOrCreateTag().putBoolean("set", true);
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.BLOCKS, (float) 1.5, 0);
											} else {
												_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.BLOCKS, (float) 1.5, 0, false);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.PLAYERS, (float) 1.5, 0);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.PLAYERS, (float) 1.5, 0, false);
											}
										}
									}
									break;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				} else {
					sx = -32;
					found = false;
					for (int index3 = 0; index3 < 64; index3++) {
						sy = -32;
						for (int index4 = 0; index4 < 64; index4++) {
							sz = -32;
							for (int index5 = 0; index5 < 64; index5++) {
								if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ChangedAddonModBlocks.SIGNAL_BLOCK.get()) {
									found = true;
									if (found == true) {
										if (entity instanceof Player _player && !_player.level.isClientSide())
											_player.displayClientMessage(new TextComponent(("Location Found in " + Math.floor(x + sx) + " " + Math.floor(y + sy) + " " + Math.floor(z + sz))), false);
										itemstack.getOrCreateTag().putDouble("x", Math.floor(x + sx));
										itemstack.getOrCreateTag().putDouble("y", Math.floor(y + sy));
										itemstack.getOrCreateTag().putDouble("z", Math.floor(z + sz));
										itemstack.getOrCreateTag().putBoolean("set", true);
										if (entity instanceof Player _player)
											_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.BLOCKS, (float) 1.5, 0);
											} else {
												_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.BLOCKS, (float) 1.5, 0, false);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.PLAYERS, (float) 1.5, 0);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.PLAYERS, (float) 1.5, 0, false);
											}
										}
									}
									break;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			}
		}
	}
}
