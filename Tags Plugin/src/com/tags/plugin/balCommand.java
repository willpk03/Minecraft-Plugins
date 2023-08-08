package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class balCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			 try {
	     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
	     			rs2.next();
	     			int money = rs2.getInt("Token");
	     			p.sendMessage(Tag + " At this moment you have: " + money + " Tokens");
			 }catch (SQLException x) {
	     			x.printStackTrace();
	     	}
		}
		return false;
	}

}
