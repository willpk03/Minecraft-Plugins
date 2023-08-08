package com.roadtripmc.main;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R1.AttributeModifier;

public class customItem implements CommandExecutor {
	

	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		
//		ItemStack space = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
//		ArrayList<String> lore2= new ArrayList<String>();
//		lore2.add(" ");
//        lore2.add("§BClick here to purchase");
//        lore2.add(" ");
//        ItemMeta spaceM = space.getItemMeta();
//        spaceM.setDisplayName("Cost 40 Tokens");
        
        
		UUID u1 = UUID.randomUUID();
		UUID u2 = UUID.randomUUID();
		UUID u3 = UUID.randomUUID();
		
		while (u1.equals(u2) && u1.equals(u3) && u2.equals(u3)) {
			 u1 = UUID.randomUUID();
			 u2 = UUID.randomUUID();
		}
		
		Player p = (Player) sender;
		ItemStack dragonArmour = new ItemStack(Material.LEATHER_BOOTS); 
		ItemMeta metaref1 = dragonArmour.getItemMeta();
	    ArrayList<String> lore= new ArrayList<String>();
	    metaref1.setLore(lore);
	    metaref1.setDisplayName("§6§lDragonArmour");
	    metaref1.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier( u1 ,"generic.armor", 5, Operation.ADD_NUMBER , EquipmentSlot.FEET));
	    
	    ItemStack dragonArmourLegs = new ItemStack(Material.LEATHER_LEGGINGS); 
		ItemMeta metaref11 = dragonArmourLegs.getItemMeta();
	    ArrayList<String> lore1= new ArrayList<String>();
	    metaref11.setLore(lore1);
	    metaref11.setDisplayName("§6§lDragonArmour");
	    metaref11.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier(u2 ,"generic.armor", 10, Operation.ADD_NUMBER , EquipmentSlot.LEGS));
	    
	    ItemStack dragonArmourhelmet = new ItemStack(Material.LEATHER_HELMET); 
		ItemMeta metaref12 = dragonArmourhelmet.getItemMeta();
//	    ArrayList<String> lore2= new ArrayList<String>();
//	    metaref12.setLore(lore2);
	    metaref12.setDisplayName("§6§lDragonArmour");
	    metaref12.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier(u3 ,"generic.armor", 5, Operation.ADD_NUMBER , EquipmentSlot.HEAD));
	    
	    
	    
	   
		dragonArmour.setItemMeta(metaref1);
		dragonArmourLegs.setItemMeta(metaref11);
		dragonArmourhelmet.setItemMeta(metaref12);
	    if (sender instanceof Player) {
			if (main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("admin")) {
				if (cmd.getName().equalsIgnoreCase("cgive")) {
					p.getInventory().addItem(dragonArmour);
					p.getInventory().addItem(dragonArmourLegs);
					p.getInventory().addItem(dragonArmourhelmet);
				}
			} else {
				p.sendMessage(Tag + "You're not allowed to do this");
			}
		}
		return false;
	}
	
	

}
