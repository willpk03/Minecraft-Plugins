package com.tags.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warnCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Staff] " + ChatColor.GRAY;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// warn Player Desc
		String offender =  args[0];
		
		Player p = Bukkit.getServer().getPlayer(offender);
		if (p instanceof Player) {
			int i;
			int max = args.length;
			String desc = "";
			for(i = 1; i == max; i++) {
				String temp = args[i];
				desc = desc + " " + temp;
				System.out.print(temp);
			}
			p.sendMessage(Tag + "You've been warned for " + desc);
		} else {
			p.sendMessage(Tag + "You've written a player that does not exist. You wrote " + offender);
		}
		
		return false;
	}

}
