package com.MinecraftJam.Will;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class enchantListener implements Listener {
//	@EventHandler 
//	public void oninventoryChange(PlayerChangedMainHandEvent e) {
//		System.out.print("Player changed hand");
//		Player p = e.getPlayer();
//		if(p.getInventory().getItemInMainHand() != null) {
//			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.fishEnchantment.getKey()))) {
//				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100000 , 1));
//			} else {
//				p.removePotionEffect(PotionEffectType.WATER_BREATHING);
//			}
//			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.horseEnchantment.getKey()))) {
//				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000 , 1));
//			}else {
//				p.removePotionEffect(PotionEffectType.JUMP);
//			}
//			
//		}
//		
//	}
//	@EventHandler
//	public void onMoveEvent(PlayerMoveEvent e) {
//
//			Player p = e.getPlayer();
//			p.sendMessage("Moving");
//			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.SheepEnchantment.getKey()))) {
//				int x = p.getLocation().getBlockX();
//				int y = p.getLocation().getBlockY();
//				int z = p.getLocation().getBlockZ();
//				if(p.getWorld().getBlockAt(x, y, z).getType().equals(Material.GRASS_BLOCK)) {
//					int r = (int) (Math.random() * 100);
//					if(r >= 90) {
//						p.getWorld().getBlockAt(x, y -1, z).setType(Material.GRASS_BLOCK);
//						p.setSaturation(p.getSaturation() + 2);
//						p.sendMessage(ChatColor.GRAY +"You ate some grassed and regained some hunger");
//					} else {
//						p.sendMessage("Unlucky");
//					}
//				} else {
//					p.sendMessage(p.getWorld().getBlockAt(x, y - 1, z).getType().toString());
//				}
//				
//			} else {
//				p.sendMessage("No enchantment");
//			}
//	}
	
//	@EventHandler
//	public void onEntityDamage(EntityDamageByEntityEvent e) {
//		if(e.getDamager() instanceof Player) {
//			Player p = (Player) e.getDamager();
//			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.zombieEnchantment.getKey()))) {
//				int r = (int) (Math.random() * 10);
//				if (r >= 9) {
//					if(!p.getInventory().contains(Material.ROTTEN_FLESH)) {
//						p.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH));
//					}
//				}
//			}
//			if(p.getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.getByKey(main.creeperEnchantment.getKey()))) {
//				int r = (int) (Math.random() * 10);
//				if (r >= 10) {
//					((Entity) e).getWorld().createExplosion(e.getEntity().getLocation(), 1);
//				}
//			}
//		}
//	}
}
