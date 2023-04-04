package net.nexia.nexiaessentials;

import net.nexia.nexiaessentials.Modules.ChatPing;
import org.bukkit.plugin.java.JavaPlugin;

public final class NexiaEssentials extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        //Modules
        new ChatPing(this);

        //Config Access
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

}
