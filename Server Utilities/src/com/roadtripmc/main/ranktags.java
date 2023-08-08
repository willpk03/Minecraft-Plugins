package com.roadtripmc.main;

import org.bukkit.ChatColor;

public enum ranktags {
	ADMIN("admin", ChatColor.RED, 4),
	STAFF("staff", ChatColor.GREEN, 3),
	DONOR("donor", ChatColor.YELLOW, 2),
	MEMBER("member", ChatColor.GRAY, 1);
	
	private String name;
	private ChatColor color;
	private int order;
	
	private ranktags(String name, ChatColor color, int order) {
		this.name = name;
		this.color = color;
		this.order = order;
	}
	
	public String gettagName() { return name; }
	public ChatColor gettagColor() {return color; }
	public int gettagOrder() {return order; }
	
}
