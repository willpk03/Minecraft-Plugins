package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class exchangeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			 String Error = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY + "You have" + ChatColor.RED + " insufficent permission!";
			 String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY;
	         Player p = (Player)sender;
	         ItemStack diamond = new ItemStack(Material.DIAMOND);
	         ItemStack hand = p.getItemInHand();
	         int handAmount = hand.getAmount();
	         if (hand.getType() == Material.DIAMOND) {
	        	 p.setItemInHand(null);
	        	 p.sendMessage(Tag + "You've given me " + handAmount + ", so I will give you " + handAmount + " tokens");
	        	 int tempToken = handAmount;
	        	 //Run query to grab the tokenAmount of the player at that moment. SELECT Token FROM Users WHERE username = p
	        	 //main.prepareStatement("Select Token FROM user WHERE UUID = '" + p.getUniqueId() + "';" );
	        	 //Add the amount of Token to the amount grabbed from the query
	        	 //Run Query to set the new tokenAmount of the player. UPDATE token = tempToken FROM users WHERE username = p
	        	 //main.prepareStatement("UPDATE user SET Money = '" + tempToken + "'WHERE UUID = '" + p.getUniqueId() + "';");
	        	 try {
	     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
	     			rs2.next();
	     			int money = rs2.getInt("Token");
	     			money = money + tempToken;
	     			//p.sendMessage(Tag + " " + money);
	     			main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
	     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
	     		}catch (SQLException x) {
	     			x.printStackTrace();
	     		}
	         } else {
	        	 p.sendMessage(Tag + "I will only give you coins for a diamond nothing else");
	         }
		}
		return false;
	}

}
