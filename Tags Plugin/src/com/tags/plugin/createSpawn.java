package com.tags.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class createSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("admin.world") || p.hasPermission("Admin.Admin")) {
			Bukkit.getServer().createWorld(new WorldCreator("spawn"));
	   		Location location = new Location(Bukkit.getWorld("spawn"), 47, 108, 41);
	   		
	   		p.teleport(location);
	   		p.getWorld().setDifficulty(Difficulty.PEACEFUL);   
		} else {
			p.sendMessage("Only for Senior Management use");
		}
		
		
		return false;
	}

}
