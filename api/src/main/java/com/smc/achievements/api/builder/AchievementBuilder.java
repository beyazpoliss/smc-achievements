package com.smc.achievements.api.builder;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Description;
import com.smc.achievements.api.achievements.Reward;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * The AchievementBuilder interface is responsible for creating and configuring new achievement instances.
 * It provides methods for setting various properties of an achievement, such as its name, unique identifier, icon, rewards,
 * description, maximum completion count, and for building the final achievement object.
 */
public interface AchievementBuilder extends Cloneable {

  /**
   * Set the name of the achievement.
   *
   * @param name The name of the achievement.
   * @return The AchievementBuilder with the updated name.
   */
  AchievementBuilder withName(String name);

  /**
   * Generate a unique identifier for the achievement.
   *
   * @return The AchievementBuilder with the generated unique identifier.
   */
  AchievementBuilder withId();

  /**
   * Set the unique identifier of the achievement.
   *
   * @param id The unique identifier of the achievement.
   * @return The AchievementBuilder with the updated unique identifier.
   */
  AchievementBuilder withId(UUID id);

  /**
   * Set the icon for the achievement.
   *
   * @param icon The icon representing the achievement.
   * @return The AchievementBuilder with the updated icon.
   */
  AchievementBuilder withIcon(@NotNull final String icon);

  /**
   * Set the rewards associated with the achievement.
   *
   * @param rewards The rewards to be associated with the achievement.
   * @return The AchievementBuilder with the updated rewards.
   */
  AchievementBuilder withRewards(Reward... rewards);

  /**
   * Set the description for the achievement.
   *
   * @param description The description of the achievement.
   * @return The AchievementBuilder with the updated description.
   */
  AchievementBuilder withDescription(Description description);

  /**
   * Set the maximum completion count for the achievement.
   *
   * @param max The maximum completion count.
   * @return The AchievementBuilder with the updated maximum completion count.
   */
  AchievementBuilder withMax(int max);

  /**
   * Build the final achievement object with the configured properties.
   *
   * @return The built Achievement object.
   */
  Achievement build();

  /**
   * Create a new instance of AchievementBuilder using a default builder implementation.
   *
   * @return A new AchievementBuilder instance.
   */
  static AchievementBuilder builder() {
    return Provider.core().achievementBuilder();
  }
}

