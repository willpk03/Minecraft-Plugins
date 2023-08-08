package com.roadtripmc.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class pointsCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			try {
				if (args.length == 0) {
					ResultSet rs = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "'").executeQuery();
					rs.next();
					int playerID  = rs.getInt("USERID");
					
					ResultSet rs2 = main.prepareStatement("SELECT Points FROM teams WHERE USERID = '" + playerID + "'").executeQuery();
					rs2.next();
					int playerPoints = rs2.getInt("Points");
					p.sendMessage(Tag + "You have: " + ChatColor.RED + "" + ChatColor.BOLD + playerPoints + ChatColor.GRAY + " points");
					p.sendMessage(Tag + "To earn points, talk in chat, or join in player events.");
				
				} else if (args.length == 1) {
					String commandType = args[0];
					if (commandType.equalsIgnoreCase("top")) {
						ResultSet rs = main.prepareStatement("SELECT teams.points , users.DisplayName FROM teams, users WHERE teams.USERID = users.USERID ORDER BY points DESC").executeQuery();
						ResultSet rs2 = main.prepareStatement("SELECT count(USERID) FROM `teams` WHERE 1").executeQuery();
						rs2.next();
						rs.next();
						p.sendMessage(ChatColor.GOLD + "------" + ChatColor.GRAY + " " + ChatColor.BOLD + " Points Top (Top 10) "  + ChatColor.GOLD + "------");
						if(rs2.getInt(1) <= 9) {
							int x= 1;
							while (x != rs2.getInt(1) + 1) {
								p.sendMessage(ChatColor.GOLD + "- #" + x + ChatColor.GRAY + ChatColor.BOLD + " " + rs.getString(2) + " ("+ Integer.toString(rs.getInt(1)) + " Points)");
								rs.next();
								x++;
							}
//							for(x = 0; x >= rs2.getInt(1); x++) {
//								p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs.getInt(1)));
//								rs.next();
//							}
							
						}else {
							int x = 1;
							while (x != 11) {
								p.sendMessage(ChatColor.GOLD + "-- #" + x + ChatColor.BOLD + ChatColor.RED + " " + rs.getString(2) +  " ------ " + Integer.toString(rs.getInt(1)));
								rs.next();
								x++;
							}
//							for(x = 0; x == 10; x++) {
//								p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs.getInt(1)));
//								rs].next();
//							}
							
						}
					}
				}else if (args.length > 1) {
					String commandType = args[0];
					if (commandType.equalsIgnoreCase("give")) { //Gives a player points
						if(p.hasPermission("roadtripmc.points.all")) {//Makes sure player has permission
							if (args.length == 3) {
								String Reciever = args[1];
								Player recieverName = Bukkit.getServer().getPlayer(Reciever);
								int givenPoints = Integer.parseInt(args[2]);
								UUID uuidReciever = recieverName.getUniqueId();
								//Grabs the receivers points
								ResultSet rs5 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + recieverName.getUniqueId() + "';").executeQuery();
								rs5.next();
								int recieverUserID = rs5.getInt("USERID");
								ResultSet rs3 = main.prepareStatement("SELECT * FROM teams WHERE USERID = " + recieverUserID).executeQuery();
								rs3.next();
								int recieverPoints = rs3.getInt("Points");
								int newRecieverPoints = recieverPoints + givenPoints;
								main.prepareStatement("UPDATE teams SET Points =" + newRecieverPoints + "WHERE USERID = '"+ recieverUserID + "';").executeUpdate();
								p.sendMessage(Tag + "You've send the player: " + givenPoints + " Points");
								System.out.println("Player: " + p.getDisplayName() + " gave " + recieverName.getDisplayName() +" "+ givenPoints + " Points" + "They now have " + newRecieverPoints);
								System.out.println("Player UUID was: " + uuidReciever);
							}else {
								p.sendMessage(Tag + "You've inputed the command wrong here is the proper format: /points {Player Name} {Points Amount}");
							}
						}else {
							p.sendMessage(Tag + "You do not have permission to use this command");
						}
					} else if (commandType.equalsIgnoreCase("top")) {
						ResultSet rs = main.prepareStatement("SELECT teams.points , users.DisplayName FROM teams, users WHERE teams.USERID = users.USERID ORDER BY points").executeQuery();
						ResultSet rs2 = main.prepareStatement("SELECT count(USERID) FROM `teams` WHERE 1").executeQuery();
						rs2.next();
						rs.next();
						if(rs2.getInt(1) <= 9) {
							int x;
							for(x = 0; x == rs2.getInt(1); x++) {
								p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs2.getInt(1)));
								rs.next();
							}
						}else {
							int x;
							for(x = 0; x == 10; x++) {
								p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs2.getInt(1)));
								rs.next();
							}
							p.sendMessage(Integer.toString(rs2.getInt(1)));
						}
					} else {
						p.sendMessage(Tag + "You typed in: " + args[0] + "this is invalid command");
					}
					
				} else {
					p.sendMessage(Tag + "Yeah something went wrong, dumb dev");
				}
			}catch (SQLException x) {
				x.printStackTrace();
			} 
			  
		}
		return false;
	}

}
