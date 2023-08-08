package com.MinecraftJam.Will;

import java.lang.reflect.Field;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.WorldCreator;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;



import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R1.Item;


	

public class main extends JavaPlugin implements Listener{
	private static main Main;
	public static ZombieEnchantment zombieEnchantment;
	public static sheepEnchantment SheepEnchantment;
	public static creeperEnchantment creeperEnchantment;
	public static skeletonEnchantment skeletonEnchantment;
	public static ChickenEnchantment chickenEnchantment;
	public static fishEnchantment fishEnchantment;
	public static horseEnchantment horseEnchantment;
	public static PolarBearEnchantment polarbearEnchantment;
	public static SnowmanarEnchantment snowmanEnchantment;
	public static WolfEnchantment wolfEnchantment;
	public static SpiderEnchantment spiderEnchantment;
	public static DolphinEnchantment dolphinEnchantment;
	public static BlazeEnchantment blazeEnchantment;
	public static StriderEnchantment striderEnchantment;
	public static WitherSkelEnchantment witherSkelEnchantment;
	public static WitherEnchantment witherEnchantment;
	public static EnderManEnchantment enderManEnchantment;
	public static MooshroomEnchantment mooshroomEnchantment;
	public static PiglinEnchantment piglinEnchantment;
	public static villagerEnchantment VillagerEnchantment;
	public static huskEnchantment huskEnchantment;
	public static GhastEnchantment ghastEnchantment;
	public static StrayEnchantment strayEnchantment;
	public static WitchEnchantment witchEnchantment;
	public static EnderDragonEnchantment enderDragonEnchantment;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		System.out.print("MC but Mobs give you super powers enabled");
		main.Main = this; 
		
		
		
		
		Bukkit.getPluginManager().registerEvents(new entityKilled(), this);
		Bukkit.getPluginManager().registerEvents(new enchantListener(), this);
		registerEnchantment(zombieEnchantment = new ZombieEnchantment());
		registerEnchantment(SheepEnchantment = new sheepEnchantment());
		registerEnchantment(creeperEnchantment = new creeperEnchantment());
		registerEnchantment(skeletonEnchantment = new skeletonEnchantment());
		registerEnchantment(chickenEnchantment = new ChickenEnchantment());
		registerEnchantment(fishEnchantment = new fishEnchantment()); //Cod Tropical other
		registerEnchantment(horseEnchantment = new horseEnchantment()); //Donkey Mull
		registerEnchantment(polarbearEnchantment = new PolarBearEnchantment()); //Panda
		registerEnchantment(snowmanEnchantment = new SnowmanarEnchantment()); 
		registerEnchantment(wolfEnchantment = new WolfEnchantment());
		registerEnchantment(spiderEnchantment = new SpiderEnchantment()); //cave spider
		registerEnchantment(dolphinEnchantment = new DolphinEnchantment());
		registerEnchantment(blazeEnchantment = new BlazeEnchantment());
		registerEnchantment(striderEnchantment = new StriderEnchantment());
		registerEnchantment(witherSkelEnchantment = new WitherSkelEnchantment());
		registerEnchantment(witherEnchantment = new WitherEnchantment());
		registerEnchantment(enderManEnchantment = new EnderManEnchantment()); // endermite
		registerEnchantment(mooshroomEnchantment = new MooshroomEnchantment()); //cow
		registerEnchantment(piglinEnchantment = new PiglinEnchantment()); //Zombified version aswell
		registerEnchantment(VillagerEnchantment = new villagerEnchantment());
		registerEnchantment(huskEnchantment = new huskEnchantment());
		registerEnchantment(ghastEnchantment = new GhastEnchantment());
		registerEnchantment(strayEnchantment = new StrayEnchantment());
		registerEnchantment(witchEnchantment = new WitchEnchantment());
		registerEnchantment(enderDragonEnchantment = new EnderDragonEnchantment());
	
	}
	
	@Override
	public void onDisable() {
		try {
			Field keyfield = Enchantment.class.getDeclaredField("byKey");
			keyfield.setAccessible(true);
			
			HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyfield.get(null);
			if(byKey.containsKey(zombieEnchantment.getKey())) {
				byKey.remove(zombieEnchantment.getKey());
			}
			if(byKey.containsKey(SheepEnchantment.getKey())) {
				byKey.remove(SheepEnchantment.getKey());
			}
			if(byKey.containsKey(creeperEnchantment.getKey())) {
				byKey.remove(creeperEnchantment.getKey());
			}
			if(byKey.containsKey(skeletonEnchantment.getKey())) {
				byKey.remove(skeletonEnchantment.getKey());
			}
			if(byKey.containsKey(chickenEnchantment.getKey())) {
				byKey.remove(chickenEnchantment.getKey());
			}
			if(byKey.containsKey(fishEnchantment.getKey())) {
				byKey.remove(fishEnchantment.getKey());
			}
			if(byKey.containsKey(horseEnchantment.getKey())) {
				byKey.remove(horseEnchantment.getKey());
			}
			if(byKey.containsKey(snowmanEnchantment.getKey())) {
				byKey.remove(snowmanEnchantment.getKey());
			}
			if(byKey.containsKey(wolfEnchantment.getKey())) {
				byKey.remove(wolfEnchantment.getKey());
			}
			if(byKey.containsKey(polarbearEnchantment.getKey())) {
				byKey.remove(polarbearEnchantment.getKey());
			}
			if(byKey.containsKey(spiderEnchantment.getKey())) {
				byKey.remove(spiderEnchantment.getKey());
			}
			if(byKey.containsKey(dolphinEnchantment.getKey())) {
				byKey.remove(dolphinEnchantment.getKey());
			}
			
			if(byKey.containsKey(blazeEnchantment.getKey())) {
				byKey.remove(blazeEnchantment.getKey());
			}
			if(byKey.containsKey(striderEnchantment.getKey())) {
				byKey.remove(striderEnchantment.getKey());
			}
			if(byKey.containsKey(witherSkelEnchantment.getKey())) {
				byKey.remove(witherSkelEnchantment.getKey());
			}
			if(byKey.containsKey(witherEnchantment.getKey())) {
				byKey.remove(witherEnchantment.getKey());
			}
			if(byKey.containsKey(enderManEnchantment.getKey())) {
				byKey.remove(enderManEnchantment.getKey());
			}
			if(byKey.containsKey(mooshroomEnchantment.getKey())) {
				byKey.remove(mooshroomEnchantment.getKey());
			}
			if(byKey.containsKey(piglinEnchantment.getKey())) {
				byKey.remove(piglinEnchantment.getKey());
			}
			//New
			if(byKey.containsKey(VillagerEnchantment.getKey())) {
				byKey.remove(VillagerEnchantment.getKey());
			}
			if(byKey.containsKey(huskEnchantment.getKey())) {
				byKey.remove(huskEnchantment.getKey());
			}
			if(byKey.containsKey(ghastEnchantment.getKey())) {
				byKey.remove(ghastEnchantment.getKey());
			}
			if(byKey.containsKey(strayEnchantment.getKey())) {
				byKey.remove(strayEnchantment.getKey());
			}
			if(byKey.containsKey(witchEnchantment.getKey())) {
				byKey.remove(witchEnchantment.getKey());
			}
			if(byKey.containsKey(enderDragonEnchantment.getKey())) {
				byKey.remove(enderDragonEnchantment.getKey());
			}
			
			
			
			
			Field nameField = Enchantment.class.getDeclaredField("byName");
			nameField.setAccessible(true);
			
			HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);
			if(byName.containsKey(zombieEnchantment.getName())) {
				byName.remove(zombieEnchantment.getName());
			}
			if(byName.containsKey(SheepEnchantment.getName())) {
				byName.remove(SheepEnchantment.getName());
			}
			if(byName.containsKey(creeperEnchantment.getName())) {
				byName.remove(creeperEnchantment.getName());
			}
			if(byName.containsKey(skeletonEnchantment.getName())) {
				byName.remove(creeperEnchantment.getName());
			}
			if(byName.containsKey(chickenEnchantment.getName())) {
				byName.remove(chickenEnchantment.getName());
			}
			if(byName.containsKey(fishEnchantment.getName())) {
				byName.remove(fishEnchantment.getName());
			}
			if(byName.containsKey(horseEnchantment.getName())) {
				byName.remove(horseEnchantment.getName());
			}
			if(byName.containsKey(horseEnchantment.getName())) {
				byName.remove(horseEnchantment.getName());
			}
			if(byName.containsKey(snowmanEnchantment.getName())) {
				byName.remove(snowmanEnchantment.getName());
			}
			if(byName.containsKey(wolfEnchantment.getName())) {
				byName.remove(wolfEnchantment.getName());
			}
			if(byName.containsKey(polarbearEnchantment.getName())) {
				byName.remove(polarbearEnchantment.getName());
			}
			if(byName.containsKey(spiderEnchantment.getName())) {
				byName.remove(spiderEnchantment.getName());
			}
			if(byName.containsKey(spiderEnchantment.getName())) {
				byName.remove(spiderEnchantment.getName());
			}
			if(byName.containsKey(dolphinEnchantment.getName())) {
				byName.remove(dolphinEnchantment.getName());
			}
			if(byName.containsKey(blazeEnchantment.getName())) {
				byName.remove(blazeEnchantment.getName());
			}
			if(byName.containsKey(striderEnchantment.getName())) {
				byName.remove(striderEnchantment.getName());
			}
			if(byName.containsKey(witherSkelEnchantment.getName())) {
				byName.remove(witherSkelEnchantment.getName());
			}
			if(byName.containsKey(witherEnchantment.getName())) {
				byName.remove(witherEnchantment.getName());
			}
			if(byName.containsKey(enderManEnchantment.getName())) {
				byName.remove(enderManEnchantment.getName());
			}
			if(byName.containsKey(mooshroomEnchantment.getName())) {
				byName.remove(mooshroomEnchantment.getName());
			}
			if(byName.containsKey(piglinEnchantment.getName())) {
				byName.remove(piglinEnchantment.getName());
			}
			if(byName.containsKey(VillagerEnchantment.getName())) {
				byName.remove(VillagerEnchantment.getName());
			}
			if(byName.containsKey(huskEnchantment.getName())) {
				byName.remove(huskEnchantment.getName());
			}
			if(byName.containsKey(ghastEnchantment.getName())) {
				byName.remove(ghastEnchantment.getName());
			}
			if(byName.containsKey(strayEnchantment.getName())) {
				byName.remove(strayEnchantment.getName());
			}
			if(byName.containsKey(witchEnchantment.getName())) {
				byName.remove(witchEnchantment.getName());
			}
			if(byName.containsKey(enderDragonEnchantment.getName())) {
				byName.remove(enderDragonEnchantment.getName());
			}
			
		} catch (Exception e) {}
	}
	
	private void registerEnchantment(Enchantment enchantment) {
		try {
			Field field = Enchantment.class.getDeclaredField("acceptingNew");
			field.setAccessible(true);
			field.set(null, true);
			Enchantment.registerEnchantment(enchantment);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static main getInstance( ) { return Main;}
		
	
}
