package net.nexia.nexiaessentials.Modules;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatItem implements Listener
{

    public ChatItem(JavaPlugin plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void showItemInChat(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        String message = e.getMessage();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;
        String itemName = itemMeta.getDisplayName().length() == 0 ? item.getType().name() : itemMeta.getDisplayName();

        if (message.contains("[item]"))
        {
            e.setMessage(message.replace("[item]", "[" + itemMeta.getDisplayName() + "]"));
        }
    }

}
