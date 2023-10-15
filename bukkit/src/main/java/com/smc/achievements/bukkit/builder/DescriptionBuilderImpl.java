package com.smc.achievements.bukkit.builder;

import com.smc.achievements.api.achievements.Description;
import com.smc.achievements.api.builder.DescriptionBuilder;
import com.smc.achievements.bukkit.achievements.DescriptionImpl;

import java.util.List;

public class DescriptionBuilderImpl implements DescriptionBuilder, Cloneable {
  private String title;
  private String shortDescription;
  private List<String> longDescription;

  @Override
  public DescriptionBuilder title(String title) {
    this.title = title;
    return this;
  }

  @Override
  public DescriptionBuilder shortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  @Override
  public DescriptionBuilder longDescription(List<String> longDescription) {
    this.longDescription = longDescription;
    return this;
  }

  @Override
  public Description build() {
    return new DescriptionImpl(title, shortDescription, longDescription);
  }

  @Override
  public DescriptionBuilderImpl clone() {
    try {
      return (DescriptionBuilderImpl) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}