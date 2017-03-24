package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a thousandth of a second in a date and time.
 * Gets in range from 000 - 999
 */
public class FFFDatePattern extends DatePattern {

  private static final String PATTERN = "fff";
  private static final String ZERO = "0";
  private final Calendar date;

  public FFFDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    String result = "" + date.get(Calendar.MILLISECOND);
    if (result.equals(ZERO)) {
      String str = ZERO;
      for (int i = 0; i < PATTERN.length() -1; i++) {
        str += ZERO;
      }
      return str;
    } else {
      return result.substring(0, PATTERN.length());
    }
  }
}
