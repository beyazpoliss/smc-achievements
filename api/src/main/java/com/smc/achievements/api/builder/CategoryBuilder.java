package com.smc.achievements.api.builder;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Category;
import com.smc.achievements.api.achievements.Description;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * The {@code CategoryBuilder} interface defines methods for building a {@link Category} object
 * with customizable properties.
 */
public interface CategoryBuilder extends Cloneable {
  /**
   * Set the unique identifier for the category.
   *
   * @param categoryId The unique identifier for the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder categoryId(@NotNull final UUID categoryId);

  /**
   * Set the random unique identifier for the category.
   *
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder categoryId();

  /**
   * Set the name of the category.
   *
   * @param categoryName The name of the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder categoryName(@NotNull final String categoryName);

  /**
   * Set the icon path for the category.
   *
   * @param icon The path to the icon representing the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder icon(@NotNull final String icon);

  /**
   * Set the description for the category.
   *
   * @param categoryDescription The description for the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder categoryDescription(@NotNull final Description categoryDescription);

  /**
   * Add an achievement to the category.
   *
   * @param achievement The achievement to add to the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder addAchievement(@NotNull final Achievement achievement);

  /**
   * Add achievements to the category.
   *
   * @param achievements The achievements to add to the category.
   * @return This {@code CategoryBuilder} instance for method chaining.
   */
  CategoryBuilder addAchievements(@NotNull final Achievement... achievements);

  /**
   * Build and return a {@link Category} object with the specified properties.
   *
   * @return A {@link Category} object with the specified properties.
   */
  Category build();

  /**
   * @return A {@link CategoryBuilder} instance.
   */
  static CategoryBuilder builder() {
    return Provider.core().categoryBuilder();
  }
}
