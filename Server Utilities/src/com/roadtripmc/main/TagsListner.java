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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TagsListner implements Listener {
	ArrayList<Player> king = new ArrayList<>();
	ArrayList<Player> queen = new ArrayList<>();
	ArrayList<Player> slayer = new ArrayList<>();
	ArrayList<Player> BaseBuilder = new ArrayList<>();
	ArrayList<Player> PeaceKeeper = new ArrayList<>();
	ArrayList<Player> TreasureHunter = new ArrayList<>();
	String invalidPermission = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMc] " + ChatColor.GRAY + "You have" + ChatColor.RED + " insufficent permission" + ChatColor.GRAY + " to use this Tag, you can purchase them at the store!";
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
	
	@EventHandler
	private void inventoryClick(InventoryClickEvent e) {
		 Player p = (Player) e.getWhoClicked();
	     String inventory = e.getView().getTitle();
         if (inventory.equalsIgnoreCase("Tags - Click one below")){
             e.setCancelled(true);
             if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                 return;
             }
            

                if(e.getSlot() == 1 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lKing"))){
                    if (p.hasPermission("tags.king")) {
	    				if (king.contains(p)) {
	    					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMc] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
	    					king.remove(p);
	    				} else { //Not Enabled
	    					king.add(p);
	    					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMc] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag King!");
	    					if (queen.contains(p)) {
	    						queen.remove(p);
	    					}
	    					if (slayer.contains(p)) {
	    						slayer.remove(p);
	    					}
	    					if (BaseBuilder.contains(p)) {
	    						BaseBuilder.remove(p);	
	    					}
	    					if (PeaceKeeper.contains(p)) {
	    						PeaceKeeper.remove(p);
	    					}
	    					if (TreasureHunter.contains(p)) {
	    						TreasureHunter.remove(p);
	    					}
	    				}
    			p.closeInventory();
                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                    } else {
                		p.sendMessage(invalidPermission);
                	}

                } else if(e.getSlot() == 3 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lQueen"))){
                	if (p.hasPermission("tags.queen")) {
	                	if (queen.contains(p)) {
	        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
	        				queen.remove(p);
	        			} else { //Not Enabled
	        				queen.add(p);
	        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag Queen!");
	        				if (king.contains(p)) {
	        					king.remove(p);
	        				}
	        				if (slayer.contains(p)) {
	        					slayer.remove(p);
	        				}
	        				if (BaseBuilder.contains(p)) {
	    						BaseBuilder.remove(p);	
	    					}
	    					if (PeaceKeeper.contains(p)) {
	    						PeaceKeeper.remove(p);
	    					}
	    					if (TreasureHunter.contains(p)) {
	    						TreasureHunter.remove(p);
	    					}
	        				
	        				
	        			}
                	p.closeInventory();
                	} else {
                		p.sendMessage(invalidPermission);
                	}
                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);

                } else if(e.getSlot() == 5 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSlayer"))){
                	if (p.hasPermission("tags.slayer")) {
                	if (slayer.contains(p)) {
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
        				slayer.remove(p);
        			} else { //Not Enabled
        				slayer.add(p);
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag Slayer!");
        				if (king.contains(p)) {
        					king.remove(p);
        				}
        				if (queen.contains(p)) {
    						queen.remove(p);
    					}
        				if (BaseBuilder.contains(p)) {
    						BaseBuilder.remove(p);	
    					}
    					if (PeaceKeeper.contains(p)) {
    						PeaceKeeper.remove(p);
    					}
    					if (TreasureHunter.contains(p)) {
    						TreasureHunter.remove(p);
    					}
        				
        				
        			}
                	p.closeInventory();
                	} else {
                		p.sendMessage(invalidPermission);
                	}

                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);

                } else if ((e.getSlot() == 10 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBase Builder")))){
                	if (p.hasPermission("tags.basebuilder")) {
                	if (BaseBuilder.contains(p)) {
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
        				BaseBuilder.remove(p);
        			} else { //Not Enabled
        				BaseBuilder.add(p);
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag Base Builder!");
        				if (king.contains(p)) {
        					king.remove(p);
        				}
        				if (queen.contains(p)) {
    						queen.remove(p);
    					}
        				if (slayer.contains(p)) {
    						slayer.remove(p);	
    					}
    					if (PeaceKeeper.contains(p)) {
    						PeaceKeeper.remove(p);
    					}
    					if (TreasureHunter.contains(p)) {
    						TreasureHunter.remove(p);
    					}
        				
        			
        			}
                	p.closeInventory();
                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                	}else {
                		p.sendMessage(invalidPermission);
                	}

                } else if ((e.getSlot() == 12 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lPeace Keeper")))){
                	if (p.hasPermission("tags.peacekeeper")) {
                	if (PeaceKeeper.contains(p)) {
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
        				PeaceKeeper.remove(p);
        			} else { //Not Enabled
        				PeaceKeeper.add(p);
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag Peace Keeper!");
        				if (king.contains(p)) {
        					king.remove(p);
        				}
        				if (queen.contains(p)) {
    						queen.remove(p);
    					}
        				if (slayer.contains(p)) {
    						slayer.remove(p);	
    					}
    					if (BaseBuilder.contains(p)) {
    						BaseBuilder.remove(p);
    					}
    					if (TreasureHunter.contains(p)) {
    						TreasureHunter.remove(p);
    					}
        				
        				
        			}
                	p.closeInventory();
                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                	}
                } else if ((e.getSlot() == 14 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTreasure Hunter")))){
                	if (p.hasPermission("tags.treasurehunter")) {
                	if (TreasureHunter.contains(p)) {
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
        				TreasureHunter.remove(p);
        			} else { //Not Enabled
        				TreasureHunter.add(p);
        				p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag Treasure Hunter!");
        				if (king.contains(p)) {
        					king.remove(p);
        				}
        				if (queen.contains(p)) {
    						queen.remove(p);
    					}
        				if (slayer.contains(p)) {
    						slayer.remove(p);	
    					}
    					if (BaseBuilder.contains(p)) {
    						BaseBuilder.remove(p);
    					}
    					if (PeaceKeeper.contains(p)) {
    						PeaceKeeper.remove(p);
    					}
        				
        				
        			}
                	p.closeInventory();
                 //p.playSound(e.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                	}else {
                		p.sendMessage(invalidPermission);
                	}

                }
          } else if (inventory.equalsIgnoreCase("The Dragon Set")) {
        	  e.setCancelled(true);
              if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                  return;
              } else if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {

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
//          	    ArrayList<String> lore2= new ArrayList<String>();
//          	    metaref12.setLore(lore2);
          	    metaref12.setDisplayName("§6§lDragonArmour");
          	    metaref12.addAttributeModifier(Attribute.GENERIC_ARMOR, new org.bukkit.attribute.AttributeModifier(u3 ,"generic.armor", 5, Operation.ADD_NUMBER , EquipmentSlot.HEAD));
          	    
          	  dragonArmour.setItemMeta(metaref1);
          	  dragonArmourLegs.setItemMeta(metaref11);
          	  dragonArmourhelmet.setItemMeta(metaref12);
            	  try {
						
						int payment = 30;	
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
		     				p.sendMessage(Tag + "You've bought the dragon set for 30 tokens");
		     				p.getInventory().addItem(dragonArmour);
							p.getInventory().addItem(dragonArmourLegs);
							p.getInventory().addItem(dragonArmourhelmet);
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens give tokens to this player");
		     			}
					}catch (SQLException x) {
		     			x.printStackTrace();
			     	}
              }
          }else if (inventory.equalsIgnoreCase("RoadTripMC - Rules")) {
        	  e.setCancelled(true);
          }
	}
	
	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent e) {
		try {
			Player p = e.getPlayer();
			Rank rank = main.getFileManager().getRank(p);
			String rankPrefix = rank.getColor() + "[" + rank.getName() + "]";
			double i = Math.random() * 20;
			int intX = (int) (i / 1);
			if (intX == 5) {
				ResultSet rs2 = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
				rs2.next();
				int playerID  = rs2.getInt("USERID");
				ResultSet rs5 = main.prepareStatement("SELECT Points FROM teams WHERE USERID = '" + playerID+ "';").executeQuery();
				rs5.next();
				int PlayerPoints = rs5.getInt(1);
				PlayerPoints = PlayerPoints + 10;
				main.prepareStatement("UPDATE teams SET Points = " + PlayerPoints + " WHERE USERID = '" + playerID + "';").executeUpdate();
				p.sendMessage(Tag + "You have been given 10 points for chatting.");   
			}
			String DEFAULT = rankPrefix + ChatColor.WHITE + " [" + ChatColor.YELLOW + p.getDisplayName() + ChatColor.WHITE + "] " + ChatColor.GRAY;
			String kingt = ChatColor.WHITE + "[" + ChatColor.BLUE + "King"+ ChatColor.WHITE + "] ";
			String queent = ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "Queen" + ChatColor.WHITE + "] ";
			String slayert = ChatColor.DARK_RED + "[" + ChatColor.DARK_GRAY + "Slayer" + ChatColor.DARK_RED + "] ";
			String BaseBuildert = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Base Builder" + ChatColor.GRAY + "] ";
			String PeaceKeepert = ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "Peace Keeper" + ChatColor.DARK_GREEN + "] ";
			String TreasureHuntert = ChatColor.GRAY + "[" + ChatColor.GOLD + "Treasure Hunter" + ChatColor.GRAY + "] ";
			String NoTeamTag = ChatColor.GRAY + "[" + ChatColor.WHITE + "No Team" + ChatColor.GRAY + "] ";
			String DefaultRankt = ChatColor.BLUE + "[MEMBER]";
			String SupportRankt = ChatColor.DARK_GREEN+ "[SUPPORT]";
			String ModRankt = ChatColor.GREEN + "[MODERATOR]";
			String AdminRank = ChatColor.RED+ "[ADMIN]";
			String ManagerRankt = ChatColor.RED + "[MANAGER]";
			String SeniorManRankt = ChatColor.DARK_RED+ "[SENIOR MANAGER]";
			if (king.contains(p)) {
				e.setFormat(DEFAULT + kingt + ChatColor.GRAY+ e.getMessage());
			} else if (queen.contains(p)) {
				e.setFormat(DEFAULT + queent+ ChatColor.GRAY+ e.getMessage());
			}else if (slayer.contains(p)) {
				e.setFormat(DEFAULT + slayert+ ChatColor.GRAY+ e.getMessage());	
			}else if (BaseBuilder.contains(p)) {
				e.setFormat( DEFAULT + BaseBuildert+ ChatColor.GRAY+ e.getMessage());
			}else if (PeaceKeeper.contains(p)) {
				e.setFormat(DEFAULT + PeaceKeepert+ ChatColor.GRAY+ e.getMessage());
			}else if (TreasureHunter.contains(p)) {
				e.setFormat(DEFAULT + TreasureHuntert+ ChatColor.GRAY + e.getMessage());
			} else {
				e.setFormat(DEFAULT + e.getMessage());
			}
			String pFormat = e.getFormat();
			
				ResultSet rs = main.prepareStatement("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "'").executeQuery();
				rs.next();
				int playerID  = rs.getInt("USERID");
				ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM teams WHERE USERID = '" + playerID + "';").executeQuery();
				
				teamCheck2.next();
				int Points = teamCheck2.getInt("points");
				String TeamTag = ChatColor.GRAY + "[" + ChatColor.WHITE + Points + ChatColor.GRAY + "] ";
				e.setFormat(TeamTag + pFormat);
			

		}catch(SQLException x) {
			x.printStackTrace();
		
		}
	}
	
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e) {
		ArrayList<String> rare= new ArrayList<String>();
		rare.add("RARE");
		
		ArrayList<String> lore2= new ArrayList<String>();
		lore2.add(" ");
        lore2.add("§BUnderscovered - Right click the book in your hand to echant.");
        lore2.add(" ");
		Player p = e.getPlayer();
		ItemStack heldItem = p.getInventory().getItemInMainHand();
		if (heldItem.getItemMeta().getLore().contains(lore2)) {
			Inventory CE = Bukkit.getServer().createInventory(p, 36, "CustomEnchant");
			p.openInventory(CE);
		}
	}
}
