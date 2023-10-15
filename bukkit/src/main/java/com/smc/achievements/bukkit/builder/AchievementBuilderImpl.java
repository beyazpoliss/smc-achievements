package com.smc.achievements.bukkit.builder;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Description;
import com.smc.achievements.api.achievements.Reward;
import com.smc.achievements.api.builder.AchievementBuilder;
import com.smc.achievements.bukkit.achievements.AchievementImpl;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AchievementBuilderImpl implements AchievementBuilder {

  private String name;
  private UUID id;
  private final List<Reward> rewards = new ArrayList<>();
  private Description achievementDescription;
  private int max;
  private String icon;

  public AchievementBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public AchievementBuilder withId(UUID id) {
    this.id = id;
    return this;
  }

  @Override
  public AchievementBuilder withId() {
    this.id = UUID.randomUUID();
    return this;
  }

  @Override
  public AchievementBuilder withIcon(@NotNull final String icon) {
    this.icon = icon;
    return this;
  }

  public AchievementBuilder withRewards(Reward... rewards) {
    this.rewards.addAll(Arrays.asList(rewards));
    return this;
  }

  public AchievementBuilder withDescription(Description description) {
    this.achievementDescription = description;
    return this;
  }

  public AchievementBuilder withMax(int max) {
    this.max = max;
    return this;
  }

  public Achievement build() {
    return new AchievementImpl(name,id,rewards,achievementDescription,max,icon);
  }

  @Override
  public AchievementBuilder clone() {
    try {
      return (AchievementBuilder) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}