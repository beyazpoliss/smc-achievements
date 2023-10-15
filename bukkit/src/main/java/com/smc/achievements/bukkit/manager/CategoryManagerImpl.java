package com.smc.achievements.bukkit.manager;

import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.api.manager.CategoryManager;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CategoryManagerImpl implements CategoryManager {
  private final Map<String, Category> categoryMap = new ConcurrentHashMap<>();

  @Override
  public Collection<Category> categories() {
    return categoryMap.values();
  }

  @Override
  @NotNull
  public Optional<Category> get(@NotNull UUID categoryId) {
    for (Category category : categoryMap.values()) {
      if (category.categoryId().equals(categoryId)) {
        return Optional.of(category);
      }
    }
    return Optional.empty();
  }

  @Override
  @NotNull
  public Optional<Category> get(@NotNull String categoryName) {
    return Optional.ofNullable(categoryMap.get(categoryName));
  }

  @Override
  public void remove(@NotNull UUID categoryId) {
    for (Category category : categoryMap.values()) {
      if (category.categoryId().equals(categoryId)) {
        categoryMap.remove(category.name());
        return;
      }
    }
  }

  @Override
  public void remove(@NotNull String categoryName) {
    categoryMap.remove(categoryName);
  }

  @Override
  public void register(@NotNull Category... categories) {
    for (Category category : categories) {
      categoryMap.put(category.name(), category);
    }
  }

  @Override
  public void register(@NotNull Collection<Category> categories) {
    categories.forEach(category -> categoryMap.put(category.name(), category));
  }

  @Override
  public void register(@NotNull Category category) {
    categoryMap.put(category.name(), category);
  }
}
