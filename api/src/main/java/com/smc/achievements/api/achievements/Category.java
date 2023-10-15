package com.smc.achievements.api.achievements;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * The Category interface represents a collection of related achievements.
 * Categories have a name, a unique identifier, an icon, a description, and a list of associated achievements.
 */
public interface Category {

  /**
   * Add one or more achievements to the category.
   *
   * @param achievements The achievements to be added to the category.
   */
  void addAchievements(@NotNull final Achievement... achievements);

  /**
   * Add a single achievement to the category.
   *
   * @param achievement The achievement to be added to the category.
   */
  void addAchievement(@NotNull final Achievement achievement);

  /**
   * Get a collection of achievements associated with the category.
   *
   * @return The collection of achievements in the category.
   */
  @NotNull
  Collection<Achievement> achievements();

  /**
   * Get an achievement by its name.
   *
   * @param achievementName The name of the achievement.
   * @return An optional containing the achievement, if found.
   */
  Optional<Achievement> get(@NotNull final String achievementName);

  /**
   * Get an achievement by its unique identifier.
   *
   * @param achievementId The unique identifier of the achievement.
   * @return An optional containing the achievement, if found.
   */
  Optional<Achievement> get(@NotNull final UUID achievementId);

  /**
   * Get the name of the category.
   *
   * @return The name of the category.
   */
  @NotNull
  String name();

  /**
   * Get the unique identifier (UUID) of the category.
   *
   * @return The unique identifier of the category.
   */
  @NotNull
  UUID categoryId();

  /**
   * Get the icon associated with the category.
   *
   * @return The icon of the category.
   */
  @NotNull
  String categoryIcon();

  /**
   * Get the description of the category.
   *
   * @return The description of the category.
   */
  @NotNull
  Description categoryDescription();
}
