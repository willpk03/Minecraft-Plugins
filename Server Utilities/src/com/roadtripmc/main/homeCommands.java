package com.roadtripmc.main;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class homeCommands implements CommandExecutor {

	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("sethome")) {
				main.getFileManager().setHome(p);
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(Tag + "You've set your home here");
			} else if (cmd.getName().equalsIgnoreCase("home")) {
				//if (!(p.getBedSpawnLocation() == null)) {
					main.getFileManager().getHome(p);
					p.sendMessage(Tag + "You've been sent to your home");
					
				//} else {
					
					
				//}
			}
		}
		return false;
	}

}
