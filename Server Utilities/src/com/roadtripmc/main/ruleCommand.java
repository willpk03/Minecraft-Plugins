package com.roadtripmc.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ruleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 ItemStack ref1 = new ItemStack(Material.BOOK);
         ItemMeta metaref1 = ref1.getItemMeta();
         metaref1.setDisplayName("§6§l#1 - No being disrespectful");
         ref1.setItemMeta(metaref1);
         
         ItemStack ref11 = new ItemStack(Material.BOOK);
         ItemMeta metaref11 = ref11.getItemMeta();
         //ref11.addEnchantment(Enchantment.ARROW_INFINITE, 1);
         metaref11.setDisplayName("§6§l#2 - No advertising");
         ref11.setItemMeta(metaref11);
         
         ItemStack ref111 = new ItemStack(Material.BOOK);
         ItemMeta metaref111 = ref111.getItemMeta();
         //ref111.addEnchantment(Enchantment.ARROW_INFINITE, 1);
         metaref111.setDisplayName("§6§l#3 - No URLs in chat");
         ref111.setItemMeta(metaref111);
         
         ItemStack ref1111 = new ItemStack(Material.BOOK);
         ItemMeta metaref1111 = ref1111.getItemMeta();
         //ref1111.addEnchantment(Enchantment.ARROW_INFINITE, 1);
         metaref1111.setDisplayName("§6§l#4 -No Threats of hacking/DDOS");
         ref1111.setItemMeta(metaref1111);
         
         ItemStack ref11111 = new ItemStack(Material.BOOK);
         ItemMeta metaref11111 = ref11111.getItemMeta();
//         ref11111.addEnchantment(Enchantment.ARROW_INFINITE, 1);
         metaref11111.setDisplayName("§6§l#5 -No impersonating staff");
         ref11111.setItemMeta(metaref11111); 
         
         ItemStack ref111111 = new ItemStack(Material.BOOK);
         ItemMeta metaref111111 = ref111111.getItemMeta();
         //ref111111.addEnchantment(Enchantment.ARROW_INFINITE, 1);
         metaref111111.setDisplayName("§6§l#6 - Have Fun!");
         ref111111.setItemMeta(metaref111111); 
         
         if ((sender instanceof Player)) {
	         Player p = (Player) sender;
	    //Creates the inventory
	           Inventory rules = Bukkit.getServer().createInventory(p, 9, "RoadTripMC - Rules");
	           rules.setItem(1, ref1);
	           rules.setItem(2, ref11);
	           rules.setItem(3, ref111);
	           rules.setItem(5, ref1111);
	           rules.setItem(6, ref11111);
	           rules.setItem(7, ref111111);
	           p.openInventory(rules);
         }

		return false;
	}

}
