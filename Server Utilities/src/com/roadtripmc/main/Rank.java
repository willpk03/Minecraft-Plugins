 package com.roadtripmc.main;

import org.bukkit.ChatColor;

public enum Rank {

	SENIOR_MANAGER("SENIOR MANAGER", ChatColor.DARK_RED),
	MANAGER("MANAGER", ChatColor.RED),
	MEDIA("MEDIA", ChatColor.RED),
	ADMIN("ADMIN", ChatColor.RED),
	MODERATOR("MODERATOR", ChatColor.DARK_GREEN),
	SUPPORT("SUPPORT", ChatColor.GREEN),
	MEMBER("MEMBER", ChatColor.BLUE);
	
	private String name;
	private ChatColor color;
	
	private Rank(String name, ChatColor color) {
		this.name = name;
		this.color = color;
	}
	
	public String getName() { return name; }
	public ChatColor getColor() {return color; }
	
	
}
