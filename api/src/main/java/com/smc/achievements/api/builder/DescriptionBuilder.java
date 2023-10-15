package com.smc.achievements.api.builder;

import com.smc.achievements.api.Provider;
import com.smc.achievements.api.achievements.Description;

import java.util.List;

/**
 * The {@code DescriptionBuilder} interface defines methods for building a {@link Description} object with customizable
 * properties including a title, short description, and long description.
 */
public interface DescriptionBuilder extends Cloneable {
  /**
   * Set the title for the description.
   *
   * @param title The title of the description.
   * @return This {@code DescriptionBuilder} instance for method chaining.
   */
  DescriptionBuilder title(String title);

  /**
   * Set the short description for the description.
   *
   * @param shortDescription The short description of the description.
   * @return This {@code DescriptionBuilder} instance for method chaining.
   */
  DescriptionBuilder shortDescription(String shortDescription);

  /**
   * Set the long description for the description.
   *
   * @param longDescription The long description of the description as a list of strings.
   * @return This {@code DescriptionBuilder} instance for method chaining.
   */
  DescriptionBuilder longDescription(List<String> longDescription);

  /**
   * Build and return a {@link Description} object with the specified properties.
   *
   * @return A {@link Description} object with the specified properties.
   */
  Description build();

  /**
   * @return A {@link DescriptionBuilder} instance.
   */
  static DescriptionBuilder builder() {
    return Provider.core().descriptionBuilder();
  }
}