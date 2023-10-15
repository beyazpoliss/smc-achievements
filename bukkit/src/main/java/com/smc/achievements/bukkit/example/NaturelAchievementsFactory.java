package com.smc.achievements.bukkit.example;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.api.achievements.Reward;
import com.smc.achievements.api.builder.AchievementBuilder;
import com.smc.achievements.api.builder.CategoryBuilder;
import com.smc.achievements.api.builder.DescriptionBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

public class NaturelAchievementsFactory {

  public NaturelAchievementsFactory(){
    Provider.core().categoryManager().register(this.addCategories());
  }

  public Collection<Category> addCategories(){
    final var mobs = this.createMobKillCategory();
    mobs.addAchievements(this.zombie(),this.creeper());

    return List.of(mobs);
  }

  public Reward emeraldReward(){
    return () -> achievementPlayer -> {
      final var bukkitPlayer = (Player) achievementPlayer.player();
      bukkitPlayer.getInventory().addItem(new ItemStack(Material.EMERALD,3));
    };
  }

  public Reward xpReward(){
    return () -> achievementPlayer -> {
      final var bukkitPlayer = (Player) achievementPlayer.player();
      bukkitPlayer.giveExp(10);
    };
  }

  public Reward diamondReward(){
    return () -> achievementPlayer -> {
      final var bukkitPlayer = (Player) achievementPlayer.player();
      bukkitPlayer.getInventory().addItem(new ItemStack(Material.DIAMOND,3));
    };
  }

  public Achievement creeper(){
    return AchievementBuilder.builder()
      .withName("creeper-kill")
      .withId()
      .withRewards(xpReward(),diamondReward(),emeraldReward())
      .withIcon(Material.CREEPER_HEAD.name())
      .withDescription(DescriptionBuilder.builder()
        .title("&aCreeper Kill Achievement.")
        .shortDescription("&a+.")
        .longDescription(List.of(
          "Mob Kill Achievement Category: %"))
        .build())
      .withMax(10).build();
  }

  public Achievement zombie(){
    return AchievementBuilder.builder()
      .withName("zombie-kill")
      .withId()
      .withRewards(xpReward(),diamondReward(),emeraldReward())
      .withIcon(Material.ZOMBIE_HEAD.name())
      .withDescription(DescriptionBuilder.builder()
        .title("&aZombie Kill Achievement.")
        .shortDescription("&aZombie Kill Achievement.")
        .longDescription(List.of(
          "Zombie Kill Achievement",
          "",
          "&7[%bar%&7]",
          ""))
        .build())
      .withMax(10).build();
  }

  public Category createMobKillCategory(){
    return CategoryBuilder.builder()
      .categoryId()
      .categoryName("mob-kill")
      .icon(Material.ZOMBIE_SPAWN_EGG.toString())
      .categoryDescription(
        DescriptionBuilder.builder()
          .title("&aMob Kill Category.")
          .shortDescription("&aMob kill achievements.")
          .longDescription(List.of(
            "&fThere are %achievements% achievements in this category."))
          .build())
      .build();
  }
}
