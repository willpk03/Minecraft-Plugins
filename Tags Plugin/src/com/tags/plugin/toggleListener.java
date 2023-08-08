package com.tags.plugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class toggleListener implements Listener {
	public void onClick(PlayerInteractEvent e) {
			
			//ItemStack on= new ItemStack(Material.LIME_DYE);
			//ItemStack off= new ItemStack(Material.GRAY_DYE);
			//((ItemMeta) on).setDisplayName("devmode");
			//((ItemMeta) off).setDisplayName("devmode");
			
			Player p = e.getPlayer();
			if (p.getItemInHand().getType().equals(Material.NETHER_STAR) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eNation Travel") ) {
				Inventory travel = Bukkit.getServer().createInventory(p, 9, "Travel to one of these Nations");
				ItemStack NA = new ItemStack(Material.GRASS);
				ItemMeta NAMeta = NA.getItemMeta();
				NAMeta.setDisplayName("North America");
				ArrayList<String> NAlore= new ArrayList<String>();
	            NAlore.add("§BTeleport to North America");
	            NAMeta.setLore(NAlore);
	            NA.setItemMeta(NAMeta);
	            
	            ItemStack SA = new ItemStack(Material.JUNGLE_LOG);
				ItemMeta SAMeta = SA.getItemMeta();
				SAMeta.setDisplayName("North America");
				ArrayList<String> SAlore= new ArrayList<String>();
	            SAlore.add("§BTeleport to South America");
	            SAMeta.setLore(SAlore);
	            SA.setItemMeta(SAMeta);
	            
	            ItemStack Aus = new ItemStack(Material.RED_SAND);
				ItemMeta AusMeta = Aus.getItemMeta();
				AusMeta.setDisplayName("Australia");
				ArrayList<String> Auslore= new ArrayList<String>();
				Auslore.add("§BTeleport to Australia");
				AusMeta.setLore(Auslore);
				Aus.setItemMeta(AusMeta);
				
				ItemStack Africa = new ItemStack(Material.SAND);
				ItemMeta AfricaMeta = Africa.getItemMeta();
				AfricaMeta.setDisplayName("Africa");
				ArrayList<String> Africalore= new ArrayList<String>();
				Africalore.add("§BTeleport to Africa");
				AfricaMeta.setLore(Africalore);
				Africa.setItemMeta(AfricaMeta);
				
				ItemStack England = new ItemStack(Material.CHISELED_STONE_BRICKS);
				ItemMeta EnglandMeta = England.getItemMeta();
				EnglandMeta.setDisplayName("England");
				ArrayList<String> Englandlore= new ArrayList<String>();
				Englandlore.add("§BTeleport to England");
				EnglandMeta.setLore(Englandlore);
				England.setItemMeta(EnglandMeta);
				
				travel.setItem(1, NA);
				travel.setItem(2, SA);
				travel.setItem(3, Aus);
				travel.setItem(4, Africa);
				travel.setItem(5, England);
				
				p.openInventory(travel);
				
				
	            
	            
			} else {
				System.out.print(p.getItemInHand().getType() +" " + p.getItemInHand().getItemMeta().getDisplayName());
			}
	}
}
