package com.roadtripmc.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class staffchatCommand implements CommandExecutor {
	String staffTag = ChatColor.AQUA + "" + ChatColor.BOLD +"[Staff Chat] " + ChatColor.GRAY;
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Rank rank = main.getFileManager().getRank(p);
		
		if (args.length == 0) {
			if(main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("admin") || main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("staff")) {
				p.sendMessage("Invalid ussage of the command ");
			} else {
				p.sendMessage(Tag + "You do not have permission to use this command");
			}
		} else {
			if(main.getFileManager().gettag( p).gettagName().equalsIgnoreCase("admin") || main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("staff")) {
				int length = args.length;
				int i = 0;
				String Message = "";
				while(i != length) {
					Message = Message + " " + args[i];
					i++;
					 
				}
				
				for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
					if (main.getFileManager().gettag(onlinePlayers).gettagName().equalsIgnoreCase("admin") || main.getFileManager().gettag(onlinePlayers).gettagName().equalsIgnoreCase("staff"))
					{
						onlinePlayers.sendMessage(staffTag + ChatColor.GOLD + "[" + p.getDisplayName() + "] " + ChatColor.GRAY + Message);
					}
				}
			} else {
				p.sendMessage(Tag + "You do not have permission to use this command");
			}
		}
		return false;
	}

}
