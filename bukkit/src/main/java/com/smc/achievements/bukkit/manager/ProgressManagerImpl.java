package com.smc.achievements.bukkit.manager;

import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Progress;
import com.smc.achievements.api.achievements.ProgressProfile;
import com.smc.achievements.api.manager.ProgressManager;
import com.smc.achievements.bukkit.achievements.AchievementPlayerImpl;
import com.smc.achievements.bukkit.achievements.ProgressProfileImpl;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ProgressManagerImpl implements ProgressManager {

  private final ConcurrentHashMap<UUID,ProgressProfile> profiles = new ConcurrentHashMap<>();

  @Override
  public @NotNull ConcurrentHashMap<UUID, ProgressProfile> playersAndProfiles() {
    return profiles;
  }

  @Override
  public void forward(@NotNull final UUID player, @NotNull final Achievement achievement) {
    final var profile = this.getOrCreateProfile(player);

    final var progress = profile.progress(achievement);
    progress.addNow();
    if (progress.now() >= achievement.max()){
      achievement.rewards().forEach(reward -> {
        final var bukkitPlayer = Bukkit.getPlayer(player);
        if (bukkitPlayer == null) return;
        if (!bukkitPlayer.isOnline()) return;
        reward.redeem(AchievementPlayerImpl.of(bukkitPlayer,achievement));
      });
    }
  }

  @Override
  public Progress progress(@NotNull final UUID player, @NotNull final Achievement achievement) {
    final var profile = this.getOrCreateProfile(player);

    return profile.progress(achievement);
  }

  @NotNull
  public ProgressProfile getOrCreateProfile(@NotNull final UUID uuid){
    if (profiles.containsKey(uuid)){
      return profiles.get(uuid);
    }
    final var progress = new ProgressProfileImpl();
    profiles.put(uuid,progress);
    return progress;
  }
}
