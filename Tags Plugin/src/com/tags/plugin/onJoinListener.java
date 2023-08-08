package com.tags.plugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;

public class onJoinListener implements Listener {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Market Place] " + ChatColor.GRAY;
	int Player = 0;
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		try {
			ResultSet rs = main.prepareStatement("SELECT COUNT(UUID) FROM user WHERE UUID = '" + p.getUniqueId().toString() + "';").executeQuery(); 
			rs.next();
			
			if (rs.getInt(1) == 0) { //IS NOT IN SYSTEM
				main.prepareStatement("INSERT INTO user(UUID, Rank, Token, JOIN_DATE) VALUES ('" + p.getUniqueId().toString() + "'," + "'GUEST', 0, DEFAULT);" ).executeUpdate();
			}else { // is already in system
				ResultSet rs2 = main.prepareStatement("SELECT * FROM user WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
				rs2.next();
				String rank = rs2.getString("Rank");
				int money = rs2.getInt("Token");
				Timestamp ts = rs2.getTimestamp("JOIN_DATE");
				p.getWorld().setDifficulty(Difficulty.NORMAL);
			}    
			Player = Player + 1;
			String pName = p.getDisplayName();
		    Bukkit.broadcastMessage(Tag + ChatColor.GRAY + pName + " has joined, right now there is [" + Player + "/50] on at this moment" );
		    ResultSet teamCheck = main.prepareStatement("SELECT COUNT(UUID) FROM team WHERE UUID = '" + p.getUniqueId().toString() + "';").executeQuery(); 
		    teamCheck.next();
			
			if (teamCheck.getInt(1) == 0) { //IS NOT IN SYSTEM
				main.prepareStatement("INSERT INTO team(UUID, Username, TeamName, invited, teamStatus) VALUES ('" + p.getUniqueId().toString() + "'," + "'" + p.getDisplayName() + "', 'No Team', '', '');" ).executeUpdate();
			}else { // is already in system
				ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM teams WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
				teamCheck2.next();
//				String rank = teamCheck2.getString("Rank");
//				int money = teamCheck2.getInt("Username");
//				Timestamp ts = teamCheck2.getTimestamp("TeamName");
			}
		}catch (SQLException x) {
			x.printStackTrace();
		} 
	
	}



	


	
	public void onPlayerQuit(PlayerQuitEvent e) {
		//Removes the player from the player list
		Player p = e.getPlayer();
		Player = Player - 1;
		String pName = p.getDisplayName();
	    Bukkit.broadcastMessage(Tag + ChatColor.GRAY + pName + " has left, right now there is [" + Player + "/50] on at this moment" );
	}
}