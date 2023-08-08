package com.tags.plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class marketCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			try {
     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
     			rs2.next();
     			int money = rs2.getInt("Token");
			}catch (SQLException x) {
     			x.printStackTrace();
			}
			Inventory market = Bukkit.getServer().createInventory(p, 36, "The Market Place");
            ItemStack space = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta spaceM = space.getItemMeta();
            spaceM.setDisplayName(" ");
            space.setItemMeta(spaceM);
            
            ItemStack foodDrop = new ItemStack(Material.CHEST);
            ItemMeta fdmeta = foodDrop.getItemMeta();
            fdmeta.setDisplayName("Supply Crate");
            ArrayList<String> foodDroplore= new ArrayList<String>();
            foodDroplore.add("§BGain an easy full saturation of food and a slight speed boost");
            foodDroplore.add("Costs: 1 Token");
            fdmeta.setLore(foodDroplore);
            foodDrop.setItemMeta(fdmeta);
            
            
            
            ItemStack whatNowBook = new ItemStack(Material.BOOK);
            ItemMeta wNBook = whatNowBook.getItemMeta();
            wNBook.setDisplayName("What Now?");
            ArrayList<String> wnblore= new ArrayList<String>();
            wnblore.add("§BYou've exchanged your first Diamond so what now?");
            wnblore.add("§BThose answers and more in this tip book for beginners");
            wnblore.add("Costs: 1 Token");
            wNBook.setLore(wnblore);
            whatNowBook.setItemMeta(wNBook);
            
            ItemStack moonTravel = new ItemStack(Material.LEGACY_EYE_OF_ENDER);
            ItemMeta mtMeta = moonTravel.getItemMeta();
            mtMeta.setDisplayName("Moon Travel");
            ArrayList<String> mtlore = new ArrayList<String>();
            mtlore.add("§BYou've always wanted to reach for the skys.");
            mtlore.add("§BYou've went to hell and back.");
            mtlore.add("§BNow you could be on a trip to the moon.");
            mtlore.add("Costs: 100 Token");
            mtMeta.setLore(mtlore);
            moonTravel.setItemMeta(mtMeta);
            
            ItemStack nationTravel = new ItemStack(Material.NETHER_STAR);
            ItemMeta ntMeta = nationTravel.getItemMeta();
            ntMeta.setDisplayName("Nation Travel");
            ArrayList<String> ntlore = new ArrayList<String>();
            ntlore.add("§BTravel to any of the nations");
            ntlore.add("Costs: 25 Token");
            ntMeta.setLore(ntlore);
            nationTravel.setItemMeta(ntMeta);
            
            ItemStack Gapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
            ItemMeta GappleMeta = Gapple.getItemMeta();
            ArrayList<String> Gapplelore = new ArrayList<String>();
            Gapplelore.add("§BJust a normal God Apple");
            Gapplelore.add("Costs: 9 Token");
            GappleMeta.setLore(Gapplelore);
            Gapple.setItemMeta(GappleMeta);
            
            ItemStack BalanceShown = new ItemStack(Material.DIAMOND_BLOCK);
            ItemMeta BSMeta = BalanceShown.getItemMeta();
            BSMeta.setDisplayName("Token Balance");
            try {
     			ResultSet rs2 = main.prepareStatement("Select * FROM user WHERE UUID = '" + p.getUniqueId() + "';" ).executeQuery();
     			rs2.next();
     			int money = rs2.getInt("Token");
     			ArrayList<String> BSlore = new ArrayList<String>();
     			BSlore.add("§BYour current balance is " + money);
     			BSMeta.setLore(BSlore);
     			BalanceShown.setItemMeta(BSMeta);
     			market.setItem(35, BalanceShown);
			}catch (SQLException x) {
     			x.printStackTrace();
			}
            
            
            
            
            
            market.setItem(10, whatNowBook);
            market.setItem(11, foodDrop);
            market.setItem(12, moonTravel);
            market.setItem(13, nationTravel);
            market.setItem(14, Gapple);
            market.setItem(0, space);
            market.setItem(1, space);
            market.setItem(2, space);
            market.setItem(3, space);
            market.setItem(4, space);
            market.setItem(5, space);
            market.setItem(6, space);
            market.setItem(7, space);
            market.setItem(8, space);
            market.setItem(9, space);
            market.setItem(17, space);
            market.setItem(18, space);
            market.setItem(26, space);
            market.setItem(27, space);
            market.setItem(28, space);
            market.setItem(29, space);
            market.setItem(30, space);
            market.setItem(31, space);
            market.setItem(32, space);
            market.setItem(33, space);
            market.setItem(34, space);
            
            
            
//            int i;
//            for(i = 0; i == 9; i++) {
//            	market.setItem(i, space);
//            }
            
            p.openInventory(market);
		}
		return false;
	}

}
