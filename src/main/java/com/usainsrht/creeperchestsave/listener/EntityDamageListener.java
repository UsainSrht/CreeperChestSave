package com.usainsrht.creeperchestsave.listener;

import com.usainsrht.creeperchestsave.CreeperChestSave;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    CreeperChestSave instance = CreeperChestSave.getInstance();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {

            boolean canDestroyArmorStand = instance.getConfig().getBoolean("explosion_can_destroy_armor_stands", false);
            boolean canDestroyPet = instance.getConfig().getBoolean("explosion_can_destroy_pets", false);
            boolean canDestroyVillager = instance.getConfig().getBoolean("explosion_can_destroy_villagers", false);


            if (!canDestroyArmorStand && e.getEntityType() == EntityType.ARMOR_STAND) e.setCancelled(true);
            if (!canDestroyVillager && e.getEntityType() == EntityType.VILLAGER) e.setCancelled(true);
            if (!canDestroyPet) {
                if (e.getEntity() instanceof Tameable) {
                    Tameable tameable = (Tameable) e.getEntity();
                    if (tameable.isTamed()) e.setCancelled(true);
                }
            }

        }
    }

}
