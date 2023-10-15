package com.smc.achievements.api.achievements;

import com.smc.achievements.api.Provider;

/**
 * The Progress interface represents the progress of completing an objective or task.
 * It includes the maximum progress value, the current progress value, and methods to update and visualize progress.
 */
public interface Progress {

  /**
   * Get the maximum progress value.
   *
   * @return The maximum progress value.
   */
  int max();

  /**
   * Get the current progress value.
   *
   * @return The current progress value.
   */
  int now();

  /**
   * Increment the current progress value by one.
   */
  void addNow();

  /**
   * Get a progress bar representation of the current progress.
   *
   * @return A string representing the progress bar.
   */
  default String progressBar() {
    return Provider.core().progressBarCreator(now(), max());
  }
}

