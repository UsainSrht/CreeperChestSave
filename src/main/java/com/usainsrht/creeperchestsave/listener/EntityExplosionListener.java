package com.usainsrht.creeperchestsave.listener;

import com.usainsrht.creeperchestsave.CreeperChestSave;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplosionListener implements Listener {

    CreeperChestSave instance = CreeperChestSave.getInstance();

    @EventHandler(ignoreCancelled = true)
    public void onEntityExplode(EntityExplodeEvent e) {
        boolean canDestroyChest = instance.getConfig().getBoolean("explosion_can_destroy_chests", false);
        boolean canDestroyBlock = instance.getConfig().getBoolean("explosion_can_destroy_blocks", true);
        e.blockList().removeIf(block -> {
            if (!canDestroyChest && block.getState() instanceof Container) return true;
            return !canDestroyBlock;
        });

    }

}
