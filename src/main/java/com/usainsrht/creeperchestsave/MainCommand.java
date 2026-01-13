package com.usainsrht.creeperchestsave;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MainCommand extends Command {

    public MainCommand(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        if (sender.hasPermission("creeperchestsave.command"))
        {
            if (args.length == 0) {
                sender.sendMessage("/creeperchestsave reload");
            }
            else if (args[0].equalsIgnoreCase("reload")) {
                CreeperChestSave.getInstance().reloadConfig();

                sender.sendMessage(ChatColor.GREEN+"config reloaded succesfully");
            }
            else {
                sender.sendMessage("/creeperchestsave reload");
            }
        }
        return true;
    }

}
