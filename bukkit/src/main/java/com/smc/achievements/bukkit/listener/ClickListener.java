package com.smc.achievements.bukkit.listener;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.bukkit.misc.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ClickListener implements Listener {

  @EventHandler
  public void onClick(@NotNull final InventoryClickEvent event){
    final var guiName = "Achievement Categories.";
    if (event.getClickedInventory() == null) return;
    if (!event.getView().getTitle().equalsIgnoreCase(guiName)) return;

    event.setCancelled(true);
    final var player = (Player) event.getWhoClicked();

    final var clickedSlot = event.getRawSlot();
    final var material = event.getClickedInventory().getItem(clickedSlot);

    if (material == null) return;

    Provider.core().categoryManager().categories().forEach(category -> {
      final var icon = category.categoryIcon();
      if (material.getType().name().equalsIgnoreCase(icon)){
        this.openCategory(player,category);
        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
      }
    });
  }

  public void openCategory(@NotNull final Player player, @NotNull final Category category){
    Inventory menu = Bukkit.createInventory(null, 27, category.categoryDescription().title());
    category.achievements().forEach(achievement -> {
      final var builder = new ItemBuilder(Material.getMaterial(achievement.icon()));
      final var description = achievement.achievementDescription();
      builder.setName(description.title());
      final List<String> lore = new ArrayList<>();
      final var progress = achievement.progress(player.getUniqueId());
      description.longDescription().forEach(line -> lore.add(line.replace("%bar%",progress.progressBar())));
      builder.setLore(lore);
      menu.addItem(builder.toItemStack());
    });
    player.openInventory(menu);
  }

}
