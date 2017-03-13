package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for years.
 * Gets in range from 000
 */
public class YYYDatePattern extends DatePattern {

  private static final String PATTERN = "yyy";
  private static final String ZERO = "0";
  private static final int NUMBER_SYMBOLS = 3;
  private final Calendar date;

  public YYYDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    String result = "" + date.get(Calendar.YEAR);
    if (result.substring(result.length() - NUMBER_SYMBOLS, result.length()).charAt(0) == '0') {
      return ZERO + result.substring(result.length() - (NUMBER_SYMBOLS - 1), result.length());
    } else {
      return result.substring(result.length() - NUMBER_SYMBOLS, result.length());
    }
  }
}
