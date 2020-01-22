package me.madmonkey.staffchat.staffchat;

import me.madmonkey.staffchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ManagerChat implements CommandExecutor {

    public ManagerChat(Main plugin){
        plugin.getCommand("scm").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage( "Only players can execute this commands!");
            return false;
        }
        Player p = (Player) sender;
        if(!(p.hasPermission("mad.scm"))){
            p.sendMessage(Color("&4[M] &cYou do not have permission to execute this command!"));
            return false;
        }

        if(args.length < 1){
            p.sendMessage(Color("&4[M] &cMessage cannot be empty"));
            return false;
        }

        String mess = "&4[M] "+ p.getDisplayName() + "&c: ";
        for(String s : args){
            mess = mess + s + " ";
        }

        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission("mad.scm")){
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
