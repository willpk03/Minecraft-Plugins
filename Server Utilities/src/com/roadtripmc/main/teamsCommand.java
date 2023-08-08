package com.roadtripmc.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class teamsCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		try {
		if (p instanceof Player) {//checks if its a player
			if (args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "--------" + ChatColor.GOLD + "[RoadTripMC - Teams Help]" + ChatColor.GRAY + " --------");
				p.sendMessage(ChatColor.GOLD +"/team create {name} " + ChatColor.GRAY + "-- Creates a team");
				p.sendMessage(ChatColor.GOLD +"/team invite {palyer} " + ChatColor.GRAY + "-- Invite a player to your team");
				p.sendMessage(ChatColor.GOLD +"/team join " + ChatColor.GRAY +"-- Join a team once invited");
				p.sendMessage(ChatColor.GOLD +"/team leave " + ChatColor.GRAY +"-- Leave your team");
				p.sendMessage(ChatColor.GOLD +"/team chat {message}" + ChatColor.GRAY + " -- Send a message to your whole team");
			} else {
				String commandType = args[0]; //Grabs the first arg to check the type of command
				if (commandType.equalsIgnoreCase("create")) { //If it equals create
					if(args.length == 2) {
						String newTeamName = args[1]; //Grabs the team name 
						ResultSet rs = main.prepareStatement("SELECT COUNT(teamName) FROM team WHERE TeamName = '" + newTeamName + "';").executeQuery(); //Checks if there is a team called team name
						ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
						rs5.next();
						int UserID = rs5.getInt("USERID");
						rs.next();
						int NumTeamName = rs.getInt(1);
						System.out.print(NumTeamName); //the number of teams with that name
						
						if (NumTeamName == 0) { //IS NOT IN SYSTEM
							ResultSet rs2 = main.prepareStatement("Select teamID FROM teams WHERE USERID = '" +  UserID + "';" ).executeQuery(); //checks to see if the User is in a team
				 			rs2.next();
				 			int teamID = rs2.getInt(1); //
				 			if (teamID == 0) {
				 				
				 				int charCount = newTeamName.length();
				 				if (charCount < 20) {
					 			main.prepareStatement("INSERT INTO team(teamName, teamOwner) VALUES ('"+ newTeamName +"', '" + UserID + "')").executeUpdate();
					 			ResultSet rs6 = main.prepareStatement("SELECT * FROM team WHERE teamName = '" + newTeamName + "'").executeQuery();
					 			rs6.next();
					 			int newteamID = rs6.getInt("teamID");
					 			main.prepareStatement("UPDATE teams SET TeamID= '" + newteamID + "' WHERE USERID = '" + UserID + "';").executeUpdate();
					 			p.sendMessage( "You have created a Team called " + newTeamName);
				 				} else {
				 					p.sendMessage(Tag + "The Team name must be 20 letters or less!");
				 				}
				 			} else {
				 				p.sendMessage(Tag + "You have already created a team");
				 				System.out.print(teamID);
				 			}
						} else {
							p.sendMessage(Tag + "There is already a team named " + newTeamName);
						}
					} else {
						p.sendMessage(Tag + "The command was inputed wrong (/team create {name}");
					}
				
					
				
				}else if (commandType.equalsIgnoreCase("leave")) {
					try {
						ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
						rs5.next();
						int UserID = rs5.getInt("USERID");
						
						ResultSet rs6 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + UserID + "';").executeQuery();
						rs6.next();
						int teamID = rs6.getInt("teamID");
			 			if (teamID == 0) {
			 				p.sendMessage(Tag + "You are not in a team");
			 				System.out.print(teamID);
			 			} else {
			 				ResultSet rs7 = main.prepareStatement("SELECT * FROM team WHERE teamID = '"+ teamID + "';").executeQuery();
			 				rs7.next();
			 				int teamOwner = rs7.getInt("teamOwner");
			 				if (teamOwner != UserID) {
				 				main.prepareStatement("UPDATE teams SET TeamID ='0' WHERE USERID = '" + UserID+ "';").executeUpdate();
					 			p.sendMessage(Tag +  "You have left your team");
			 				} else {
			 					p.sendMessage(Tag + "You are the team leader you can't leave");
			 				}
			 			}
				
					}catch (SQLException x) {
					 x.printStackTrace();
					}
				} else if(commandType.equalsIgnoreCase("invite")) {
					String temp = args[1];
					Player invitedPlayer = Bukkit.getServer().getPlayer(temp);
					try {
						if(!(p.getDisplayName().equalsIgnoreCase(invitedPlayer.getDisplayName()))) {
							ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
							rs5.next();
							int UserID = rs5.getInt("USERID");
							ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + UserID + "';").executeQuery();
							
							teamCheck2.next();
							int TeamID = teamCheck2.getInt("teamID");
							ResultSet teamCheck3 = main.prepareStatement("SELECT * FROM team WHERE teamID = '" + TeamID + "';").executeQuery();
							teamCheck3.next();
							String TeamName = teamCheck3.getString("teamName");
							int OwnerID = teamCheck3.getInt("teamOwner");
							invitedPlayer.sendMessage(Tag + "You have been invited to the clan, " + TeamName + ", to join use the command /team join ");
							p.sendMessage(Tag + "You have invited the player, " + invitedPlayer.getDisplayName() + "to the team");
							
							ResultSet rs6 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + invitedPlayer.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
							rs6.next();
							int recieverID = rs6.getInt("USERID");
							main.prepareStatement("UPDATE teams SET Invited = '"+ TeamID + "' WHERE USERID = '" + recieverID  + "';").executeUpdate();
						} else {
							p.sendMessage(Tag + "You were sending a invite to yourself");
						}
					}catch (SQLException x) {
						x.printStackTrace();
					}
				} else if(commandType.equalsIgnoreCase("join")){
					try {
						ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
						rs5.next();
						int UserID = rs5.getInt("USERID");
						ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + UserID + "';").executeQuery();
						
						teamCheck2.next();  
						String TeamID = teamCheck2.getString("invited");
						if (!TeamID.equalsIgnoreCase("0")) {
							p.sendMessage(Tag + "You have joined the team");
							main.prepareStatement("UPDATE teams SET teamID = '"+ TeamID + "', invited = '0' WHERE USERID = '" + UserID + "';").executeUpdate();
						} else {
							p.sendMessage(Tag + "You must first be invited to join a team");
						}
					}catch (SQLException x) {
						 x.printStackTrace();
					}
				} else if (commandType.equalsIgnoreCase("chat")) {
					if (args.length != 1) {
						ResultSet teamCheck = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
						teamCheck.next();
						int UserID = teamCheck.getInt("USERID");
						//Grabs the teamID
						ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + UserID + "';").executeQuery();
						teamCheck2.next();
						int TeamID = teamCheck2.getInt("teamID");
						
						//Creates the message
						int length = args.length;
						int i = 1;
						String Message = "";
						while(i != length) {
							Message = Message + " " + args[i];
							i++;
							 
						}
						System.out.println(Message);
						// grabs all players in the same team
						ResultSet teamCheck3 = main.prepareStatement("SELECT * FROM teams WHERE teamID = '" + TeamID + "';").executeQuery();
						// Checks how players are in the team
						ResultSet teamCheck4 = main.prepareStatement("SELECT count(USERID) FROM teams WHERE teamID = '" + TeamID + "';").executeQuery();
						teamCheck4.next();
						int teamCount = teamCheck4.getInt(1);
						
						int o = 1;
						while (o != teamCount + 1) {
							teamCheck3.next();
							int messagePlayerID = teamCheck3.getInt("USERID"); //Grabs the next player 
							System.out.println(messagePlayerID);
							ResultSet teamCheck5 = main.prepareStatement("SELECT * FROM users WHERE USERID = '" + messagePlayerID + "';").executeQuery(); //Finds the DisplayName
							System.out.println("SELECT * FROM users WHERE USERID = '" + messagePlayerID + "';");
							teamCheck5.next();
							String temp = teamCheck5.getString("DisplayName");
							System.out.println(temp);
							Player messagePlayer = Bukkit.getServer().getPlayer(temp);
							System.out.println(messagePlayer);
							messagePlayer.sendMessage(ChatColor.GRAY +"[Team Chat] [" + p.getDisplayName() + "] -" + Message);
							o++;
						} 
					} else {
						p.sendMessage(Tag + "You didn't use the command properly. Format: /team chat (message)");
					}
				
				
				}else if (commandType.equalsIgnoreCase("disband")) {
					ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(); //Grabs the players USERID
					rs5.next();
					int UserID = rs5.getInt("USERID");
					
					ResultSet rs6 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + UserID + "';").executeQuery();
					rs6.next();
					int teamID = rs6.getInt("teamID");
		 			if (teamID == 0) {
		 				p.sendMessage(Tag + "You are not in a team");
		 				System.out.print(teamID);
		 			} else {
		 				ResultSet rs7 = main.prepareStatement("SELECT * FROM team WHERE teamID = '"+ teamID + "';").executeQuery();
		 				rs7.next();
		 				int teamOwner = rs7.getInt("teamOwner");
		 				if (teamOwner != UserID) {
				 			p.sendMessage(Tag +  "You can't disband the team if your not owner");
		 				} else {
		 					main.prepareStatement("DELETE FROM `team` WHERE teamID = '"+ teamID + "';").executeUpdate();
				 			p.sendMessage(Tag +  "You have left your team");
		 				}
		 			}
				} else {
					p.sendMessage(Tag + "You have not inputed the command properly");
					System.out.print(commandType);
				}
				
			} 
		}
		}catch (SQLException x) {
			x.printStackTrace();
		}
		return false;
		
	}

}
