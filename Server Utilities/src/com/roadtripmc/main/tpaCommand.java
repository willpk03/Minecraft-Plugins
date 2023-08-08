package com.roadtripmc.main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class tpaCommand implements CommandExecutor {
	String Tag = ChatColor.GOLD + "" + ChatColor.BOLD +"[RoadTripMC] " + ChatColor.GRAY;
    private static HashMap<UUID, UUID> requests = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Tag + "§cYou must be a player.");
            return true;          
        }  
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("tpa")) {
            if (!player.hasPermission("tpa.sent")) {
                player.sendMessage(Tag + "§cYou aren't allowed to do this.");
                return true;
            }
            if (args.length != 1) {
                player.sendMessage(Tag + "§7Usage: /tpa <player>");
                return true;          
            }
            //}
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                requests.put(target.getUniqueId(), player.getUniqueId());
                player.sendMessage(Tag + "§7You sent a teleport request to " + target.getName() + ".");
                target.sendMessage(Tag + "§7" + player.getName() + " sent a teleport request to you.");  
                return true;
            }
            player.sendMessage(Tag + "§cThe player is offline.");                                      
        }
        if (command.getName().equalsIgnoreCase("tpaccept")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(Tag + "§7You accepted the teleport request.");
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(Tag + "§7" +  player.getName() + " accepted the teleport request.");
                Bukkit.getPlayer(requests.get(player.getUniqueId())).teleport(player);
                requests.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage(Tag + "§cThere's no request to accept.");
        }
        if (command.getName().equalsIgnoreCase("tpdeny")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(Tag + "§7You denied the teleport request.");
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(Tag + "§7" +  player.getName() + " denied the teleport request.");
                requests.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage(Tag + "§cThere's no request to deny.");
        }      
        return false;
    }  
}
