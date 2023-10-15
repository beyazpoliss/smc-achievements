package com.smc.achievements.api;

import com.smc.achievements.api.achievements.Achievement;

/**
 * The AchievementPlayer interface represents a player's association with an achievement.
 * It includes the player (or player-related object) and the associated achievement.
 */
public interface AchievementPlayer {

  /**
   * Get the player or player-related object associated with the achievement.
   *
   * @return The player or player-related object.
   */
  Object player();

  /**
   * Get the achievement associated with the player.
   *
   * @return The associated achievement.
   */
  Achievement achievement();
}

