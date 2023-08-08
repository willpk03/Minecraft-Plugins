package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class payCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player Player = (Player) sender;
		String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY;
		if (Player.hasPermission("Token.give")) {
			int payment = Integer.parseInt(args[0]);
			try {
	 			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + Player.getUniqueId() + "';" ).executeQuery();
	 			rs2.next();
	 			int money = rs2.getInt("Token");
	 			money = money + payment;
	 			main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + Player.getUniqueId() + "';").executeUpdate();
	 			Player.sendMessage(Tag + "You have given yourself " + payment);
		
			}catch (SQLException x) {
			 x.printStackTrace();
			}
		}else {
			Player.sendMessage(Tag + "You do not have permission to use this command");
		}
		return false;
	}

}
