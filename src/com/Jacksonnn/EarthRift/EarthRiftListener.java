package com.Jacksonnn.EarthRift;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.Jacksonnn.EarthRift.EarthRift;
import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;

public class EarthRiftListener {
	@EventHandler
	public void onShift(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);
		
		if (event.isCancelled() || player == null || bPlayer.getBoundAbility().equals(null)) {
			return;
		} else if (bPlayer.getBoundAbilityName().equalsIgnoreCase("EarthRift")) {
			new EarthRift(player);
		}
	}
}
