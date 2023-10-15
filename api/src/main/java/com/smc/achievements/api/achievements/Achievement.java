package com.smc.achievements.api.achievements;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

/**
 * The Achievement interface represents an in-game achievement.
 * Achievements have a name, a unique identifier, associated rewards,
 * a description, progress tracking, an icon, and a maximum completion count.
 */
public interface Achievement {

  /**
   * Get the name of the achievement.
   *
   * @return The name of the achievement.
   */
  String name();

  /**
   * Get the unique identifier (UUID) of the achievement.
   *
   * @return The unique identifier of the achievement.
   */
  UUID id();

  /**
   * Get the collection of rewards associated with the achievement.
   *
   * @return The collection of rewards.
   */
  Collection<Reward> rewards();

  /**
   * Add one or more rewards to the achievement.
   *
   * @param rewards The rewards to be added.
   */
  void addRewards(@NotNull final Reward... rewards);

  /**
   * Get the description of the achievement.
   *
   * @return The description of the achievement.
   */
  Description achievementDescription();

  /**
   * Get the progress of the achievement for a specific player.
   *
   * @param player The unique identifier of the player.
   * @return The progress of the achievement for the specified player.
   */
  Progress progress(@NotNull final UUID player);

  /**
   * Get the icon associated with the achievement.
   *
   * @return The icon of the achievement.
   */
  String icon();

  /**
   * Get the maximum completion count for the achievement.
   *
   * @return The maximum completion count.
   */
  int max();
}
