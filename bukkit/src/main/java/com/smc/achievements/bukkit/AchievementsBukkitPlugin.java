package com.smc.achievements.bukkit;

import com.smc.achievements.api.Provider;
import com.smc.achievements.bukkit.commands.AchievementCommand;
import com.smc.achievements.bukkit.core.AchievementsBukkitCore;
import com.smc.achievements.bukkit.example.NaturelAchievementsFactory;
import com.smc.achievements.bukkit.listener.ClickListener;
import com.smc.achievements.bukkit.listener.NaturelAchievementsListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class AchievementsBukkitPlugin extends JavaPlugin {

  @Getter
  private AchievementsBukkitCore core;

  @Override
  public void onEnable() {
    this.core = new AchievementsBukkitCore();
    Provider.core(core);
    new NaturelAchievementsFactory();
    getServer().getPluginManager().registerEvents(new ClickListener(),this);
    getServer().getPluginManager().registerEvents(new NaturelAchievementsListener(),this);
    Objects.requireNonNull(this.getCommand("achievements")).setExecutor(new AchievementCommand());
  }

  @Override
  public void onDisable() {
    super.onDisable();
  }

}
