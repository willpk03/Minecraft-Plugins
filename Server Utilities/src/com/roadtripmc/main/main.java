package com.roadtripmc.main;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R1.Item;



public class main extends JavaPlugin implements Listener{

	private String host, database, username, password;
	private int port;
	private static Connection connection;
	private static FileManager FileManager;
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	int x;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		System.out.println("RoadTripMC Plugin Loaded");
		
		FileManager = new FileManager(this);
		getCommand("points").setExecutor(new pointsCommand());
		getCommand("tags").setExecutor(new tagsCommand());
		getCommand("team").setExecutor(new teamsCommand());
		getCommand("tpa").setExecutor(new tpaCommand());
		getCommand("tpaccept").setExecutor(new tpaCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		getCommand("rtp").setExecutor(new rtpCommand());
		getCommand("worldTravel").setExecutor(new worldTravelCommand());
		getCommand("roadtripmc").setExecutor(new roadtripmcCommand());
		getCommand("discord").setExecutor(new discordCommand());
		getCommand("rank").setExecutor(new rankCommand());
		getCommand("staffchat").setExecutor(new staffchatCommand());
		getCommand("sc").setExecutor(new staffchatCommand());
		getCommand("nickname").setExecutor(new NicknameCommand());
		getCommand("tell").setExecutor(new communicationCommand());
		getCommand("socialspy").setExecutor(new communicationCommand());
		getCommand("cgive").setExecutor(new customItem());
		getCommand("home").setExecutor(new homeCommands());
		getCommand("sethome").setExecutor(new homeCommands());
		getCommand("token").setExecutor(new tokencommands());
		getCommand("rules").setExecutor(new ruleCommand());
		getCommand("ce").setExecutor(new customEnchantCommands());
		//getCommand("rule").setExecutor(new ruleCommand());
		//getCommand("help").setExecutor(new roadtripmcCommand());
		
		Bukkit.getPluginManager().registerEvents(new TagsListner(), this);
		Bukkit.getPluginManager().registerEvents(new onJoinListener(), this);
		
		
		Bukkit.getServer().createWorld(new WorldCreator("spawn"));
		Bukkit.getServer().getWorld("spawn").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
		Bukkit.getServer().getWorld("spawn").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
		Bukkit.getServer().getWorld("spawn").setGameRule(GameRule.DO_MOB_SPAWNING, false);
   		Location location = new Location(Bukkit.getWorld("spawn"), 47, 99, 41);
		Bukkit.getServer().getWorld("spawn").setDifficulty(Difficulty.PEACEFUL);
		Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.HARD);
//		Bukkit.getServer().setMotd("");
		
		
		host = "localhost";
		port = 3306;
		database = "RoadTripMC";
		username = "root";
		password = "usbw";
//		
//		host = "mysql.apexhosting.gdn";
//		port= 3306;
//		database = "apexMC371379";
//		username = "apexMC371379";
//		password = "50afc1c8ca";
		
		try {
			openConnection();
			
			System.out.println("You've connected to the Database!");
		} catch(SQLException x) {
			x.printStackTrace();
		}
		
					Bukkit.getScheduler ().scheduleSyncRepeatingTask (this, () -> 
						announcements()
						, 2000, 2000);
		
	}
	
	private void openConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			return;
		}
		
		connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
		
	}
	
	public static PreparedStatement prepareStatement(String query) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
		} catch(SQLException e) {
			
		}
		
		return ps;
	}
	
	private void announcements() {
		if (x == 0) {
			Bukkit.broadcastMessage(Tag + "Join the " + ChatColor.BLUE + "discord " + ChatColor.GRAY + "by using /discord");
		} else if (x == 1) {
			Bukkit.broadcastMessage(Tag + "Create a " + ChatColor.GOLD + "team " + ChatColor.GRAY + "by using /team to discover all the commands");
		} else if (x == 2) {
			Bukkit.broadcastMessage(Tag + "Find out more about " + ChatColor.GOLD + "points " + ChatColor.GRAY + "by using /points");
			x = -1;
		}
		x++;
	}
	
	public static FileManager getFileManager() {return FileManager; }
}

