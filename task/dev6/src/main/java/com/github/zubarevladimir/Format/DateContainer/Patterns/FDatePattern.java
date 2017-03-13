package com.github.zubarevladimir.Format.DataContainer.Patterns;

import com.sun.deploy.util.StringUtils;
import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a tenths of a second in a date and time.
 * Gets in range from 0 - 9
 */
public class FDatePattern extends DatePattern {

  private static final String PATTERN = "f";
  private static final String ZERO = "0";
  private final Calendar date;

  public FDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }


  @Override
  public String getResult() {
    String result = "" + date.get(Calendar.MILLISECOND);
    if (result.equals(ZERO)) {
      return "0";
    } else {
      return result.substring(0, PATTERN.length());
    }
  }
}
