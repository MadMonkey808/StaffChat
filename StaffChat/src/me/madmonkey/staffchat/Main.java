package me.madmonkey.staffchat;

import me.madmonkey.staffchat.staffchat.BuilderChat;
import me.madmonkey.staffchat.staffchat.ManagerChat;
import me.madmonkey.staffchat.staffchat.StaffChat;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        new StaffChat(this);
        loadConfig();
        new ManagerChat(this);
        loadConfig();
        new BuilderChat(this);
        loadConfig();
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveConfig();
    }
}
