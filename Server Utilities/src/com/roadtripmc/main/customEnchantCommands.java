package com.roadtripmc.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class customEnchantCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ItemStack space = new ItemStack(Material.BOOK);
		List<String> lore2= new ArrayList<String>();
		
        lore2.add("§CNot Discorvered - Right click the book in your hand to echant.");
        
        ItemMeta spaceM = space.getItemMeta();
        spaceM.setDisplayName("§BMagic Book");
        spaceM.setLore(lore2);
        space.setItemMeta(spaceM);
        
        Player p = (Player) sender;
        if(args[0].equalsIgnoreCase("giveBook")) {
        	if (main.getFileManager().gettag(p).gettagName().equalsIgnoreCase("admin")) {
        		p.getInventory().addItem(space);
        	}
        } else if (args[0].equalsIgnoreCase("openBook")) {
        	ArrayList<String> rare= new ArrayList<String>();
    		rare.add("RARE");
    		
    		
    		ItemStack heldItem = p.getInventory().getItemInMainHand();
    		List<String> heldLore = heldItem.getItemMeta().getLore();
    		if (heldLore.equals(lore2)) {
    			Inventory CE = Bukkit.getServer().createInventory(p, 36, "CustomEnchant");
    			p.openInventory(CE);
    		} else {
    			p.sendMessage("wrong Book oops");
    			System.out.print(heldLore);
    			System.out.print(lore2);
    		}
        }
		
		
		return false;
	}

}
