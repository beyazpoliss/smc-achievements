package com.smc.achievements.api.achievements;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The Description interface represents a textual description of an object, such as an achievement or a category.
 * It includes a long description, a short description, and a title.
 */
public interface Description {

  /**
   * Get the long description of the object.
   *
   * @return The long description as a list of strings.
   */
  List<String> longDescription();

  /**
   * Get the short description of the object.
   *
   * @return The short description as a string.
   */
  String shortDescription();

  /**
   * Get the title of the object.
   *
   * @return The title as a string.
   */
  String title();

  /**
   * Change the long description of the object.
   *
   * @param longDescription The new long description as a list of strings.
   * @return The updated Description object with the new long description.
   */
  @NotNull
  Description changeLongDescription(@NotNull final List<String> longDescription);

  /**
   * Change the short description of the object.
   *
   * @param shortDescription The new short description as a string.
   * @return The updated Description object with the new short description.
   */
  @NotNull
  Description changeShortDescription(@NotNull final String shortDescription);

  /**
   * Change the title of the object.
   *
   * @param title The new title as a string.
   * @return The updated title as a string.
   */
  @NotNull
  String changeTitle(@NotNull final String title);
}

