package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p instanceof Player) {
			String commandType = args[0];
			if (commandType.equalsIgnoreCase("create")) {
				try {
					String newTeamName = args[1];
					ResultSet rs = main.prepareStatement("SELECT COUNT(TeamName) FROM team WHERE TeamName = '" + newTeamName + "';").executeQuery(); 
					rs.next();
					int NumTeamName = rs.getInt(1);
					System.out.print(NumTeamName);
					
					if (NumTeamName == 0) { //IS NOT IN SYSTEM
						ResultSet rs2 = main.prepareStatement("Select * FROM team WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
			 			rs2.next();
			 			String teamName = rs2.getString("TeamName");
			 			if (teamName != "No Team") {
			 				
			 				int charCount = newTeamName.length();
			 				if (charCount < 20) {
				 			main.prepareStatement("UPDATE team SET TeamName ='" + newTeamName + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
				 			main.prepareStatement("UPDATE team SET teamStatus ='Owner' WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
				 			p.sendMessage( "You have created a Clan called " + newTeamName);
			 				} else {
			 					p.sendMessage("The Faction name must be 20 letters or less!");
			 				}
			 			} else {
			 				p.sendMessage("You have already created a Clan");
			 				System.out.print(teamName);
			 			}
					} else {
						p.sendMessage("There is already a team named " + newTeamName);
					}
			
				}catch (SQLException x) {
				 x.printStackTrace();
				}
			
			}else if (commandType.equalsIgnoreCase("leave")) {
				try {
		 			ResultSet rs2 = main.prepareStatement("Select * FROM team WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		 			rs2.next();
		 			String teamName = rs2.getString("TeamName");
		 			if (teamName == "No Team") {
		 				p.sendMessage("You are not in a team");
		 				System.out.print(teamName);
		 			} else {
		 				main.prepareStatement("UPDATE team SET TeamName ='No Team' WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
			 			p.sendMessage( "You have left your Clan");
		 			}
			
				}catch (SQLException x) {
				 x.printStackTrace();
				}
			} else if(commandType.equalsIgnoreCase("invite")) {
				String temp = args[1];
				Player invitedPlayer = Bukkit.getServer().getPlayer(temp);
				try {
					ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM team WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
					
					teamCheck2.next();
					String TeamName = teamCheck2.getString("TeamName");
					invitedPlayer.sendMessage("You have been invited to the clan, " + TeamName + ", to join use the command /clan join ");
					p.sendMessage("You have invited the player, " + invitedPlayer.getDisplayName() + "to the clan");
					main.prepareStatement("UPDATE team SET invited = '"+ TeamName + "' WHERE UUID = '" + invitedPlayer.getUniqueId() + "';").executeUpdate();
				}catch (SQLException x) {
					 x.printStackTrace();
					}
			} else if(commandType.equalsIgnoreCase("join")){
				try {
					ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM team WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
					
					teamCheck2.next();
					String TeamName = teamCheck2.getString("invited");
					if (!TeamName.equalsIgnoreCase("")) {
					p.sendMessage("You have joined the team, " + TeamName);
					main.prepareStatement("UPDATE team SET teamName = '"+ TeamName + "' WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
					}
				}catch (SQLException x) {
					 x.printStackTrace();
				}
			}else {
				p.sendMessage("You have not inputed the command properly");
				System.out.print(commandType);
			}
			
		}
		return false;
	}

}
