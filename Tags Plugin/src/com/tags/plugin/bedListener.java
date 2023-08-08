package com.tags.plugin;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

public class bedListener implements Listener {
	ArrayList<Player> netherTravel = main.netherTravel;
	@EventHandler
	private void PlayerBedEnterEvent(PlayerBedEnterEvent e) {
		Player p = (Player) e.getPlayer();
		if(netherTravel.contains(p)) {
			Location location = p.getLocation();
            //location.setWorld(world_nether);
            location.setX(0);
            location.setY(80);
            location.setZ(0);
            p.teleport(location);
		}
	}

}
