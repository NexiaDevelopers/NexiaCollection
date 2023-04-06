package net.nexia.nexiacollection.Modules;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.nexia.nexiaapi.Processes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

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
            TextComponent itemMessage = new TextComponent("[" + itemName +"]");
            List<String> lore = itemMeta.getLore();
            int loreSize = lore == null ? 0 : lore.size();

            Content[] hoverEventComponents = new Content[loreSize + 2];
            hoverEventComponents[0] = new Text(itemName + "\n");

            for (int i = 1; i < hoverEventComponents.length; i++)
                hoverEventComponents[i] = new Text("");

            if (itemMeta.getLore() != null)
            {
                for (int i = 0; i < loreSize; i++)
                    hoverEventComponents[i + 1] = new Text(lore.get(i) + "\n");
            }

            itemMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverEventComponents));

            e.setCancelled(true);
            for (Player p : Bukkit.getOnlinePlayers())
                p.spigot().sendMessage(itemMessage);
        }
    }

}
