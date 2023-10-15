package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.AchievementPlayer;
import com.smc.achievements.api.achievements.Achievement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@NotNull
@Getter
@Setter
@AllArgsConstructor
public class AchievementPlayerImpl implements AchievementPlayer {

  private final Player player;
  private final Achievement achievement;

  @Override
  public Object player() {
    return player;
  }

  public Player getPlayer() {
    return player;
  }

  @Override
  public Achievement achievement() {
    return achievement;
  }

  public static AchievementPlayer of(@NotNull final Player player, @NotNull final Achievement achievement){
    return new AchievementPlayerImpl(player,achievement);
  }
}
