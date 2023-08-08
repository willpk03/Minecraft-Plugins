package com.roadtripmc.main;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FileManager {
	
	private File file;
	private File homefile;
	private File ranktagfile;
	private YamlConfiguration config;
	private YamlConfiguration homeconfig;
	private YamlConfiguration tagconfig;
	
	//UUID: rank
	
	public FileManager(main main) {
		
		file = new File(main.getDataFolder(), "data.yml");
		homefile = new File(main.getDataFolder(), "home.yml");
		ranktagfile = new File(main.getDataFolder(), "ranktag.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if (!homefile.exists()) {
			try {
				homefile.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (!ranktagfile.exists()) {
			try {
				ranktagfile.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		homeconfig = YamlConfiguration.loadConfiguration(homefile);
		config = YamlConfiguration.loadConfiguration(file);
		tagconfig = YamlConfiguration.loadConfiguration(ranktagfile);
		
	}
	
	public void setRank(Player player, Rank rank)  {
		config.set(player.getUniqueId().toString(), rank.name());
		save();
	}
	
	public void setRank(UUID uuid, Rank rank) {
		config.set(uuid.toString(), rank.name());
		save();
	}
	
	public Rank getRank(Player player) {
		return Rank.valueOf(config.getString(player.getUniqueId().toString()));
	}
	
	private void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void setHome(Player p) {
		UUID uuid = p.getUniqueId();
		homeconfig.set(uuid.toString(), p.getUniqueId().toString());
		homeconfig.set(uuid + ".world", p.getLocation().getWorld().getName());
		homeconfig.set(uuid + ".x", p.getLocation().getX());
		homeconfig.set(uuid + ".y", p.getLocation().getY());
		homeconfig.set(uuid + ".z", p.getLocation().getZ());
		homeconfig.set(uuid + ".pitch", p.getEyeLocation().getPitch());
		homeconfig.set(uuid + ".yaw", p.getEyeLocation().getYaw());
		homesave();
		
		
	}
	
	public void getHome(Player p) {
		String uuid = p.getUniqueId().toString();
		World w = Bukkit.getServer().getWorld(homeconfig.getString("uuid.world"));
		double x = homeconfig.getDouble(uuid + ".x");
		double y = homeconfig.getDouble(uuid + ".y");
		double z = homeconfig.getDouble(uuid + ".z");
		double yaw = homeconfig.getDouble(uuid + ".yaw");
		double pitch = homeconfig.getDouble(uuid + ".pitch");
		
		p.teleport(new Location(w, x, y, z, (float)yaw, (float)pitch));
		
	}
	
//	public boolean checkHome(Player p) {
//		if(homeconfig.get)
//		return false;
//		
//	}
	
	private void homesave() {
		try {
			homeconfig.save(homefile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void setTag(Player player,ranktags  ranktags)  {
		tagconfig.set(player.getUniqueId().toString(), ranktags.name());
		 tagsave();
	}
	
	public void setTag(UUID uuid, ranktags  ranktags) {
		tagconfig.set(uuid.toString(), ranktags.name());
		 tagsave();
	}
	public ranktags gettag(Player player) {
		return ranktags.valueOf(tagconfig.getString(player.getUniqueId().toString()));
	}
	
	private void tagsave() {
		try {
			tagconfig.save(ranktagfile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
