package com.roadtripmc.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class communicationCommand implements CommandExecutor {
	
	ArrayList<Player> socialSpyPlayers = new ArrayList<>();
	String socialSpyTag = ChatColor.AQUA + "" + ChatColor.BOLD +"[Social Spy] " + ChatColor.GRAY;
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tell")) {
			 if(args.length <= 1) {
				 p.sendMessage(Tag + "The ussage of this command is wrong");
				 
			 } else {
				int i = 1;
				String Message = "";
				while(i != args.length) {
					Message = Message + " " + args[i];
					i++;		 
				}
				Player messagedPlayer = Bukkit.getPlayer(args[0]); 
				if (messagedPlayer != p) {
					messagedPlayer.sendMessage(ChatColor.GOLD + "[From: " + p.getDisplayName() + "] " + ChatColor.GRAY + Message);
					p.sendMessage(ChatColor.GOLD + "[To: " + messagedPlayer.getDisplayName() + "] " + ChatColor.GRAY + Message);
					int x = 1;
					for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
						if (main.getFileManager().gettag(onlinePlayers).gettagName().equalsIgnoreCase("admin") || main.getFileManager().gettag(onlinePlayers).gettagName().equalsIgnoreCase("staff"))
						{
							onlinePlayers.sendMessage(socialSpyTag + ChatColor.GOLD + "[To: " + messagedPlayer.getDisplayName() + ", From: " + p.getDisplayName() + " ] " + ChatColor.GRAY + Message);
					
						}
					}
				}
			 }
		} else if (cmd.getName().equalsIgnoreCase("socialspy")) {
			Rank rank = main.getFileManager().getRank(p);
			if (main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("admin") || main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("staff"))
			{
				if (socialSpyPlayers.contains(p)) {
					socialSpyPlayers.remove(p);
				}else {
					socialSpyPlayers.add(p);
					p.sendMessage(Tag + "You will see any private messages sent by players");
				}
			}
		}
		return false;
	}

}
