package com.smc.achievements.api.manager;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Category;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * The CategoryManager interface is responsible for managing and maintaining a collection of categories.
 * Categories represent a grouping of related achievements and have unique identifiers and names.
 */
public interface CategoryManager {

  /**
   * Get a collection of all registered categories.
   *
   * @return A collection of Category objects.
   */
  Collection<Category> categories();

  /**
   * Get a category by its unique identifier.
   *
   * @param categoryId The unique identifier of the category.
   * @return An optional containing the category, if found.
   */
  @NotNull
  Optional<Category> get(@NotNull final UUID categoryId);

  /**
   * Get a category by its name.
   *
   * @param categoryName The name of the category.
   * @return An optional containing the category, if found.
   */
  @NotNull
  Optional<Category> get(@NotNull final String categoryName);

  /**
   * Remove a category by its unique identifier.
   *
   * @param categoryId The unique identifier of the category to be removed.
   */
  void remove(@NotNull final UUID categoryId);

  /**
   * Remove a category by its name.
   *
   * @param categoryName The name of the category to be removed.
   */
  void remove(@NotNull final String categoryName);

  /**
   * Register one or more categories.
   *
   * @param categories The categories to be registered.
   */
  void register(@NotNull final Category... categories);

  /**
   * Register a collection of categories.
   *
   * @param categories The collection of categories to be registered.
   */
  void register(@NotNull Collection<Category> categories);

  /**
   * Register a single category.
   *
   * @param category The category to be registered.
   */
  void register(@NotNull final Category category);

  /**
   * Obtain an instance of CategoryManager for managing categories.
   *
   * @return A CategoryManager instance.
   */
  static CategoryManager manage() {
    return Provider.core().categoryManager();
  }
}

