package com.usainsrht.creeperchestsave.listener;

import com.usainsrht.creeperchestsave.CreeperChestSave;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

public class HangingBreakListener implements Listener {

    CreeperChestSave instance = CreeperChestSave.getInstance();

    @EventHandler
    public void onDamage(HangingBreakEvent e) {

        if (e.getCause() == HangingBreakEvent.RemoveCause.EXPLOSION) {

            boolean canDestroyItemFrame = instance.getConfig().getBoolean("explosion_can_destroy_item_frames", false);

            if (!canDestroyItemFrame) e.setCancelled(true);

        }

    }
}
