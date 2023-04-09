package net.nexia.nexiacollection;

import net.nexia.nexiacollection.Modules.Broadcast;
import net.nexia.nexiacollection.Modules.ChatItem;
import net.nexia.nexiacollection.Modules.ChatPing;
import org.bukkit.plugin.java.JavaPlugin;

public final class NexiaCollection extends JavaPlugin
{

    //Main Instance
    private static NexiaCollection nexiaCollection;

    @Override
    public void onEnable()
    {
        //Main Instance
        nexiaCollection = this;

        //Modules
        new Broadcast(this);
        new ChatItem(this);
        new ChatPing(this);

        //Config Access
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    //Main Instance
    public static NexiaCollection getMain() { return nexiaCollection; }
}
