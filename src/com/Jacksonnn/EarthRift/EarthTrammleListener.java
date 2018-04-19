package com.Jacksonnn.EarthTrammel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.Jacksonnn.EarthTrammel.EarthTrammel;
import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;

public class EarthTrammelListener implements Listener {
	@EventHandler
	public void onShift(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);
		
		if (event.isCancelled() || player == null || bPlayer.getBoundAbility().equals(null)) {
			return;
		} else if (bPlayer.getBoundAbilityName().equalsIgnoreCase("EarthRift")) {
			new EarthTrammel(player);
		}
	}
}
