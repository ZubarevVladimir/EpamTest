package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a hundredths of a second in a date and time.
 * Gets in range from 01 - 99. If equals 00 or less returns empty string
 */
public class FFNotZeroDatePattern extends DatePattern {

  private static final String PATTERN = "FF";
  private static final int TEN_TO_GET_HUNDREDS = 100;
  private static final String EMPTY = "";
  private static final String ZERO = "0";
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public FFNotZeroDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    String result = "" + date.get(Calendar.MILLISECOND);
    if (result.equals("0")) {
      return "";
    } else {
      return result.substring(0, PATTERN.length());
    }
  }
}
