package com.tags.plugin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin implements Listener{
	public String[] king;
	public String[] queen;
	public String[] slayer;
	static ArrayList<Player> netherTravel = new ArrayList<>();
	static ArrayList<Player> moonTravel = new ArrayList<>();
	
	public static String[] tags = {"king", "queen", "slayer"};
	private String host, database, username, password;
	private int port;
	private static Connection connection;
	@Override
	public void onEnable() {
		System.out.println("Tags Plugin Loaded");
		getCommand("tags").setExecutor(new tagsCommand());
		getCommand("exchange").setExecutor(new exchangeCommand());
		getCommand("travel").setExecutor(new travelCommand());
		getCommand("bal").setExecutor(new balCommand());
		getCommand("market").setExecutor(new marketCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		getCommand("warn").setExecutor(new warnCommand());
		getCommand("pay").setExecutor(new giveCommand());
		getCommand("give").setExecutor(new payCommand());
		getCommand("playerLook").setExecutor(new playerlook());
		getCommand("clan").setExecutor(new clanCommand());
		getCommand("createSpawn").setExecutor(new createSpawn());
		getCommand("worldtravel").setExecutor(new worldTravel());
		
		
		Bukkit.getPluginManager().registerEvents(new inventoryListner(), this);
		Bukkit.getPluginManager().registerEvents(new bedListener(), this);
		Bukkit.getPluginManager().registerEvents(new onJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new toggleListener(), this);
		//Bukkit.getPluginManager().registerEvents(new onJoinListener(), this);
		
		host = "localhost";
		port = 3306;
		database = "minecraft";
		username = "root";
		password = "usbw";
		
		try {
			openConnection();
			
			System.out.println("You've connected to the Database!");
		} catch(SQLException x) {
			x.printStackTrace();
		}
		//host = "localhost"
		//port = 3306
		//Username = root
		//Password = usbw
		//DB Name = minecraft
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
	

}
