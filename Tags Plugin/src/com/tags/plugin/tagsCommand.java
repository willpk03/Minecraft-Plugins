package com.tags.plugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tagsCommand implements CommandExecutor {
	//String[] Tags = main.tags;
	ArrayList<Player> king = new ArrayList<>();
	ArrayList<Player> queen = new ArrayList<>();
	ArrayList<Player> slayer = new ArrayList<>();
	String[] tagsTitle;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Player player = (Player) sender;
//		if (player instanceof Player) {
//		//Creating the inventory
//		Inventory tags = Bukkit.getServer().createInventory(player, 9, "Tags");
//		ItemStack king = new ItemStack(Material.TURTLE_HELMET);
//		ItemMeta kingMeta = king.getItemMeta();
//		kingMeta.setDisplayName("§6§lKing");
//		ArrayList<String> lore = new ArrayList<String>();
//		lore.add(" ");
//		lore.add("Stylise your chat with this theme");
//		king.setItemMeta(kingMeta);
//		tags.setItem(5, king);
//		
//		
//		// Opens the inventory
//		player.openInventory(tags);
//		}
//		return false;
		if ((sender instanceof Player)) {
	         Player p = (Player)sender;
	    //Creates the inventory
	           Inventory help = Bukkit.getServer().createInventory(p, 18, "Tags - Click one below");
	           
	    //Defines the items in the inventory
	               ItemStack ref1 = new ItemStack(Material.BOOK);
	               ItemMeta metaref1 = ref1.getItemMeta();
	               ArrayList<String> lore= new ArrayList<String>();
	               lore.add(" ");
	               lore.add("§BSelect the tag, to stylise your chat");
	               lore.add(" ");
	               lore.add("§BBuy on the store");

	               
	               metaref1.setLore(lore);
	               metaref1.setDisplayName("§6§lKing");
	               ref1.setItemMeta(metaref1);
	               help.setItem(1, ref1);
	               
	               ItemStack ref2 = new ItemStack(Material.BOOK);
	               ItemMeta metaref2 = ref2.getItemMeta();
	               metaref2.setLore(lore);
	               metaref2.setDisplayName("§6§lQueen");
	               ref2.setItemMeta(metaref2);
	               help.setItem(3, ref2);
	               
	               ItemStack ref3 = new ItemStack(Material.BOOK);
	               ItemMeta metaref3 = ref3.getItemMeta();
	               metaref3.setLore(lore);
	               metaref3.setDisplayName("§6§lSlayer");
	               ref3.setItemMeta(metaref3);
	               help.setItem(5, ref3);
	               
	               ItemStack ref4 = new ItemStack(Material.NETHER_STAR);
	               ItemMeta metaref4 = ref4.getItemMeta();
	               metaref4.setLore(lore);
	               metaref4.setDisplayName("§6§lComing Soon");
	               ref4.setItemMeta(metaref4);
	               help.setItem(16, ref4);
	               help.setItem(7, ref4);
	               
//	               ItemStack ref5 = new ItemStack(Material.BOOK);
//	               ItemMeta metaref5 = ref5.getItemMeta();
//	               metaref5.setLore(lore);
//	               metaref5.setDisplayName("§6§lFighter");
//	               ref5.setItemMeta(metaref5);
//	               help.setItem(7, ref5);
	               
	               ItemStack ref6 = new ItemStack(Material.BOOK);
	               ItemMeta metaref6 = ref6.getItemMeta();
	               metaref6.setLore(lore);
	               metaref6.setDisplayName("§6§lBase Builder");
	               ref6.setItemMeta(metaref6);
	               help.setItem(10, ref6);
	               
	               ItemStack ref7 = new ItemStack(Material.BOOK);
	               ItemMeta metaref7 = ref7.getItemMeta();
	               metaref7.setLore(lore);
	               metaref7.setDisplayName("§6§lPeace Keeper");
	               ref7.setItemMeta(metaref7);
	               help.setItem(12, ref7);
	               
	               ItemStack ref8 = new ItemStack(Material.BOOK);
	               ItemMeta metaref8 = ref8.getItemMeta();
	               metaref8.setLore(lore);
	               metaref8.setDisplayName("§6§lTreasure Hunter");
	               ref8.setItemMeta(metaref8);
	               help.setItem(14, ref8);
	               
	               
	               ItemStack space = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
	               ItemMeta spaceM = space.getItemMeta();
	               spaceM.setDisplayName(" ");
	               space.setItemMeta(spaceM);
	               //Creates the Stained glass every even number
	               int i;
	               
	               for (i = 0; i <= 9; i = i + 2 ) {
	            	   help.setItem(i, space);
	               }
	               for (i = 9; i <= 16; i = i + 2 ) {
	            	   help.setItem(i, space);
	               }
	           //Opens the inventory for the user
	           p.openInventory(help);
	           
	         }
	       return false;
	}


}
