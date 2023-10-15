package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Description;
import com.smc.achievements.api.achievements.Progress;
import com.smc.achievements.api.achievements.Reward;
import com.smc.achievements.api.manager.ProgressManager;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import java.util.*;

@AllArgsConstructor
public class AchievementImpl implements Achievement {
  private String name;
  private UUID id;
  private List<Reward> rewards;
  private Description achievementDescription;
  private int max;
  private String icon;

  @Override
  public String name() {
    return name;
  }

  @Override
  public UUID id() {
    return id;
  }

  @Override
  public Collection<Reward> rewards() {
    return rewards;
  }

  @Override
  public void addRewards(@NotNull final Reward... rewards) {
    this.rewards.addAll(Arrays.asList(rewards));
  }

  @Override
  public Description achievementDescription() {
    return achievementDescription;
  }

  @Override
  public Progress progress(@NotNull UUID player) {
    return ProgressManager.manager().progress(player,this);
  }

  @Override
  public String icon() {
    return icon;
  }

  @Override
  public int max() {
    return max;
  }
}

