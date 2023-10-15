package com.smc.achievements.bukkit.listener;

import com.smc.achievements.api.manager.CategoryManager;
import com.smc.achievements.api.manager.ProgressManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

public class NaturelAchievementsListener implements Listener {

  @EventHandler
  public void onKill(@NotNull final EntityDeathEvent event){
    if (event.getEntity().getKiller() == null) return;
    final var manager = CategoryManager.manage();
    final var optional = manager.get("mob-kill");
    final var player = event.getEntity().getKiller();
    optional.ifPresent(category -> {
      final var optionalAchievement = category.get("zombie-kill");
      optionalAchievement.ifPresent(achievement -> ProgressManager.manager().forward(player.getUniqueId(),achievement));
    });
  }
}
