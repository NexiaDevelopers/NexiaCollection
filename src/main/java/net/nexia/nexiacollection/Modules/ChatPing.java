package net.nexia.nexiacollection.Modules;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

/**
 * Plays a sound to a Player when they are mentioned in chat.
 */
public class ChatPing implements Listener
{

    public ChatPing(JavaPlugin plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void pingPlayer(AsyncPlayerChatEvent e)
    {
        String message = e.getMessage();

        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player player : players)
        {
            String name = player.getName();
            Player currentPlayer = Bukkit.getPlayer(name);
            if (currentPlayer == null) continue;

            if (message.contains(name))
                currentPlayer.playSound(currentPlayer, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0f, 0.5f);
        }

    }

}
