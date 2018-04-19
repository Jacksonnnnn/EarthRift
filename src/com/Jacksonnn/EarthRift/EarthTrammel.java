package com.Jacksonnn.EarthTrammel;

import com.projectkorra.projectkorra.ability.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.permissions.*;
import org.bukkit.event.player.*;
import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ProjectKorra;
import java.util.ArrayList;
import com.projectkorra.projectkorra.ability.util.ComboManager.AbilityInformation;
import com.projectkorra.projectkorra.ability.util.MultiAbilityManager.MultiAbilityInfoSub;
import com.projectkorra.projectkorra.configuration.ConfigManager;
import com.projectkorra.projectkorra.util.BlockSource;
import com.projectkorra.projectkorra.util.ClickType;

public class EarthTrammel extends EarthAbility implements AddonAbility, Listener {
	
	private long cooldown = ConfigManager.getConfig().getLong("ExtraAbilities.Jacksonnn.EarthTrammel.Cooldown");
	private Location location;
	private int selectRange;

	public EarthTrammel(Player player) {
		super(player);
	}

	@Override
	public void progress() {
		if (player == null || !player.isOnline() || player.isDead()) {
			remove();
			return;
		}
		Block sblock = BlockSource.getEarthSourceBlock(player, selectRange, ClickType.SHIFT_DOWN);

		if (sblock == null) {
			location = getTargetEarthBlock(selectRange).getLocation();
		} else {
			location = sblock.getLocation();
		}

		World world = location.getWorld();

	}

	@Override
	public long getCooldown() {
		return cooldown;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public boolean isHarmlessAbility()	{
		return true;
	}

	@Override
	public boolean isSneakAbility() {
		return true;
	}

	@Override
	public boolean isHiddenAbility() {
		return false;
	}

	@Override
	public void load() {
		ConfigManager.languageConfig.get().addDefault("ExtraAbilities.Jacksonnn.EarthTrammel.Description", "Description");
		ConfigManager.languageConfig.get().addDefault("ExtraAbilities.Jacksonnn.EarthTrammel.Instructions", "Shift: Allow the wall to be created in which direction you look.");
		ConfigManager.getConfig().addDefault("ExtraAbilities.Jacksonnn.EarthTrammer.Cooldown", 15000);
		ConfigManager.defaultConfig.save();
		ConfigManager.languageConfig.save();
	}

	@Override
	public void stop() {
		
	}

	@Override
	public String getName() {
		return "EarthTrammel";
	}

	@Override
	public String getAuthor() {
		return "Jacksonnn";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getDescription() {
		return "Author: " + getAuthor() + "\nEarthTrammel\n" + ConfigManager.languageConfig.get().getString("ExtraAbilities.Jacksonnn.EarthTrammel.Description");
	}
	
	public String getInstructions() {
		return ConfigManager.languageConfig.get().getString("ExtraAbilities.Jacksonnn.EarthTrammel.Instructions");
	}

}
