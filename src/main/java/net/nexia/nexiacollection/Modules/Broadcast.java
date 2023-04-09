package net.nexia.nexiacollection.Modules;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import net.nexia.nexiaapi.Processes;
import net.nexia.nexiacollection.NexiaCollection;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
@CommandAlias("broadcast")
public class Broadcast extends BaseCommand
{

    FileConfiguration config = NexiaCollection.getMain().getConfig();

    public Broadcast(JavaPlugin plugin)
    {
        BukkitCommandManager manager = new BukkitCommandManager(plugin);
        manager.registerCommand(this);
    }

    @Default
    private void invalidUsage(CommandSender sender)
    {
        sender.sendMessage(Processes.color("&cInvalid usage. Use &7/broadcast <bossbar/message/title>&c."));
    }

    /**
     * The Broadcast Message Command
     * Broadcasts a message to all online players.
     * Usage: /broadcast message <message>
     * @param sender The instance that executed the Command.
     * @param args The Command arguments.
     */
    @CommandAlias("message")
    private void broadcastMessage(CommandSender sender, String[] args)
    {
        if (args.length < 1)
        {
            sender.sendMessage(Processes.color("&cInvalid usage. Use &7/broadcast message <message>&c."));
            return;
        }

        Bukkit.broadcastMessage(Processes.color(config.getString("BroadcastMessagePrefix") + args[0]));
    }

    @CommandAlias("title")
    private void broadcastTitle(CommandSender sender, String[] args)
    {
        if (args.length < 3)
        {
            sender.sendMessage(Processes.color("&cInvalid usage. Use &7/broadcast title <title> <subtitle> <duration>&c."));
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.sendTitle(Processes.color(args[0]), Processes.color(args[1]), 1, 1, 1);
        }
    }

}
