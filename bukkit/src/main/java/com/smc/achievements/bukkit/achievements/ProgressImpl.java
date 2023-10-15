package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.achievements.Progress;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProgressImpl implements Progress {

  private int now,max;

  @Override
  public int max() {
    return max;
  }

  @Override
  public int now() {
    return now;
  }

  @Override
  public void addNow() {
    now++;
  }
}
