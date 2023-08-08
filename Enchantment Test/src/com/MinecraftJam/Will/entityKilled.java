package com.MinecraftJam.Will;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import net.md_5.bungee.api.ChatColor;

public class entityKilled implements Listener {
	HashMap<UUID, Location> previousLocation = new HashMap<UUID, Location>();
	HashMap<UUID, Location> previousLocation2 = new HashMap<UUID, Location>();
	HashMap<UUID, Location> previousLocation3 = new HashMap<UUID, Location>();
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	
	public void onentitydeath(EntityDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			int x = 0;
			Player p = e.getEntity().getKiller();
			//p.sendMessage(e.getEntity().getName());
			if (!(p.getItemInHand().equals(null) && p.getItemInHand().equals(Material.AIR))) {
				switch(e.getEntity().getName()) {
					case "Zombie":
						x = (int) (Math.random() * 10);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 2;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.zombieEnchantment.getKey()))) {
							if (x >= 7) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " zombie trait" + ChatColor.GRAY + " on your weapon " );
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.zombieEnchantment , 1);
								addLoretoItem("Zombie 1", p.getInventory().getItemInMainHand(), 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Sheep":
						 x = (int) (Math.random() * 10);
						 if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
								x = x + 2;
							}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.SheepEnchantment.getKey()))) {
							if (x >= 9) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " Sheep trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.SheepEnchantment , 1);
								addLoretoItem("Sheep 1", p.getInventory().getItemInMainHand() , 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						
						break;
					case "Creeper":
						x = (int) (Math.random() * 10);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.creeperEnchantment.getKey()))) {
							x = x + 2;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.creeperEnchantment.getKey()))) {
							if (x >= 8) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " Creeper trait" + ChatColor.GRAY + " on your weapon ");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.creeperEnchantment , 1);
								addLoretoItem("Creeper 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Skeleton":
						x = (int) (Math.random() * 10);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 2;
						}
						//!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.SheepEnchantment.getKey()))
						//!p.getInventory().getItemInHand().getEnchantments().containsKey(main.skeletonEnchantment.getKey())
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.skeletonEnchantment.getKey()))) {
							if (x >= 7) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " Skeleton trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.skeletonEnchantment , 1);
								addLoretoItem("Skeleton 1", p.getInventory().getItemInMainHand(), 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Chicken":
						x = (int) (Math.random() * 10);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 2;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.chickenEnchantment.getKey()))) {
							if (x >= 9) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " Chcicken trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.chickenEnchantment , 1);
								addLoretoItem("Chicken 1", p.getInventory().getItemInMainHand(), 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Cod":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.fishEnchantment.getKey()))) {
							if (x >= 95) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + "Fish trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.fishEnchantment , 1);
								addLoretoItem("Fish 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Salmon":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.fishEnchantment.getKey()))) {
							if (x >= 95) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + "Fish trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.fishEnchantment , 1);
								addLoretoItem("Fish 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Tropical Fish":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.fishEnchantment.getKey()))) {
							if (x >= 85) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + "Fish trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.fishEnchantment , 1);
								addLoretoItem("Fish 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Horse":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + "Horse trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.horseEnchantment , 1); 
								addLoretoItem("Horse 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Donkey":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
							if (x >= 85) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " 'Horse' trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.horseEnchantment , 1);
								addLoretoItem("Horse 1", p.getInventory().getItemInMainHand() , 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Mule":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
							if (x >= 85) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " 'Horse' trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.horseEnchantment , 1);
								addLoretoItem("Horse 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Skeleton Horse":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
							if (x >= 66) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.GOLD + " 'Horse' trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.horseEnchantment , 1);
								addLoretoItem("Horse 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Polar Bear":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.polarbearEnchantment.getKey()))) {
							if (x >= 95) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + " [Ultra Rare] Bear Rage trait" + ChatColor.GRAY + " on your weapon " );
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.polarbearEnchantment , 1);
								addLoretoItem("Bear Rage 1", p.getInventory().getItemInMainHand(), 3);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Wolf":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.wolfEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + " Wolf trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.wolfEnchantment , 1);
								addLoretoItem("Wolf 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Panda":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.polarbearEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + " [Ultra Rare] Bear Rage trait" + ChatColor.GRAY + " on your weapon" );
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.polarbearEnchantment , 1);
								addLoretoItem("Bear Rage 1", p.getInventory().getItemInMainHand(), 3);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Spider":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.spiderEnchantment.getKey()))) {
							if (x >= 85) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Spider trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.spiderEnchantment , 1);
								addLoretoItem("Spider 1", p.getInventory().getItemInMainHand() , 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Cave Spider":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.spiderEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Spider trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.spiderEnchantment , 1);
								addLoretoItem("Spider 1", p.getInventory().getItemInMainHand(), 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Snow Golem":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.snowmanEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Snow Man trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.snowmanEnchantment, 1);
								addLoretoItem("Snowman 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Mooshroom":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.mooshroomEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Mooshroom trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.mooshroomEnchantment, 1);
								addLoretoItem("Mooshroom 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Cow":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.mooshroomEnchantment.getKey()))) {
							if (x >= 98) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] 'Mooshroom' trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.mooshroomEnchantment, 1);
								addLoretoItem("Mooshroom 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Piglin":
						x = (int) (Math.random() * 100);
						//!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.polarbearEnchantment.getKey()))
						//!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.piglinEnchantment.getKey()))
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.piglinEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Piglin trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.piglinEnchantment, 1);
								addLoretoItem("Piglin 1", p.getInventory().getItemInMainHand() ,1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Zombified Piglin":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.piglinEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Piglin trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.piglinEnchantment, 1);
								addLoretoItem("Piglin 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Wither":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witherEnchantment.getKey()))) {
							if (x >= 0) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Ultra Rare] Wither trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.witherEnchantment, 1);
								addLoretoItem("Wither 1", p.getInventory().getItemInMainHand(), 3);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Wither Skeleton":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witherSkelEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] Wither Skeleton trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.witherSkelEnchantment, 1);
								addLoretoItem("Wither Skeleton 1", p.getInventory().getItemInMainHand(), 2);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Dolphin":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.dolphinEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] Dolphin trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.dolphinEnchantment, 1);
								addLoretoItem("Dolphin 1", p.getInventory().getItemInMainHand(), 2);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Villager":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.VillagerEnchantment.getKey()))) {
							if (x >= 66) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Villager trait" + ChatColor.GRAY +" on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.VillagerEnchantment, 1);
								addLoretoItem("Villager 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Enderman":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderManEnchantment.getKey()))) {
							if (x >= 85) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "EnderMan trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.enderManEnchantment, 1);
								addLoretoItem("Ender Man 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Endermite":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderManEnchantment.getKey()))) {
							if (x >= 80) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "EnderMan trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.enderManEnchantment, 1);
								addLoretoItem("Ender Man 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Husk":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.huskEnchantment.getKey()))) {
							if (x >= 75) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Husk trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.huskEnchantment, 1);
								addLoretoItem("Husk 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Ghast":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.ghastEnchantment.getKey()))) {
							if (x >= 70) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] Ghast trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.ghastEnchantment, 1);
								addLoretoItem("Ghast 1", p.getInventory().getItemInMainHand(), 2);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Stray":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.strayEnchantment.getKey()))) {
							if (x >= 75) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Stray trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.strayEnchantment, 1);
								addLoretoItem("Stray 1", p.getInventory().getItemInMainHand(), 0);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Strider":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.striderEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] Strider trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.striderEnchantment, 1);
								addLoretoItem("Strider 1", p.getInventory().getItemInMainHand(), 2);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Witch":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witchEnchantment.getKey()))) {
							if (x >= 90) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Rare] Witch trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.witchEnchantment, 1);
								addLoretoItem("Witch 1", p.getInventory().getItemInMainHand(), 2);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Blaze":
						x = (int) (Math.random() * 100);
						if (p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							x = x + 20;
						}
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.blazeEnchantment.getKey()))) {
							if (x >= 75) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "Blaze trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.blazeEnchantment, 1);
								addLoretoItem("Blaze 1", p.getInventory().getItemInMainHand(), 1);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
					case "Ender Dragon":
						x = (int) (Math.random() * 100);
						if(!p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderDragonEnchantment.getKey()))) {
							if (x >= 0) {
								p.sendMessage(ChatColor.GRAY + "You have gained the" +  ChatColor.BOLD + ChatColor.GOLD + "[Ultra Rare] Ender Dragon trait" + ChatColor.GRAY + " on your weapon");
								p.getInventory().getItemInMainHand().addUnsafeEnchantment(main.enderDragonEnchantment, 1);
								addLoretoItem("Ender Dragon 1", p.getInventory().getItemInMainHand(), 3);
							} else {
								p.sendMessage(ChatColor.DARK_GRAY + "Unlucky");
							}
						}else {
							//p.sendMessage("Player has enchantment already");
						}
						break;
				}
			}
		}
		
		
		System.out.println("Something was killed");
	}
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent e) {
		//this area could be optimized
		if(e.getPlayer() instanceof Player) {
			Player p = e.getPlayer();
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.SheepEnchantment.getKey()))) {
				int x = p.getLocation().getBlockX();
				int y = p.getLocation().getBlockY();
				int z = p.getLocation().getBlockZ();
				if(p.getWorld().getBlockAt(x, y -1, z).getType().equals(Material.GRASS_BLOCK)) {
					int x2 = 0;
					int y2 = 0;
					int z2 = 0;
					if(previousLocation.get(p.getUniqueId()) != null) {
						Location prevloc = previousLocation.get(p.getUniqueId());
						x2 = (int) prevloc.getBlockX();
						y2 = (int) prevloc.getBlockY();
						z2 = (int) prevloc.getBlockZ();
						//p.sendMessage("Doesn't equal null");
					} 
					
					if(x2 != x || y2 != y || z != z2) {
						int r = (int) (Math.random() * 100);
						if(r >= 90) {
							p.getWorld().getBlockAt(x, y -1, z).setType(Material.DIRT);
							p.setSaturation(p.getSaturation() + 2);
							p.sendMessage(ChatColor.GOLD + "[Sheep]" + ChatColor.GRAY +"You ate some grass and regained some hunger");
						} else {
							//p.sendMessage("Unlucky");
						}
						previousLocation.put(p.getUniqueId(), p.getLocation());
					}else {
//						p.sendMessage("Nums equal the same" + x2 + y2 + z2 + x + y + z);
					}
				} else {
//					p.sendMessage(p.getWorld().getBlockAt(x, y - 1, z).getType().toString());
//					p.sendMessage(previousLocation.get(p.getUniqueId()).toString());
				}
				
			} else {
				//p.sendMessage("No enchantment");
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.snowmanEnchantment.getKey()))) {
				int x = p.getLocation().getBlockX();
				int y = p.getLocation().getBlockY();
				int z = p.getLocation().getBlockZ();
				if(!p.getWorld().getBlockAt(x, y -1, z).getType().equals(Material.AIR )&& p.getWorld().getBlockAt(x, y, z).isLiquid() == false && !p.getWorld().getBlockAt(x, y - 1, z).isPassable()) {
//					System.out.print(p.getWorld().getBlockAt(x, y -1, z).getType().equals(Material.AIR));
//					System.out.print(p.getWorld().getBlockAt(x, y, z).isLiquid() == false);
//					System.out.print(p.getWorld().getBlockAt(x, y - 1, z).isPassable());
					int x2 = 0;
					int y2 = 0;
					int z2 = 0;
					if(previousLocation2.get(p.getUniqueId()) != null) {
						Location prevloc = previousLocation2.get(p.getUniqueId());
						x2 = (int) prevloc.getBlockX();
						y2 = (int) prevloc.getBlockY();
						z2 = (int) prevloc.getBlockZ();
						//p.sendMessage("Doesn't equal null");
					} 
					
					if(x2 != x || y2 != y || z != z2) {
						
						p.getWorld().getBlockAt(x, y , z).setType(Material.SNOW);
						
						previousLocation2.put(p.getUniqueId(), p.getLocation());
					}else {
						//p.sendMessage("Nums equal the same" + x2 + y2 + z2 + x + y + z);
					}
				
					//p.sendMessage(p.getWorld().getBlockAt(x, y - 1, z).getType().toString());
					//p.sendMessage(previousLocation2.get(p.getUniqueId()).toString());
				}
			} else {
				//p.sendMessage("You don't have snowman trait");
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.piglinEnchantment.getKey()))) {
				int x = p.getLocation().getBlockX();
				int y = p.getLocation().getBlockY();
				int z = p.getLocation().getBlockZ();
				if(p.getWorld().getBlockAt(x, y -1, z).getType().equals(Material.NETHERRACK)) {
					int x2 = 0;
					int y2 = 0;
					int z2 = 0;
					if(previousLocation3.get(p.getUniqueId()) != null) {
						Location prevloc = previousLocation3.get(p.getUniqueId());
						x2 = (int) prevloc.getBlockX();
						y2 = (int) prevloc.getBlockY();
						z2 = (int) prevloc.getBlockZ();
						//p.sendMessage("Doesn't equal null");
					} 
					
					if(x2 != x || y2 != y || z != z2) {
						int random = (int) (Math.random() * 1000);
						if (random >= 955) {
							int rItem = (int) (Math.random() * 4 + 1);
							int r = 0;
							while (r <= rItem) {
								p.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET));
								r++;
							}
							p.sendMessage(ChatColor.GOLD + "[Piglin]" + ChatColor.GRAY +" Your Piglin instincts gained you a few Gold nuggets in the ground");
							previousLocation3.put(p.getUniqueId(), p.getLocation());
						}
						
					}else {
//						p.sendMessage("Nums equal the same" + x2 + y2 + z2 + x + y + z);
					}
				
//					p.sendMessage(p.getWorld().getBlockAt(x, y - 1, z).getType().toString());
//					p.sendMessage(previousLocation3.get(p.getUniqueId()).toString());
				}
			} else {
				//p.sendMessage("You don't have Piglin trait");
			}
		}
	}
	
	
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		//Something here isn't connecting
		//whenever they take fall damage it isn't bringing up this event
		//look for a new event maybe
		System.out.print(e.getCause().toString());
		if (e.getCause().name() == DamageCause.LAVA.name()) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.striderEnchantment.getKey()))) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3 * 20, 1));
				}
			}
//			System.out.print("Someone hurt themselves");
//			if (e.getEntity() instanceof Player) {
//				Player p = (Player) e.getEntity();
//				p.sendMessage("You fell");
//				if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.chickenEnchantment.getKey()))) {
//					int r = (int) (Math.random() * 3);
//					if (r >= 0) {
//						e.isCancelled();
//						p.sendMessage(ChatColor.GOLD + "[Chicken]" + ChatColor.GRAY +" You fluttered onto the ground");
//					}else {
//						p.sendMessage("unlucky");
//					}
//				}
//			} else {
//				System.out.print("Not instance of player");
//			}
		}
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
//			p.sendMessage("You hit someone");
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.zombieEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 90) {
					if(!p.getInventory().contains(Material.ROTTEN_FLESH)) {
						p.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH));
						p.sendMessage(ChatColor.GOLD + "[Zombie]" + ChatColor.GRAY +" You forged some rotten flesh");
					}else {
						//p.sendMessage("You have rotten Flesh");
					}
				}else {
					//p.sendMessage("unlucky");
				}
			} else {
				//p.sendMessage("You dont have this enchantment ZOMBIE");
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.mooshroomEnchantment.getKey()))) {
				System.out.print("Mooshroom enchant being used");
				int r = (int) (Math.random() * 100);
				if (r >= 70) {
					if(p.getInventory().contains(Material.BOWL)) {
						int x = 0;
						while(x <= 35) {
							System.out.print(x);
							if(p.getInventory().getItem(x) != null && !p.getInventory().getItem(x).getType().equals(Material.AIR)) {
								if(p.getInventory().getItem(x).getType().equals(Material.BOWL)) {
									p.getInventory().setItem(x, new ItemStack(Material.MUSHROOM_STEW,p.getInventory().getItem(x).getAmount()));
								}
							}
							
							//p.sendMessage(p.getInventory().getItem(x).getType().toString());
							x++;
						}
//						if(p.getInventory().getItem(-106) == new ItemStack(Material.BOWL)) {
//							p.getInventory().setItem(x, new ItemStack(Material.MUSHROOM_STEW));
//						}
						p.sendMessage(ChatColor.GOLD + "[Mooshroom]" + ChatColor.GRAY +" You grew some mushrooms and turned them into Stew");
					}else {
						//p.sendMessage("You have rotten Flesh");
					}
				}else {
					//p.sendMessage("unlucky");
				}
			} else {
				//p.sendMessage("You dont have this enchantment ZOMBIE");
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.enderManEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 90) {
					if(!p.getInventory().contains(Material.ENDER_PEARL)) {
						p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
						p.sendMessage(ChatColor.GOLD + "[EnderMan]" + ChatColor.GRAY +" You forged a Ender Pearl");
					}else {
						//p.sendMessage("You have an Ender Pearl");
					}
				}else {
					//p.sendMessage("unlucky");
				}
			} else {
				//p.sendMessage("You dont have this enchantment ZOMBIE");
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.creeperEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 95) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 1);
					p.sendMessage(ChatColor.GOLD + "[Creeper]" + ChatColor.GRAY +"Kaboom");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.ghastEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 95) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2);
					p.sendMessage(ChatColor.GOLD + "[Ghast]" + ChatColor.GRAY +"Kaboom");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witherEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 80) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 1);
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 5, 1));
						p.sendMessage(ChatColor.GOLD + "[Wither]" + ChatColor.GRAY +"You withered the enemy");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witherSkelEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 80) {
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 5, 1));
						p.sendMessage(ChatColor.GOLD + "[Wither Skeleton]" + ChatColor.GRAY +"You withered the enemy");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.spiderEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 80) {
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().getBlockX(),e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ()).setType(Material.COBWEB);
					p.sendMessage(ChatColor.GOLD + "[Spider]" + ChatColor.GRAY + "You spinned a web");
					//e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().getBlockX(),e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ()).setType(Material.COBWEB);
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.polarbearEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3 * 20, 1));
					p.sendMessage(ChatColor.GOLD + "[Bear Rage]" + ChatColor.GRAY +"You gain a second of Bear Rage");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3 * 20, 3));
					p.sendMessage(ChatColor.GOLD + "[Horse]" + ChatColor.GRAY +"You empowered your jump");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.fishEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 3 * 20 , 1));
					p.sendMessage(ChatColor.GOLD + "[Fish]" + ChatColor.GRAY +"You now turn water into air");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.chickenEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 3 * 20 , 1));
					p.sendMessage(ChatColor.GOLD + "[Chicken]" + ChatColor.GRAY + "You feel alittle light");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.dolphinEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 3* 20, 1));
					p.sendMessage(ChatColor.GOLD + "[Dolphin]" + ChatColor.GRAY +"You found Dolphins Grace");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.striderEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 15* 20, 1));
					p.sendMessage(ChatColor.GOLD + "[Strider]" + ChatColor.GRAY +"You feel like heat doesn't effect you");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.skeletonEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 75) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15* 20, 1));
					p.sendMessage(ChatColor.GOLD + "[Skeleton]" + ChatColor.GRAY +"You feel weightless");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.VillagerEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 85) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10* 20, 1));
					p.sendMessage(ChatColor.GOLD + "[Villager]" + ChatColor.GRAY +"You gained the hard working power of the villagers");
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.blazeEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 85) {
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).setFireTicks(10);
						
						p.sendMessage(ChatColor.GOLD + "[Blaze]" + ChatColor.GRAY +"You burnt your opponent");
					} else if (e.getEntity() instanceof Player) {
						((Player)e.getEntity()).setFireTicks(30);
						p.sendMessage(ChatColor.GOLD + "[Blaze]" + ChatColor.GRAY +"You burnt your opponent");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.huskEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 85) {
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5* 20, 1));
						
						p.sendMessage(ChatColor.GOLD + "[Husk]" + ChatColor.GRAY +"You made your opponent hungry");
					} else if (e.getEntity() instanceof Player) {
						((Player)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5* 20, 1));
						p.sendMessage(ChatColor.GOLD + "[Husk]" + ChatColor.GRAY +"You made your opponent hungry");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.strayEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 85) {
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5* 20, 1));
						
						p.sendMessage(ChatColor.GOLD + "[Stray]" + ChatColor.GRAY +"You slowed others down");
					} else if (e.getEntity() instanceof Player) {
						((Player)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5* 20, 1));
						p.sendMessage(ChatColor.GOLD + "[Stray]" + ChatColor.GRAY +"You slowed others down");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.witchEnchantment.getKey()))) {
				int r = (int) (Math.random() * 100);
				if (r >= 85) {
					ArrayList<PotionEffectType> potions= new ArrayList<PotionEffectType>();
					potions.add(PotionEffectType.BLINDNESS);
					potions.add(PotionEffectType.SLOW);
					potions.add(PotionEffectType.SLOW_DIGGING);
					potions.add(PotionEffectType.POISON);
					potions.add(PotionEffectType.GLOWING);
					potions.add(PotionEffectType.HARM);
					potions.add(PotionEffectType.LEVITATION);
					int r2 = (int) (Math.random() * 6);
					if(e.getEntity() instanceof LivingEntity) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(potions.get(r2), 5* 20, 1));
						p.sendMessage(ChatColor.GOLD + "[Witch]" + ChatColor.GRAY +"You created a potion and gave it to the enemy");
					} else if (e.getEntity() instanceof Player) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(potions.get(r2), 5* 20, 1));
						p.sendMessage(ChatColor.GOLD + "[Witch]" + ChatColor.GRAY +"You created a potion and gave it to the enemy");
					}
					
				}
			}
			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.wolfEnchantment.getKey()))) {
				if(e.getEntity() instanceof LivingEntity) {
					int r = (int) (Math.random() * 100);
					if (r >= 85) {
						((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 5* 20, 1));
						p.sendMessage(ChatColor.GOLD + "[Wolf]" + ChatColor.GRAY +"You gained the scent of your enemy");
					}
				}
			}
			
			
		}
		System.out.print("DamageCheck");
		if(e.getCause() == DamageCause.FALL) {
			
		}else {
			System.out.print("You didn't fall");
		}
	}
	@EventHandler    
	public void oninventoryChange(PlayerChangedMainHandEvent e) {
		System.out.print(e.getMainHand());
	}
	public static void addLoretoItem(String Enchantment, ItemStack item, int Rarity) {
		ItemMeta meta = item.getItemMeta();
		if(meta.getLore() != null) {
			List<String> lore= meta.getLore();
			
			switch(Rarity) {
				case 0:
					lore.add(ChatColor.AQUA+ ""+ ChatColor.DARK_AQUA + Enchantment);
					break;
				case 1:
					lore.add(ChatColor.BLUE+ "" + ChatColor.AQUA + Enchantment);
					break;
				case 2:
					lore.add(ChatColor.DARK_BLUE + "" + ChatColor.BLUE + Enchantment);
					break;
				case 3:
					lore.add(ChatColor.GREEN + ""+ ChatColor.DARK_BLUE + Enchantment);
					break;
			}
			Collections.sort(lore);
			
//			lore = meta.getLore();
			meta.setLore(lore);
			item.setItemMeta(meta);

		} else {
			ArrayList<String> lore= new ArrayList<String>();
			switch(Rarity) {
			case 0:
				lore.add(ChatColor.AQUA+ ""+ ChatColor.DARK_AQUA + Enchantment);
				break;
			case 1:
				lore.add(ChatColor.BLUE+ "" + ChatColor.AQUA + Enchantment);
				break;
			case 2:
				lore.add(ChatColor.DARK_BLUE + "" + ChatColor.BLUE + Enchantment);
				break;
			case 3:
				lore.add(ChatColor.GREEN + ""+ ChatColor.DARK_BLUE + Enchantment);
				break;
		}
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
		
		
		
	}
}
