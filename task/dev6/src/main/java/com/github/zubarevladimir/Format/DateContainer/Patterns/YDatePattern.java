package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for years.
 * Gets in range from 0 - 99
 */
public class YDatePattern extends DatePattern {

  private static final String PATTERN = "y";
  private static final int HUNDRED = 100;
  private final Calendar date;

  public YDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.YEAR) % HUNDRED);
  }
}
