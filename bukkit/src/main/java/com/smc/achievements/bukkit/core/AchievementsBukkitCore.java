package com.smc.achievements.bukkit.core;

import com.google.common.base.Strings;
import com.smc.achievements.api.AchievementsCore;
import com.smc.achievements.api.builder.AchievementBuilder;
import com.smc.achievements.api.builder.CategoryBuilder;
import com.smc.achievements.api.builder.DescriptionBuilder;
import com.smc.achievements.api.manager.CategoryManager;
import com.smc.achievements.api.manager.ProgressManager;
import com.smc.achievements.bukkit.builder.AchievementBuilderImpl;
import com.smc.achievements.bukkit.builder.CategoryBuilderImpl;
import com.smc.achievements.bukkit.builder.DescriptionBuilderImpl;
import com.smc.achievements.bukkit.manager.CategoryManagerImpl;
import com.smc.achievements.bukkit.manager.ProgressManagerImpl;
import lombok.Setter;
import org.bukkit.ChatColor;

@Setter
public class AchievementsBukkitCore implements AchievementsCore {

  private CategoryBuilderImpl categoryBuilder;
  private DescriptionBuilderImpl descriptionBuilder;
  private AchievementBuilderImpl achievementBuilder;
  private CategoryManager categoryManager;
  private ProgressManager progressManager;

  public AchievementsBukkitCore(){
    this.categoryBuilder = new CategoryBuilderImpl();
    this.descriptionBuilder = new DescriptionBuilderImpl();
    this.categoryManager = new CategoryManagerImpl();
    this.progressManager = new ProgressManagerImpl();
    this.achievementBuilder = new AchievementBuilderImpl();
  }

  @Override
  public CategoryBuilder categoryBuilder() {
    return categoryBuilder.clone();
  }

  @Override
  public DescriptionBuilder descriptionBuilder() {
    return descriptionBuilder.clone();
  }

  @Override
  public AchievementBuilder achievementBuilder() {
    return achievementBuilder.clone();
  }

  @Override
  public CategoryManager categoryManager() {
    return categoryManager;
  }

  @Override
  public ProgressManager progressManager() {
    return progressManager;
  }

  @Override
  public String progressBarCreator(int current, int max) {
    return getProgressBar(20, 100, 40, '|', ChatColor.GREEN, ChatColor.GRAY);
  }

  public String getProgressBar(int current, int max, int totalBars, char symbol, ChatColor completedColor,
                               ChatColor notCompletedColor) {
    float percent = (float) current / max;
    int progressBars = (int) (totalBars * percent);

    return Strings.repeat("" + completedColor + symbol, progressBars)
      + Strings.repeat("" + notCompletedColor + symbol, totalBars - progressBars);
  }
}
