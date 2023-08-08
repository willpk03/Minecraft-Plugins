package com.roadtripmc.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class rtpCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		int x;
		int z;
		double i = Math.random() * 2000;
		x = (int) (i / 1) - 1000;
		double a = Math.random() * 2000;
		z = (int) (a / 1) - 1000;
		int y = 60;
		
		boolean safe = false;
		p.sendMessage(Tag + "Please standby as we find a safe location");
		while(safe == false) {
			Location location = new Location(Bukkit.getWorld("world"), x, y, z);
			if (location.getBlock().getType().equals(Material.AIR)) {
		   		p.teleport(location);
		   		safe = true;
		   		p.sendMessage(Tag + "You've teleported to a random spot in the world");
		   	} else {
//		   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
		   		System.out.print(location.getBlock().getType());
		   		System.out.print(location);
		   		y++;
		   	}
			
		}
		p.setGameMode(GameMode.SURVIVAL);
		return false;
	}

}
