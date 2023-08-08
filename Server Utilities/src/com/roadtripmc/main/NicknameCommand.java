package com.roadtripmc.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class NicknameCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		 if (cmd.getName().equalsIgnoreCase("nickname")) {
			if (args.length != 1) {
				p.sendMessage(Tag + "You've inputed the command incorrectly");
			} else {
				String newNick = args[0];
				Rank rank = main.getFileManager().getRank(p);
				String rankPrefix = rank.getColor() + rank.getName();
				int x = 0;
				for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
					if (onlinePlayers.getDisplayName().equalsIgnoreCase(newNick)) {
						x = 1;
					}
				}
				if (x == 0) {
					p.setDisplayName(newNick);
					p.setPlayerListName(rankPrefix + " " + newNick);
					p.sendMessage(Tag + "You've changed your nickname");
				} else {
					p.sendMessage(Tag + "This nickname is already being used");
				}
				
			}
			
		 } else if (cmd.getName().equalsIgnoreCase("whois")) {
			 if (args.length != 1) {
					p.sendMessage(Tag + "You've inputed the command incorrectly");
			 } else {
				 String playerNick = args[0];
				 int x = 0;
					for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
						if (onlinePlayers.getDisplayName().equalsIgnoreCase(playerNick)) {
							p.sendMessage("The player: " + onlinePlayers.getCustomName() + " has the nickname ");
							x = 1;
						}
					}
					if (x != 1) {
						p.sendMessage(Tag + "There was no palyer with that nickname found");
					}
			 }
		 }
		 return false;
	}

}
