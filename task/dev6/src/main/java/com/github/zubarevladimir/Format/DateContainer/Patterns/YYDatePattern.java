package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for years.
 * Gets in range from 00 - 99
 */
public class YYDatePattern extends DatePattern {

  private static final String PATTERN = "yy";
  private static final int HUNDRED = 100;
  private static final int LESS_THAN_TEN = 10;
  private static final String ZERO = "0";
  private final Calendar date;

  public YYDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.YEAR) % HUNDRED;
    return String.valueOf(result < LESS_THAN_TEN ?
        ZERO + result : result);
  }
}
