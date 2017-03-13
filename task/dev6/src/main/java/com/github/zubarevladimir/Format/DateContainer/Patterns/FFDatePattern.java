package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a hundredths of a second in a date and time.
 * Gets in range from 00 - 99
 */
public class FFDatePattern extends DatePattern {

  private static final String PATTERN = "ff";
  private static final String ZERO = "0";
  private final Calendar date;

  public FFDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    String result = "" + date.get(Calendar.MILLISECOND);
    String str = ZERO;
    if (result.equals(ZERO)) {
      for (int i = 0; i < PATTERN.length() -1; i++) {
        str += ZERO;
      }
      return str;
    } else {
      return result.substring(0, PATTERN.length());
    }
  }
}
