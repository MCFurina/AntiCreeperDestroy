package org.mcfurina.antiCreeperDestroy;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
        // 检查是否是苦力怕爆炸
        if (event.getEntityType() == EntityType.CREEPER) {
            // 清除受影响的方块列表（防止方块被破坏）
            event.blockList().clear();

            /*
             * 注意：此处不需要额外生成爆炸效果
             * 因为清除方块列表后，爆炸的声音/粒子/伤害效果仍会自动保留
             * 游戏引擎会正常处理这些视觉效果和实体伤害
             */
        }
    }
}
