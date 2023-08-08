package com.roadtripmc.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = Bukkit.getWorld("spawn").getSpawnLocation();
		p.setGameMode(GameMode.ADVENTURE);
		p.teleport(loc);
		return false;
	}

}
