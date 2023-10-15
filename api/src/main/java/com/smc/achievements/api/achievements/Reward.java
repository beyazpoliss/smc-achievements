package com.smc.achievements.api.achievements;

import com.smc.achievements.api.AchievementPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * The Reward interface represents a reward associated with an achievement that can be redeemed.
 * Rewards are typically actions or benefits given to players upon achieving an objective.
 */
public interface Reward {

  /**
   * Get the consumer function that specifies the action to be taken when the reward is redeemed.
   *
   * @return The consumer function associated with the reward.
   */
  Consumer<AchievementPlayer> consumer();

  /**
   * Redeem the reward for a specific player.
   *
   * @param player The player for whom the reward is to be redeemed.
   */
  default void redeem(@NotNull final AchievementPlayer player) {
    consumer().accept(player);
  }
}

