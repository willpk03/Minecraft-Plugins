package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class inventoryListner implements Listener {
	ArrayList<Player> king = new ArrayList<>();
	ArrayList<Player> queen = new ArrayList<>();
	ArrayList<Player> slayer = new ArrayList<>();
	ArrayList<Player> BaseBuilder = new ArrayList<>();
	ArrayList<Player> PeaceKeeper = new ArrayList<>();
	ArrayList<Player> TreasureHunter = new ArrayList<>();
	String invalidPermission = ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "You have" + ChatColor.RED + " insufficent permission" + ChatColor.GRAY + " to use this Tag, you can purchase them at the store!";
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[Market Place] " + ChatColor.GRAY;
	
	@EventHandler
	private void inventoryClick(InventoryClickEvent e) {
		 Player p = (Player) e.getWhoClicked();
	       
         if (e.getInventory().getTitle().equalsIgnoreCase("Tags - Click one below")){
             e.setCancelled(true);
             if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                 return;
             }
            

                if(e.getSlot() == 1 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lKing"))){
                    if (p.hasPermission("tags.king")) {
	    				if (king.contains(p)) {
	    					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You have disabled it");
	    					king.remove(p);
	    				} else { //Not Enabled
	    					king.add(p);
	    					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"[TAGS] " + ChatColor.GRAY + "" + ChatColor.BOLD + "You've " + ChatColor.GREEN + "" + ChatColor.BOLD +"added " + ChatColor.GRAY + "" + ChatColor.BOLD + "the tag King!");
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
          } else if (e.getInventory().getTitle().equalsIgnoreCase("The Market Place")){
              e.setCancelled(true);
              if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                  return;
              }
              if(e.getSlot() == 10 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("What Now?"))){
            	  try {
		     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs2.next();
		     			int money = rs2.getInt("Token");
		     			if (money >= 1) {
		     				money = money - 1;
		     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     				 p.sendMessage(Tag + "You have bought one What Now Book for 1 Token");
		     				 p.getInventory().addItem(new ItemStack(Material.BOOK));
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens to buy the Book");
		     			}
		     			//p.sendMessage(Tag + " " + money);
		     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
		     		}catch (SQLException x) {
		     			x.printStackTrace();
		     		}
              } else if(e.getSlot() == 14 && (e.getCurrentItem().getType().equals(Material.ENCHANTED_GOLDEN_APPLE))){
            	  try {
		     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs2.next();
		     			int money = rs2.getInt("Token");
		     			if (money >= 9) {
		     				money = money - 9;
		     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     				 p.sendMessage(Tag + "You have bought one Enchanted Golden Apple for 9 Tokens");
		     				 p.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens to buy the Enchanted Golden Apple");
		     			}
		     			//p.sendMessage(Tag + " " + money);
		     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
		     		}catch (SQLException x) {
		     			x.printStackTrace();
		     		}
              } else if(e.getSlot() == 11 && (e.getCurrentItem().getType().equals(Material.CHEST))){
            	  try {
		     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs2.next();
		     			int money = rs2.getInt("Token");
		     			if (money >= 1) {
		     				money = money - 1;
		     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     				 p.sendMessage(Tag + "You have bought one Food Crate for 1 Tokens");
		     				 p.setHealth(20);
		     				 p.setSaturation(20);
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens to buy the Food Crate");
		     			}
		     			//p.sendMessage(Tag + " " + money);
		     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
		     		}catch (SQLException x) {
		     			x.printStackTrace();
		     		}
              } else if(e.getSlot() == 12 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Moon Travel"))){
            	  try {
		     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs2.next();
		     			int money = rs2.getInt("Token");
		     			if (money >= 100) {
		     				money = money - 100;
		     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     				 p.sendMessage(Tag + "You have bought one Moon Travel for 100 Tokens");
		     				 
		     				 ItemStack moonTravel = new ItemStack(Material.LEGACY_EYE_OF_ENDER);
		     	             ItemMeta mtMeta = moonTravel.getItemMeta();
		     	             mtMeta.setDisplayName("Moon Travel");
		     	             ArrayList<String> mtlore = new ArrayList<String>();
		     	             mtlore.add("§BYou've always wanted to reach for the skys.");
		     	             mtlore.add("§BYou've went to hell and back.");
		     	             mtlore.add("§BNow you could be on a trip to the moon.");
		     	             
		     	             mtMeta.setLore(mtlore);
		     	             moonTravel.setItemMeta(mtMeta);
		     	             
		     				 p.getInventory().addItem(moonTravel);
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens to buy the Moon Travel");
		     			}
		     			//p.sendMessage(Tag + " " + money);
		     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
		     		}catch (SQLException x) {
		     			x.printStackTrace();
		     		}
              } else if(e.getSlot() == 13 && (e.getCurrentItem().getType().equals(Material.NETHER_STAR))){
            	  try {
		     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
		     			rs2.next();
		     			int money = rs2.getInt("Token");
		     			if (money >= 25) {
		     				money = money - 25;
		     				main.prepareStatement("UPDATE user SET Token ='" + money + "'WHERE UUID = '" + p.getUniqueId() + "';").executeUpdate();
		     				 p.sendMessage(Tag + "You have bought one Nation Travel for 25 Tokens");
		     				 
		     				 ItemStack nationTravel = new ItemStack(Material.NETHER_STAR);
		     	             ItemMeta ntMeta = nationTravel.getItemMeta();
		     	             ntMeta.setDisplayName("Nation Travel");
		     	             ArrayList<String> ntlore = new ArrayList<String>();
		     	             ntlore.add("§BTravel to any of the nations");
		     	             ntMeta.setLore(ntlore);
		     	             nationTravel.setItemMeta(ntMeta);
		     	             
		     				 p.getInventory().addItem(nationTravel);
		     			} else {
		     				 p.sendMessage(Tag + "You do not have enough Tokens to buy the Nation Travel");
		     			}
		     			//p.sendMessage(Tag + " " + money);
		     			//main.prepareStatement("UPDATE user SET Token = " + money + "WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
		     		}catch (SQLException x) {
		     			x.printStackTrace();
		     		}
              } 
          } else if (e.getInventory().getTitle().equalsIgnoreCase("Travel to a continents")){
        	  e.setCancelled(true);
        	  if(e.getSlot() == 1 && (e.getCurrentItem().getType().equals(Material.GRASS_BLOCK))){
	        		int x;
	        		int z;
	        		Random rand = new Random();
	        		x = rand.nextInt(1116);
	        		x = x + 2396;
	        		x = x * -1;
	        		z = rand.nextInt(752);
	        		z = z + 1004;
	        		z = z * -1;
	              	Bukkit.getServer().createWorld(new WorldCreator("world"));
	  			   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
	  			   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}
                } else if(e.getSlot() == 2 && (e.getCurrentItem().getType().equals(Material.JUNGLE_LOG))){
                	int x;
            		int z;
            		Random rand = new Random();
                	x = rand.nextInt(888);
            		x = x + 1248;
            		x = x * -1;
            		z = rand.nextInt(656);
            		z = z + 106;
            		
                	Bukkit.getServer().createWorld(new WorldCreator("world"));
    			   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
    			   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}
    			   	
    			   	
                } else if(e.getSlot() == 3 && (e.getCurrentItem().getType().equals(Material.RED_SAND))){
                	int x;
            		int z;
            		Random rand = new Random();
                	x = rand.nextInt(980);
            		x = x + 3484;
            		z = rand.nextInt(416);
            		z = z + 632;
                	Bukkit.getServer().createWorld(new WorldCreator("world"));
    			   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
    			   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}
                } else if(e.getSlot() == 4 && (e.getCurrentItem().getType().equals(Material.SAND))){
                	int x;
            		int z;
            		Random rand = new Random();
                	x = rand.nextInt(772);
            		x = x + 260;
            		z = rand.nextInt(1560);
            		z = z - 852;
                	Bukkit.getServer().createWorld(new WorldCreator("world"));
    			   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
    			   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}

                }else if(e.getSlot() == 5 && (e.getCurrentItem().getType().equals(Material.CHISELED_STONE_BRICKS))){
                	int x;
            		int z;
            		Random rand = new Random();
                	x = rand.nextInt(998);
            		x = x - 164;
            		z = rand.nextInt(564);
            		z = z + 1160;
            		z = z * -1;
                 	Bukkit.getServer().createWorld(new WorldCreator("world"));
        		   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
        		   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}

                }else if(e.getSlot() == 6 && (e.getCurrentItem().getType().equals(Material.KELP))){
                	int x;
            		int z;
            		Random rand = new Random();
                	x = rand.nextInt(2256);
            		x = x - 1444;
            		z = rand.nextInt(1139);          				
            		z = z + 900;
            		z = z * -1;
            		System.out.print(z);
                 	Bukkit.getServer().createWorld(new WorldCreator("world"));
            	   	Location location = new Location(Bukkit.getWorld("world"), x, 68, z);
            	   	if (location.getBlock().getType().equals(Material.AIR)) {
				   		p.teleport(location);
				   	} else {
				   		p.sendMessage(Tag + "Your location is inside a block and so you weren't teleported. Try agian");
				   		System.out.print(location.getBlock().getType());
				   	}
                } else if(e.getSlot() == 7 && (e.getCurrentItem().getType().equals(Material.SNOW_BLOCK))){
                  Bukkit.getServer().createWorld(new WorldCreator("world"));
            		Location location = new Location(Bukkit.getWorld("world"), 3668, 66, -1852);
            		p.teleport(location);

                } else {
                	System.out.print("Error #2");
                }
          } else {
        	  System.out.print("Error #1");
          }
	}
	
	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String DEFAULT = ChatColor.WHITE + "[" + ChatColor.YELLOW + p.getDisplayName() + ChatColor.WHITE + "] " + ChatColor.GRAY + e.getMessage();
		String kingt = ChatColor.WHITE + "[" + ChatColor.BLUE + "King"+ ChatColor.WHITE + "] ";
		String queent = ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "Queen" + ChatColor.WHITE + "] ";
		String slayert = ChatColor.DARK_RED + "[" + ChatColor.DARK_GRAY + "Slayer" + ChatColor.DARK_RED + "] ";
		String BaseBuildert = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Base Builder" + ChatColor.GRAY + "] ";
		String PeaceKeepert = ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "Peace Keeper" + ChatColor.DARK_GREEN + "] ";
		String TreasureHuntert = ChatColor.GRAY + "[" + ChatColor.GOLD + "Treasure Hunter" + ChatColor.GRAY + "] ";
		String NoTeamTag = ChatColor.GRAY + "[" + ChatColor.WHITE + "No Team" + ChatColor.GRAY + "] ";
		if (king.contains(p)) {
			e.setFormat(kingt + DEFAULT);
		} else if (queen.contains(p)) {
			e.setFormat(queent + DEFAULT);
		}else if (slayer.contains(p)) {
			e.setFormat(slayert + DEFAULT);	
		}else if (BaseBuilder.contains(p)) {
			e.setFormat(BaseBuildert + DEFAULT);
		}else if (PeaceKeeper.contains(p)) {
			e.setFormat(PeaceKeepert + DEFAULT);
		}else if (TreasureHunter.contains(p)) {
			e.setFormat(TreasureHuntert + DEFAULT);
		} else {
			e.setFormat(DEFAULT);
		}
		String pFormat = e.getFormat();
		try {
			ResultSet teamCheck2 = main.prepareStatement("SELECT * FROM team WHERE UUID = '" + p.getUniqueId() + "';").executeQuery();
			
			teamCheck2.next();
			String TeamName = teamCheck2.getString("TeamName");
			if (TeamName ==  "") {
				e.setFormat(NoTeamTag + pFormat);
			} else {
				String TeamTag = ChatColor.GRAY + "[" + ChatColor.WHITE + TeamName + ChatColor.GRAY + "] ";
				e.setFormat(TeamTag + pFormat);
			}

		}catch(SQLException x) {
			x.printStackTrace();
		
		}
	}

}
