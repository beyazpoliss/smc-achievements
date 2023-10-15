package com.smc.achievements.bukkit.commands;

import com.smc.achievements.api.Provider;
import com.smc.achievements.bukkit.misc.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AchievementCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    if (commandSender instanceof Player player) {
      Inventory menu = Bukkit.createInventory(null, 27, "Achievement Categories.");

      Provider.core().categoryManager().categories().forEach(category -> {
        final var builder = new ItemBuilder(Material.getMaterial(category.categoryIcon()),category.achievements().size());
        final var description = category.categoryDescription();
        builder.setName(description.title());
        final List<String> lore = new ArrayList<>();
        description.longDescription().forEach(line -> lore.add(line.replace("%achievements%",category.achievements().size() + "")));
        builder.setLore(lore);
        menu.addItem(builder.toItemStack());
      });

      player.openInventory(menu);
    }
    return true;
  }
}
