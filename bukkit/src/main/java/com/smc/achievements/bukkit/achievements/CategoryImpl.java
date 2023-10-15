package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.api.achievements.Description;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CategoryImpl implements Category {

  private final List<Achievement> achievements;
  private final String categoryName;
  private final UUID categoryUUID;
  private final String icon;
  private final Description categoryDescription;

  public CategoryImpl(@NotNull final UUID categoryId,@NotNull final String name,@NotNull final String icon, Description description) {
    this.achievements = new ArrayList<>();
    this.categoryUUID = categoryId;
    this.categoryName = name;
    this.icon = icon;
    this.categoryDescription = description;
  }

  @Override
  public void addAchievements(@NotNull Achievement... achievements) {
    this.achievements.addAll(Arrays.asList(achievements));
  }

  @Override
  public void addAchievement(@NotNull final Achievement achievement) {
    this.achievements.add(achievement);
  }

  @Override
  @NotNull
  public Collection<Achievement> achievements() {
    return achievements;
  }

  @Override
  public Optional<Achievement> get(@NotNull String achievementName) {
    return achievements.stream()
      .filter(achievement -> achievement.name().equals(achievementName))
      .findFirst();
  }

  @Override
  public Optional<Achievement> get(@NotNull UUID achievementId) {
    return achievements.stream()
      .filter(achievement -> achievement.id().equals(achievementId))
      .findFirst();
  }

  @Override
  @NotNull
  public String name() {
    return categoryName;
  }

  @Override
  @NotNull
  public UUID categoryId() {
    return categoryUUID;
  }

  @Override
  @NotNull
  public String categoryIcon() {
    return icon;
  }

  @Override
  @NotNull
  public Description categoryDescription() {
    return categoryDescription;
  }
}
