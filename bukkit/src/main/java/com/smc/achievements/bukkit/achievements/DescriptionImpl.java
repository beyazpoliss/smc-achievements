package com.smc.achievements.bukkit.achievements;

import com.smc.achievements.api.achievements.Description;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DescriptionImpl implements Description {
  private List<String> longDescription;
  private String shortDescription;
  private String title;

  public DescriptionImpl(@NotNull final String title, @NotNull final String shortDescription, @NotNull final List<String> longDescription) {
    this.title = title;
    this.shortDescription = shortDescription;
    this.longDescription = new ArrayList<>(longDescription);
  }

  @Override
  public List<String> longDescription() {
    return longDescription;
  }

  @Override
  public String shortDescription() {
    return shortDescription;
  }

  @Override
  public String title() {
    return title;
  }

  @Override
  @NotNull
  public Description changeLongDescription(@NotNull final List<String> longDescription) {
    this.longDescription = new ArrayList<>(longDescription);
    return this;
  }

  @Override
  @NotNull
  public Description changeShortDescription(@NotNull final String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  @Override
  @NotNull
  public String changeTitle(@NotNull final String title) {
    this.title = title;
    return title;
  }
}
