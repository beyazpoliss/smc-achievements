package com.smc.achievements.api.achievements;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

/**
 * The ProgressProfile interface represents the progress profile of an entity or player for tracking achievement progress.
 * It provides methods to retrieve progress for specific achievements based on their names or unique identifiers.
 */
public interface ProgressProfile {

  /**
   * Get the progress of a specific achievement based on its name.
   *
   * @param achievement The achievement for which progress is requested.
   * @return The progress of the specified achievement.
   */
  Progress progress(@NotNull final Achievement achievement);

  /**
   * Get the progress of a specific achievement based on its unique identifier (UUID).
   *
   * @param achievementId The unique identifier of the achievement for which progress is requested.
   * @return The progress of the specified achievement.
   */
  Progress progress(@NotNull final UUID achievementId);
}

