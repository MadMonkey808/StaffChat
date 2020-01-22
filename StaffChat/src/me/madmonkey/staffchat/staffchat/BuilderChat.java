package me.madmonkey.staffchat.staffchat;

import me.madmonkey.staffchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuilderChat implements CommandExecutor {

    public BuilderChat(Main plugin){
        plugin.getCommand("scb").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage( "Only players can execute this commands!");
            return false;
        }
        Player p = (Player) sender;
        if(!(p.hasPermission("mad.scb"))){
            p.sendMessage(Color("&6[B] &cYou do not have permission to execute this command!"));
            return false;
        }

        if(args.length < 1){
            p.sendMessage(Color("&6[B] &cMessage cannot be empty"));
            return false;
        }

        String mess = "&6[B] "+ p.getDisplayName() + "&6: ";
        for(String s : args){
            mess = mess + s + " ";
        }

        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission("mad.scb")){
                player.sendMessage(Color(mess));
            }
        }
        return true;
    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}