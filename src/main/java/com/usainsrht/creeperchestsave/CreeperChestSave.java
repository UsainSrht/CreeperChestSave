package com.usainsrht.creeperchestsave;

import com.usainsrht.creeperchestsave.listener.BlockExplosionListener;
import com.usainsrht.creeperchestsave.listener.EntityDamageListener;
import com.usainsrht.creeperchestsave.listener.EntityExplosionListener;
import com.usainsrht.creeperchestsave.listener.HangingBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class CreeperChestSave extends JavaPlugin {

    public static CreeperChestSave instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new EntityExplosionListener(), this);
        getServer().getPluginManager().registerEvents(new BlockExplosionListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new HangingBreakListener(), this);

        registerCommand(
                new MainCommand(
                        "creeperchestsave", "main command for reloading creeperchestsave plugin.", "/creeperchestsave reload", Arrays.asList("ccs")
                )
        );

    }

    @Override
    public void onDisable() {

    }

    private void registerCommand(Command cmd) {
        CommandMap commandMap = null;
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        commandMap.register(cmd.getName(), cmd);
    }

    public static CreeperChestSave getInstance() {
        return instance;
    }

    public static boolean isTargetInterface(Object object, String className) {
        try {
            Class<?> targetClass = Class.forName(className);
            return targetClass.isInstance(object);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
