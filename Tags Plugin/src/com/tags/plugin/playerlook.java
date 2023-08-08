package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playerlook implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("Admin.Admin") || player.hasPermission("Admin.Check")) {	
			try {
				String playerz =  args[0]; 
				Player p = Bukkit.getServer().getPlayer(playerz); //the player getting the money

	 			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
	 			rs2.next();
	 			int money = rs2.getInt("Token");
	 			Timestamp ts = rs2.getTimestamp("JOIN_DATE");
	 			String rank = rs2.getString("Rank");
	 			ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM team WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
				teamCheck2.next();
				String TeamName = teamCheck2.getString("TeamName");
				player.sendMessage(ChatColor.GRAY + "");
				player.sendMessage(ChatColor.GRAY + "----------------["+ ChatColor.GOLD + p.getDisplayName() + ChatColor.GRAY + "]----------------");
				player.sendMessage(ChatColor.GRAY + "Tokens = " + ChatColor.GOLD + money);
				player.sendMessage(ChatColor.GRAY +"Date the Player Joined = "+ ChatColor.GOLD + ts);
				player.sendMessage(ChatColor.GRAY +"Player's Rank = "+ ChatColor.GOLD + rank);
				player.sendMessage(ChatColor.GRAY +"The Team the player are in = "+ ChatColor.GOLD + TeamName);
				player.sendMessage(ChatColor.GRAY + "--------------------------------");
				player.sendMessage(ChatColor.GRAY + "");
			}catch (SQLException x) {
	 			x.printStackTrace();
			}
			
		} else {
			player.sendMessage(ChatColor.DARK_GRAY + "You do not have permission to use this Command");
		}
		return false;
	}

}
