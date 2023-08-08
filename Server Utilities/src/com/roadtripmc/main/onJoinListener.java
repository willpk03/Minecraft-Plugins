package com.roadtripmc.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import net.md_5.bungee.api.ChatColor;

public class onJoinListener implements Listener {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	int x;
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
//		if (x == 0) {
//			p.sendMessage(Tag + "Join the " + ChatColor.BLUE + "discord " + ChatColor.GRAY + "by using /discord");
//		} else if (x == 1) {
//			p.sendMessage(Tag + "Create a " + ChatColor.GOLD + "team " + ChatColor.GRAY + "by using /team to discover all the commands");
//		} else if (x == 2) {
//			p.sendMessage(Tag + "Find out more about " + ChatColor.GOLD + "points " + ChatColor.GRAY + "by using /points");
//			x = -1;
//		}
//		
//		x++;
		
		if (!e.getPlayer().hasPlayedBefore()) {
			Bukkit.getServer().createWorld(new WorldCreator("spawn"));
	   		Location location = new Location(Bukkit.getWorld("spawn"), 47, 99, 41);
			p.setBedSpawnLocation(location);
	   		p.teleport(location);
	   		p.setGameMode(GameMode.ADVENTURE);
			p.sendMessage(Tag + "Welcome, to begin your adventure use: rtp");
			p.sendMessage(Tag + "To compete for points create or join a team by doing team to see all the commands");
			//main.prepareStatement("INSERT INTO users( UUID, DisplayName, Rank, JoinDate, Token, IP) VALUES ('" + p.getUniqueId() + "', '" + p.getDisplayName() + "', 'MEMBER', DEFAULT , 0 , 'NULL   ' )").executeUpdate();
			main.getFileManager().setRank(p, Rank.MEMBER);
			main.getFileManager().setTag(p, ranktags.MEMBER);
			main.getFileManager().setHome(p);
		}
		
		String newNick = p.getDisplayName();
		Rank rank = main.getFileManager().getRank(p);
		String rankPrefix = rank.getColor() + rank.getName();
		p.setDisplayName(newNick);
		p.setPlayerListName(rankPrefix + " " + newNick);
		
//		String tempIP = p.getAddress().toString();
//		int no = Integer.parseInt(tempIP);
//		String hexIP = Integer.toHexString(no);
		try {
			ResultSet rs = main.prepareStatement("SELECT COUNT(UUID) FROM users WHERE UUID = '" + p.getUniqueId().toString() + "';").executeQuery(); 
			rs.next();
			
			if (rs.getInt(1) == 0) { //IS NOT IN SYSTEM
				
				main.prepareStatement("INSERT INTO users( UUID, DisplayName, Rank, JoinDate, Token, IP) VALUES ('" + p.getUniqueId() + "', '" + p.getDisplayName() + "', 'MEMBER', DEFAULT , 0 , 'NULL   ' )").executeUpdate();
			}
			p.getWorld().setDifficulty(Difficulty.NORMAL);
			
			//Grabs the userID
			ResultSet rs2 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
			rs2.next();
			int playerID  = rs2.getInt("USERID");
			
			//Puts the player in the Teams database
			ResultSet rs4 =  main.prepareStatement("SELECT COUNT(USERID) FROM teams WHERE USERID = "+ playerID).executeQuery();
			rs4.next();
			if (rs4.getInt(1) == 0) { 
				main.prepareStatement("INSERT INTO teams(USERID, TeamID, Points, Invited, teamStatus) VALUES (" + playerID + " , 0, 0, 0, DEFAULT)").executeUpdate();
				ResultSet rs5 = main.prepareStatement("SELECT Points FROM teams WHERE USERID = " + playerID).executeQuery();
				rs5.next();
				int PlayerPoints = rs5.getInt(1);
				PlayerPoints = PlayerPoints + 1;
				main.prepareStatement("UPDATE teams SET Points = " + PlayerPoints + "WHERE USERID = " + playerID).executeUpdate();
				p.sendMessage(Tag + "You have been given 1 points for joining the server");   
			}
			ResultSet rs6 = main.prepareStatement("SELECT Points FROM teams WHERE USERID = " + playerID).executeQuery();
			rs6.next();
			BossBar playerScore = Bukkit.createBossBar(ChatColor.WHITE + "The road to" + ChatColor.GOLD +" Ten Thousand Points", BarColor.BLUE, BarStyle.SOLID);
			playerScore.setVisible(true);
			
			int PlayerPoints = rs6.getInt(1);
			int PlayerProggress = PlayerPoints / 10000 * 100;
			playerScore.setProgress(PlayerProggress);
			playerScore.addPlayer(p);
			
			
			
		}catch (SQLException x) {
			x.printStackTrace();
		} 
		
	}
	
	

}
