package com.roadtripmc.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.EnumUtils;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class rankCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	// rank 
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (args.length == 0) {
			
		} else {
			String CommandType = args[0];
			if (CommandType.contentEquals("set")) {
				if(args.length == 3) {
					if(player.isOp()) {
						if (Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
							if(EnumUtils.isValidEnum(Rank.class, args[2].toUpperCase())) {
								main.getFileManager().setRank(Bukkit.getOfflinePlayer(args[1]).getUniqueId(), Rank.valueOf(args[2].toUpperCase()));
								
								player.sendMessage(Tag + "You changed the rank");
								
								if (Bukkit.getOfflinePlayer(args[1]).isOnline()) {
									Bukkit.getOfflinePlayer(args[1]).getPlayer().sendMessage(Tag + player.getName() + " has changed your rank to " + args[2]);								}
								
							}else {
								player.sendMessage(Tag + "Rank does not exist");
							}
						} else {
							player.sendMessage(Tag + "Player does not exist");
						}
						
						
					}else {
						player.sendMessage(Tag + "You do not have permission to use this command");
					}
				} else {
					player.sendMessage(Tag + "Inncorrect Ussage");
				}
				
				
				
			} else if (CommandType.contentEquals("settag")){
				if(args.length == 3) {
					if(player.isOp() || main.getFileManager().gettag(player).gettagName() == "ADMIN") {
						if (Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
							if(EnumUtils.isValidEnum(ranktags.class, args[2].toUpperCase())) {
								main.getFileManager().setTag(Bukkit.getOfflinePlayer(args[1]).getUniqueId(), ranktags.valueOf(args[2].toUpperCase()));
								
								player.sendMessage(Tag + "You changed the rank");
								
								if (Bukkit.getOfflinePlayer(args[1]).isOnline()) {
									Bukkit.getOfflinePlayer(args[1]).getPlayer().sendMessage(Tag + player.getName() + " has changed your tag to " + args[2]);								}
								
							}else {
								player.sendMessage(Tag + "Rank does not exist");
							}
						} else {
							player.sendMessage(Tag + "Player does not exist");
						}
						
						
					}else {
						player.sendMessage(Tag + "You do not have permission to use this command");
					}
				} else {
					player.sendMessage(Tag + "Inncorrect Ussage");
				}
			}
		}
		return false;
	}

}
