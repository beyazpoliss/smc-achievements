package com.smc.achievements.api;

import com.smc.achievements.api.builder.AchievementBuilder;
import com.smc.achievements.api.builder.CategoryBuilder;
import com.smc.achievements.api.builder.DescriptionBuilder;
import com.smc.achievements.api.manager.CategoryManager;
import com.smc.achievements.api.manager.ProgressManager;

/**
 * The AchievementsCore interface serves as the core component of an achievement system, providing access to various builders
 * and managers for creating and managing categories, achievements, descriptions, and player progress.
 */
public interface AchievementsCore {

  /**
   * Get a builder for creating categories.
   *
   * @return A CategoryBuilder instance.
   */
  CategoryBuilder categoryBuilder();

  /**
   * Get a builder for creating descriptions for achievements and categories.
   *
   * @return A DescriptionBuilder instance.
   */
  DescriptionBuilder descriptionBuilder();

  /**
   * Get a manager for managing categories and associated achievements.
   *
   * @return A CategoryManager instance.
   */
  CategoryManager categoryManager();

  /**
   * Get a manager for tracking player progress and achievements.
   *
   * @return A ProgressManager instance.
   */
  ProgressManager progressManager();

  /**
   * Get a builder for creating achievements.
   *
   * @return An AchievementBuilder instance.
   */
  AchievementBuilder achievementBuilder();

  /**
   * Create a progress bar representation for tracking progress.
   *
   * @param current The current progress value.
   * @param max The maximum progress value.
   * @return A string representing the progress bar.
   */
  String progressBarCreator(int current, int max);
}

