package com.roadtripmc.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class roadtripmcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(ChatColor.GRAY + "--------" + ChatColor.GOLD + "[RoadTripMC - Help]" + ChatColor.GRAY + " --------");
			p.sendMessage(ChatColor.GOLD +"/points " + ChatColor.GRAY + "-- Gives general information on the points system (You can also see points whenever you chat)");
			p.sendMessage(ChatColor.GOLD +"/points top " + ChatColor.GRAY + "-- Shows top 10 players points");
			p.sendMessage(ChatColor.GOLD +"/rtp " + ChatColor.GRAY + "-- Randomly teleports you into the wild");
			p.sendMessage(ChatColor.GOLD +"/spawn " + ChatColor.GRAY + "-- Brings you to the spawn island");
			p.sendMessage(ChatColor.GOLD +"/tags " + ChatColor.GRAY + "-- Select a tag to personalize your chat messages");
			p.sendMessage(ChatColor.GOLD +"/tpa {player} " + ChatColor.GRAY + "-- Request to tpa to a player of your choice");
			p.sendMessage(ChatColor.GOLD +"/tpaccept " + ChatColor.GRAY + "-- Accept a tpa request");
			p.sendMessage(ChatColor.GOLD +"/teams " + ChatColor.GRAY + "-- Display a sub area for team commands");
			p.sendMessage(ChatColor.GOLD +"/discord " + ChatColor.GRAY + "-- Get a discord invite");
			p.sendMessage(ChatColor.GOLD +"/nickname {name} " + ChatColor.GRAY + "-- Change your ingame nickname");
			p.sendMessage(ChatColor.GOLD +"/tell {name} {message}" + ChatColor.GRAY + "-- Whisper a freind ");
			p.sendMessage(ChatColor.GOLD +"/sethome " + ChatColor.GRAY + "-- Set your home");
			p.sendMessage(ChatColor.GOLD +"/nickname " + ChatColor.GRAY + "-- Change your ingame nickname");
			p.sendMessage(ChatColor.GOLD +"/home " + ChatColor.GRAY + "-- Teleport back to your home");
			p.sendMessage(ChatColor.GOLD +"/sethome " + ChatColor.GRAY + "-- Set your home");
			p.sendMessage(ChatColor.GOLD +"/token " + ChatColor.GRAY + "-- Learn everything you need to about tokens");
		}
		
		return false;
	}

}
