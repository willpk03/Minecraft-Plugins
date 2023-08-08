package com.tags.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class worldTravel implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String WorldName = args[0];
		Player p = (Player) sender;
		if (p.hasPermission("admin.world") || p.hasPermission("admin.admin")) {
			if (WorldName.equalsIgnoreCase("spawn")) {
				Bukkit.getServer().createWorld(new WorldCreator("spawn"));
		   		Location location = new Location(Bukkit.getWorld("spawn"), 47, 99, 41);
		   		
		   		p.teleport(location);
			}else if (WorldName.equalsIgnoreCase("normal")) {
				Bukkit.getServer().createWorld(new WorldCreator("world"));
		   		Location location = new Location(Bukkit.getWorld("world"), 47, 108, 41);
		   		
		   		p.teleport(location);
			}
		}
		return false;
	}

}
