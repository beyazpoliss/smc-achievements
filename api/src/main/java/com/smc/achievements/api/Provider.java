package com.smc.achievements.api;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
/**
 * @author BeyazPolis
 */
@UtilityClass
public class Provider {
  /**
   * the core instance.
   */
  @Nullable
  private AchievementsCore core;
  /**
   * obtains the core.
   *
   * @return core.
   */
  @NotNull
  public AchievementsCore core() {
    return Objects.requireNonNull(Provider.core, "The core not set yet!");
  }
  /**
   * sets the instance.
   *
   * @param core the instance to set.
   * @throws IllegalStateException if the core is already set.
   */
  public void core(@NotNull final AchievementsCore core) {
    Preconditions.checkState(
      Provider.core == null,
      "The core has been set already!",
      Provider.core
    );
    Provider.core = core;
  }
}
