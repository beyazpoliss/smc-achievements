package com.smc.achievements.api.manager;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Achievement;
import com.smc.achievements.api.achievements.Progress;
import com.smc.achievements.api.achievements.ProgressProfile;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The ProgressManager interface is responsible for managing and tracking the progress of achievements for players.
 * It provides methods for retrieving progress profiles, forwarding player progress, and obtaining progress information.
 */
public interface ProgressManager {

  /**
   * Get a concurrent map that associates player UUIDs with their progress profiles.
   *
   * @return A ConcurrentHashMap containing player UUIDs and their associated ProgressProfile objects.
   */
  @NotNull
  ConcurrentHashMap<UUID, ProgressProfile> playersAndProfiles();

  /**
   * Forward the progress of a specific achievement for a player.
   *
   * @param player The unique identifier of the player.
   * @param achievement The achievement for which progress is forwarded.
   */
  void forward(@NotNull final UUID player, @NotNull final Achievement achievement);

  /**
   * Get the progress of a specific achievement for a player.
   *
   * @param player The unique identifier of the player.
   * @param achievement The achievement for which progress is requested.
   * @return The progress of the specified achievement for the player.
   */
  Progress progress(@NotNull final UUID player, @NotNull final Achievement achievement);

  /**
   * Obtain an instance of ProgressManager for managing player progress and achievements.
   *
   * @return A ProgressManager instance.
   */
  static ProgressManager manager() {
    return Provider.core().progressManager();
  }
}

