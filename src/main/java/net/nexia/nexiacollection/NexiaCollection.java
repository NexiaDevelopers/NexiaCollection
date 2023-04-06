package net.nexia.nexiacollection;

import net.nexia.nexiacollection.Modules.ChatItem;
import net.nexia.nexiacollection.Modules.ChatPing;
import org.bukkit.plugin.java.JavaPlugin;

public final class NexiaCollection extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        //Modules
        new ChatItem(this);
        new ChatPing(this);

        //Config Access
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

}
