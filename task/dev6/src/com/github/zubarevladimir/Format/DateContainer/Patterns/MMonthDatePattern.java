package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for months.
 * Gets in range from 1 - 12
 */
public class MMonthDatePattern extends DatePattern {

  private static final String PATTERN = "M";
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public MMonthDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.MONTH) + 1);
  }
}
