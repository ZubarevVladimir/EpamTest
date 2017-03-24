package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 1 - 12
 */
public class HDatePattern extends DatePattern {

  private static final String PATTERN = "h";
  private final Calendar date;

  public HDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.HOUR);
    return String.valueOf(result);
  }
}
