package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class travelCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ArrayList<Player> netherTravel = main.netherTravel;
		ArrayList<Player> moonTravel = main.moonTravel;
		String Error = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY + "You have" + ChatColor.RED + " insufficent permission!";
		String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Exchanger] " + ChatColor.GRAY;
		if ((sender instanceof Player)) {
			Player p = (Player) sender;
			ItemStack hand = p.getItemInHand();
	         int handAmount = hand.getAmount();
		         if (hand.getType() == Material.OBSIDIAN && !netherTravel.contains(p)) {
		        	 if (handAmount == 1) {
		        		 p.setItemInHand(null);
		        		 netherTravel.add(p);
		        		 //p.sendMessage(Tag + "You've used a piece of Obisidian and once you go to sleep you will be teleported to the nether");
	
		        	 } else if (handAmount > 1) {
		        		 hand.setAmount(handAmount - 1);
		        		 //p.sendMessage(Tag + "You've used a piece of Obisidian and once you go to sleep you will be teleported to the nether");
		        	 }
		        	 try {
			     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
			     			rs2.next();
			     			int money = rs2.getInt("Token");
			     			if (money >= 10) {
			     				money = money - 10;
			     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
			     				 p.sendMessage(Tag + "You've used a piece of Obisidian, and a 10 Tokens. Now once you go to sleep you will be teleported to the nether");
			     			} else {
			     				 p.sendMessage(Tag + "You've used a piece of Obsidian, but you didn't have 10 Tokens. So you've lost that piece of obsidian");
			     			}
			     			//p.sendMessage(Tag + " " + money);
			     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
			     		}catch (SQLException x) {
			     			x.printStackTrace();
			     		}
		         } else if (hand.getType().equals(Material.ENDER_EYE) && hand.getItemMeta().getDisplayName().equalsIgnoreCase("Moon Travel")) {
		        	 if (!moonTravel.contains(p)) {
			        	 moonTravel.add(p);
			        	 
				   		 p.sendMessage(Tag + "You are now traveling to the end");
				   		Bukkit.getServer().createWorld(new WorldCreator("world_the_end"));
				   		Location location = new Location(Bukkit.getWorld("world_the_end"), -118, 57, 58);
	//		            location.setWorld("world_the_end");
	//		            location.setX(0);
	//		            location.setY(80);
	//		            location.setZ(0);
			            p.teleport(location);
			            p.sendMessage(Tag + "Welcome, this is no dream, welcome to the moon");
		        	 } else {
		        		 Bukkit.getServer().createWorld(new WorldCreator("world"));
		        		 moonTravel.remove(p);
					   		Location location = new Location(Bukkit.getWorld("world"), -118, 57, 58);
		//		            location.setWorld("world_the_end");
		//		            location.setX(0);
		//		            location.setY(80);
		//		            location.setZ(0);
				            p.teleport(location);
				            p.sendMessage(Tag + "You've woken back, in a strange place. Good luck getting back home");
				            if (!moonTravel.contains(p)) {
					        	 if (handAmount == 1) {
					        		 p.setItemInHand(null);
					        		 //p.sendMessage(Tag + "You've used a piece of Obisidian and once you go to sleep you will be teleported to the nether");
				
					        	 } else if (handAmount > 1) {
					        		 hand.setAmount(handAmount - 1);
					        		 //p.sendMessage(Tag + "You've used a piece of Obisidian and once you go to sleep you will be teleported to the nether");
					        	 }
				            }
		        	 }
			     } else if (p.getItemInHand().getType().equals(Material.NETHER_STAR) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("Nation Travel") ) {
						Inventory travel = Bukkit.getServer().createInventory(p, 9, "Travel to a continents");
						ItemStack NA = new ItemStack(Material.GRASS_BLOCK);
						ItemMeta NAMeta = NA.getItemMeta();
						NAMeta.setDisplayName("§eNorth America");
						ArrayList<String> NAlore= new ArrayList<String>();
			            NAlore.add("§BTeleport to North America");
			            NAMeta.setLore(NAlore);
			            NA.setItemMeta(NAMeta);
			            
			            ItemStack SA = new ItemStack(Material.JUNGLE_LOG);
						ItemMeta SAMeta = SA.getItemMeta();
						SAMeta.setDisplayName("§eSouth America");
						ArrayList<String> SAlore= new ArrayList<String>();
			            SAlore.add("§BTeleport to South America");
			            SAMeta.setLore(SAlore);
			            SA.setItemMeta(SAMeta);
			            
			            ItemStack Aus = new ItemStack(Material.RED_SAND);
						ItemMeta AusMeta = Aus.getItemMeta();
						AusMeta.setDisplayName("§eAustralia");
						ArrayList<String> Auslore= new ArrayList<String>();
						Auslore.add("§BTeleport to Australia");
						AusMeta.setLore(Auslore);
						Aus.setItemMeta(AusMeta);
						
						ItemStack Africa = new ItemStack(Material.SAND);
						ItemMeta AfricaMeta = Africa.getItemMeta();
						AfricaMeta.setDisplayName("§eAfrica");
						ArrayList<String> Africalore= new ArrayList<String>();
						Africalore.add("§BTeleport to Africa");
						AfricaMeta.setLore(Africalore);
						Africa.setItemMeta(AfricaMeta);
						
						ItemStack England = new ItemStack(Material.CHISELED_STONE_BRICKS);
						ItemMeta EnglandMeta = England.getItemMeta();
						EnglandMeta.setDisplayName("§eEurope");
						ArrayList<String> Englandlore= new ArrayList<String>();
						Englandlore.add("§BTeleport somewhere in Europe");
						EnglandMeta.setLore(Englandlore);
						England.setItemMeta(EnglandMeta);
						
						ItemStack Japan = new ItemStack(Material.KELP);
						ItemMeta JapanMeta = Japan.getItemMeta();
						JapanMeta.setDisplayName("§eAsia");
						ArrayList<String> Japanlore= new ArrayList<String>();
						Japanlore.add("§BTeleport somewhere in Asia");
						JapanMeta.setLore(Japanlore);
						Japan.setItemMeta(JapanMeta);
						
						ItemStack Russia = new ItemStack(Material.SNOW_BLOCK);
						ItemMeta RussiaMeta = Russia.getItemMeta();
						RussiaMeta.setDisplayName("§eAntarctica");
						ArrayList<String> Russialore= new ArrayList<String>();
						Russialore.add("§BTeleport to Antarctica");
						RussiaMeta.setLore(Russialore);
						Russia.setItemMeta(RussiaMeta);
						
						
						travel.setItem(1, NA);
						travel.setItem(2, SA);
						travel.setItem(3, Aus);
						travel.setItem(4, Africa);
						travel.setItem(5, England);
						travel.setItem(6, Japan);
						travel.setItem(7, Russia);
						
						p.openInventory(travel);
			     }else {
			   		 p.sendMessage(Tag + "You do not have the correct item, contact the admin if this is wrong");
			   		 System.out.print(hand.getType() + hand.getItemMeta().getDisplayName());
			     }
			     			//p.sendMessage(Tag + " " + money);
			     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery(
		         
	         
		}
		return false;
	}

}
