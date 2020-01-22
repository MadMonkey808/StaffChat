package me.madmonkey.staffchat.staffchat;

import me.madmonkey.staffchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {

    public StaffChat(Main plugin){
        plugin.getCommand("sc").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage( "Only players can execute this commands!");
            return false;
        }
        Player p = (Player) sender;
        if(!(p.hasPermission("mad.sc"))){
            p.sendMessage(Color("&3[S] &cYou do not have permission to execute this command!"));
            return false;
        }

        if(args.length < 1){
            p.sendMessage(Color("&3[S] &cMessage cannot be empty"));
            return false;
        }

        String mess = "&b[S] "+ p.getDisplayName() + "&b: ";
        for(String s : args){
            mess = mess + s + " ";
        }

        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission("mad.sc")){
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
