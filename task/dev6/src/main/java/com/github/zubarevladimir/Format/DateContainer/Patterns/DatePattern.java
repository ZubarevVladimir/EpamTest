package com.github.zubarevladimir.Format.DataContainer.Patterns;

/**
 * Represent an abstract date format pattern.
 */
public abstract class DatePattern {

  private final String pattern;

  public DatePattern(String PATTERN) {
    this.pattern = PATTERN;
  }

  public String getPattern() {
    return pattern;
  }

  /**
   * Returns result of the pattern.
   *
   * @return String - result
   */
  public abstract String getResult();
}

