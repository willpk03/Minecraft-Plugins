package com.roadtripmc.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class tokencommands implements CommandExecutor {

	//token pay {name} {amount}
	//token give {name} {amount}
	//token bal
	//token baltop
	//token
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		ItemStack space = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
		ArrayList<String> lore2= new ArrayList<String>();
		lore2.add(" ");
        lore2.add("§BClick here to purchase");
        lore2.add(" ");
        ItemMeta spaceM = space.getItemMeta();
        spaceM.setDisplayName("Cost 40 Tokens");
        
		UUID u1 = UUID.randomUUID();
		UUID u2 = UUID.randomUUID();
		UUID u3 = UUID.randomUUID();
		
		while (u1.equals(u2) && u1.equals(u3) && u2.equals(u3)) {
			 u1 = UUID.randomUUID();
			 u2 = UUID.randomUUID();
		}

		ItemStack dragonArmour = new ItemStack(Material.LEATHER_BOOTS); 
		ItemMeta metaref1 = dragonArmour.getItemMeta();
	    ArrayList<String> lore= new ArrayList<String>();
	    metaref1.setLore(lore);
	    metaref1.setDisplayName("§6§lDragon Feet");
	    metaref1.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier( u1 ,"generic.armor", 5, Operation.ADD_NUMBER , EquipmentSlot.FEET));
	    metaref1.setUnbreakable(true);
	    
	    ItemStack dragonArmourLegs = new ItemStack(Material.LEATHER_LEGGINGS); 
		ItemMeta metaref11 = dragonArmourLegs.getItemMeta();
	    ArrayList<String> lore1= new ArrayList<String>();
	    metaref11.setLore(lore1);
	    metaref11.setDisplayName("§6§lDragon Leggings");
	    metaref11.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier(u2 ,"generic.armor", 10, Operation.ADD_NUMBER , EquipmentSlot.LEGS));
	    metaref11.setUnbreakable(true);
	    
	    ItemStack dragonArmourhelmet = new ItemStack(Material.LEATHER_HELMET); 
		ItemMeta metaref12 = dragonArmourhelmet.getItemMeta();
//	    ArrayList<String> lore2= new ArrayList<String>();
//	    metaref12.setLore(lore2);
	    metaref12.setDisplayName("§6§lDragon Helmet");
	    metaref12.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier(u3 ,"generic.armor", 5, Operation.ADD_NUMBER , EquipmentSlot.HEAD));
	    metaref12.setUnbreakable(true);
	    
	    dragonArmour.setItemMeta(metaref1);
		dragonArmourLegs.setItemMeta(metaref11);
		dragonArmourhelmet.setItemMeta(metaref12);
		space.setItemMeta(spaceM);
	    
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length != 0) {
				String commandtype = args[0];
				if (args.length == 3) {
					if(commandtype.equalsIgnoreCase("pay")) {
						try {
							Player p1 = Bukkit.getServer().getPlayer(args[1]); //the player getting the money
							int payment = Integer.parseInt(args[2]);	
			     			ResultSet rs2 = main.prepareStatement("Select * FROM users WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
			     			rs2.next();
			     			int money = rs2.getInt("Token");
			     			if(money >= payment) {
			     				if (payment <= 0) {
			     					payment = payment * -1;
			     				}
			     				//Takes away tokens from the player sending the money
			     				money = money - payment;
			     				main.prepareStatement("UPDATE users SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
			     				p1.sendMessage(Tag + "You have paid the player " + payment);
			     				//Grabs the money of the player being send the money
			     				ResultSet rs = main.prepareStatement("Select * FROM user WHERE UUID = '" + p1.getUniqueId() + "';" ).executeQuery();
				     			rs.next();
				     			int money2 = rs.getInt("Token");
				     			//Adds the money to the player given
				     			money2 = money2 + payment;
				     			main.prepareStatement("UPDATE users SET Token ='" + money2 + "'WHERE UUID = '" + p1.getUniqueId() + "';").executeUpdate();
				     			p1.sendMessage(Tag + "You have been paid by a player with " + payment);
				     			System.out.print("The user: " + p.getDisplayName() + "sent tokens to the user: " + p1.getDisplayName() );
			     				 
			     			} else {
			     				 p1.sendMessage(Tag + "You do not have enough Tokens give tokens to this player");
			     			}
						}catch (SQLException x) {
			     			x.printStackTrace();
				     	}
					} else if(commandtype.equalsIgnoreCase("give")) {
						
						Player reciever = Bukkit.getPlayer(args[1]);
						if (main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("admin")) { 
							
							int payment = Integer.parseInt(args[2]);
							try {
					 			ResultSet rs2 = main.prepareStatement("Select * FROM users WHERE UUID = '" + reciever.getUniqueId() + "';" ).executeQuery();
					 			rs2.next();
					 			int money = rs2.getInt("Token");
					 			money = money + payment;
					 			main.prepareStatement("UPDATE users SET Token ='" + money + "'WHERE UUID = '" + reciever .getUniqueId() + "';").executeUpdate();
					 			p.sendMessage(Tag + "You have given " + payment);
						
							}catch (SQLException x) {
							 x.printStackTrace();
							}
						}else {
							p.sendMessage(Tag + "You do not have permission to use this command");
						}
					}
				} else if (args.length == 2) {
					if (commandtype.equalsIgnoreCase("bal")) {
						Player p1 = Bukkit.getServer().getPlayer(args[1]);
						try {
							ResultSet rs2 = main.prepareStatement("Select * FROM users WHERE UUID = '" + p1.getUniqueId() + "';" ).executeQuery();
			     			rs2.next();
			     			int money = rs2.getInt("Token");
			     			p.sendMessage(Tag + "Player: " + p1.getDisplayName() + " Tokens: " + money);
						}catch (SQLException x) {
			     			x.printStackTrace();
				     	
						}
					}else if (commandtype.equalsIgnoreCase("shop")) {
						if (args[1].equalsIgnoreCase("dragonSet")) {
							Inventory dragonShop = Bukkit.getServer().createInventory(p, 9, "The Dragon Set");
							dragonShop.setItem(2, space);
							dragonShop.setItem(3, dragonArmourhelmet);
							dragonShop.setItem(4, dragonArmourLegs);
							dragonShop.setItem(5, dragonArmour);
							dragonShop.setItem(6, space);
							p.openInventory(dragonShop);
						}
					}
				} else if (args.length == 1) {
					if (commandtype.equalsIgnoreCase("top")) {
						try {
							ResultSet rs = main.prepareStatement("Select Token, DisplayName FROM users ORDER BY token DESC;" ).executeQuery();
			     			rs.next();
			     			ResultSet rs2 = main.prepareStatement("Select count(UUID) FROM users WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
			     			rs2.next();
			     			p.sendMessage(ChatColor.GOLD + "------" + ChatColor.GRAY + " " + ChatColor.BOLD + " Tokens Top (Top 10) "  + ChatColor.GOLD + "------");
							if(rs2.getInt(1) <= 9) {
								int x= 1;
								while (x != rs2.getInt(1) + 2) {
									p.sendMessage(ChatColor.GOLD + "- #" + x + ChatColor.GRAY + ChatColor.BOLD + " " + rs.getString(2) + " ("+ Integer.toString(rs.getInt(1)) + " Points)");
									rs.next();
									x++;
								}
//								for(x = 0; x >= rs2.getInt(1); x++) {
//									p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs.getInt(1)));
//									rs.next();
//								}
								
							}else {
								int x = 1;
								while (x != 11) {
									p.sendMessage(ChatColor.GOLD + "-- #" + x + ChatColor.BOLD + ChatColor.RED + " " + rs.getString(2) +  " ------ " + Integer.toString(rs.getInt(1)));
									rs.next();
									x++;
								}
//								for(x = 0; x == 10; x++) {
//									p.sendMessage(ChatColor.GOLD + "-- #1" + rs.getString(2) + " ------ " + Integer.toString(rs.getInt(1)));
//									rs].next();
//								}
								
							}
						}catch (SQLException x) {
			     			x.printStackTrace();
				     	
						}
						
					} else if (commandtype.equalsIgnoreCase("exchange")) {
						@SuppressWarnings("deprecation")
						ItemStack exchange = p.getInventory().getItemInHand();
						System.out.print(1);
						if (exchange.getType().equals(Material.DIAMOND)) {
							System.out.print(2);
							System.out.print(exchange);
							int amount = exchange.getAmount();
							try {
					 			ResultSet rs2 = main.prepareStatement("Select * FROM users WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
					 			rs2.next();
					 			int money = rs2.getInt("Token");
					 			money = money + amount;
					 			main.prepareStatement("UPDATE users SET Token ='" + money + "'WHERE UUID = '" + p .getUniqueId() + "';").executeUpdate();
					 			p.sendMessage(Tag + "You have forged " + amount + " diamonds to tokens");
					 			p.getInventory().setItemInMainHand(null);
							}catch (SQLException x) {
							 x.printStackTrace();
							}
						} else {
							p.sendMessage(Tag + "You can only forge Tokens with diamonds");
						}
					} 
				} else {

				}
			} else {
				try {
					ResultSet rs2 = main.prepareStatement("Select * FROM users WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
	     			rs2.next();
	     			int money = rs2.getInt("Token");
	     			p.sendMessage(ChatColor.GRAY + "---------" + Tag + "---------");
	     			p.sendMessage(Tag + "Tokens forged from Diamonds, the only item that appeal to the dragons");
	     			p.sendMessage(Tag + "Exchange diamonds for tokens using /token exchange");
	     			p.sendMessage(Tag + "Use Tokens to purchase Armour with /token Shop " + ChatColor.RED + "[Coming Patch #2]");
	     			p.sendMessage(Tag + "Show off to your friends in /token top ");
	     			p.sendMessage(Tag + "Your balance of Tokens: " + money);
				}catch (SQLException x) {
	     			x.printStackTrace();
		     	
				}
			}
		
		}
		return false;
	}
}


