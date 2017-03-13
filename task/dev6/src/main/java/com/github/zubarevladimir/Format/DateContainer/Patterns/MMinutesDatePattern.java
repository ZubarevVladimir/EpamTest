package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for minutes.
 * Gets in range from 0 - 59
 */
public class MMinutesDatePattern extends DatePattern {

  private static final String PATTERN = "m";
  private final Calendar date;

  public MMinutesDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.MINUTE));
  }
}
