package com.smc.achievements.bukkit.builder;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.api.achievements.Description;
import com.smc.achievements.api.builder.CategoryBuilder;
import com.smc.achievements.bukkit.achievements.CategoryImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CategoryBuilderImpl implements CategoryBuilder {

  private UUID categoryId;
  private String categoryName;
  private String icon;
  private Description categoryDescription;
  private final List<Achievement> achievements = new ArrayList<>();

  @Override
  public CategoryBuilder categoryId(@NotNull final UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  @Override
  public CategoryBuilder categoryId() {
    this.categoryId = UUID.randomUUID();
    return this;
  }

  @Override
  public CategoryBuilder categoryName(@NotNull final String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  @Override
  public CategoryBuilder icon(@NotNull final String icon) {
    this.icon = icon;
    return this;
  }

  @Override
  public CategoryBuilder categoryDescription(@NotNull final Description categoryDescription) {
    this.categoryDescription = categoryDescription;
    return this;
  }

  @Override
  public CategoryBuilder addAchievement(@NotNull final Achievement achievement) {
    this.achievements.add(achievement);
    return this;
  }

  @Override
  public CategoryBuilder addAchievements(@NotNull final Achievement... achievements) {
    this.achievements.addAll(Arrays.asList(achievements));
    return this;
  }

  @Override
  public Category build() {
    Category category = new CategoryImpl(categoryId, categoryName, icon, categoryDescription);
    achievements.forEach(category::addAchievement);
    return category;
  }

  @Override
  public CategoryBuilderImpl clone() {
    try {
      return (CategoryBuilderImpl) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
