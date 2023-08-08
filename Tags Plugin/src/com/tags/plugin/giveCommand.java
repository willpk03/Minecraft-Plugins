package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class giveCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Staff] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			// give Player amount
			String player =  args[0]; 
			Player Player = (Player) sender; //the player sending the money
			Player p = Bukkit.getServer().getPlayer(player); //the player getting the money
			int payment = Integer.parseInt(args[1]);	
			if (p instanceof Player) {
				try {
	     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + Player.getUniqueId() + "';" ).executeQuery();
	     			rs2.next();
	     			int money = rs2.getInt("Token");
	     			if(money >= payment) {
	     				//Takes away tokens from the player sending the money
	     				money = money - payment;
	     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + Player.getUniqueId() + "';").executeUpdate();
	     				Player.sendMessage(Tag + "You have paid the player " + payment);
	     				//Grabs the money of the player being send the money
	     				ResultSet rs = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs.next();
		     			int money2 = rs.getInt("Token");
		     			//Adds the money to the player given
		     			money2 = money2 + payment;
		     			main.prepareStatement("UPDATE user SET Token ='" + money2 + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     			p.sendMessage(Tag + "You have been paid by a player with " + payment);
		     			System.out.print("The user: " + Player.getDisplayName() + "sent tokens to the user: " + p.getDisplayName() );
	     				 
	     			} else {
	     				 Player.sendMessage(Tag + "You do not have enough Tokens give tokens to this player");
	     			}
			 }catch (SQLException x) {
	     			x.printStackTrace();
	     	}
			}
		return false;
	}

}
