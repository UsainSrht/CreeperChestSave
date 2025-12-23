package com.usainsrht.creeperchestsave.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplosionListener implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        e.getEntityType()
    }

}
