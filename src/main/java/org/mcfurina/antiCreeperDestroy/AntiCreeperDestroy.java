package org.mcfurina.antiCreeperDestroy;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCreeperDestroy extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("§a苦力怕防破坏插件已启用！");
    }

    @Override
    public void onDisable() {
        getLogger().info("§c苦力怕防破坏插件已禁用");
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        // 禁止苦力怕爆炸破坏方块
        if (event.getEntityType() == EntityType.CREEPER) {
            event.blockList().clear();
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // 禁止苦力怕爆炸破坏掉落物
        if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            if (event.getEntityType() == EntityType.ITEM) {
                event.setCancelled(true);
            }
        }
    }
}