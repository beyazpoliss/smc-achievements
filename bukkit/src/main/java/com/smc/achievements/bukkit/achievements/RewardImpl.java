package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.AchievementPlayer;
import com.smc.achievements.api.achievements.Reward;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public class RewardImpl implements Reward {

  private Consumer<AchievementPlayer> achievementPlayerConsumer;


  @Override
  public Consumer<AchievementPlayer> consumer() {
    return achievementPlayerConsumer;
  }
}
