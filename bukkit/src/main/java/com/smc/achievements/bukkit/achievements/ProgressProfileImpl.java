package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Progress;
import com.smc.achievements.api.achievements.ProgressProfile;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ProgressProfileImpl implements ProgressProfile {
  //Achievement UUID
  private final Map<UUID, Progress> progressMap = new ConcurrentHashMap<>();

  @Override
  public Progress progress(@NotNull final Achievement achievement) {
    if (progressMap.containsKey(achievement.id())){
      return progressMap.get(achievement.id());
    }
    return this.orCreate(achievement.id());
  }

  @Override
  public Progress progress(@NotNull UUID achievementId) {
    if (progressMap.containsKey(achievementId)){
      return progressMap.get(achievementId);
    }
    return this.orCreate(achievementId);
  }

  public Progress orCreate(@NotNull final UUID uuid){
    final var progress = new ProgressImpl(0,0);
    this.progressMap.put(uuid,progress);
    return progress;
  }
}
