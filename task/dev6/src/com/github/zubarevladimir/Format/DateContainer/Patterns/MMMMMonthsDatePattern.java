package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for months.
 * Gets in range from January - December
 */
public class MMMMMonthsDatePattern extends DatePattern {

  private static final String PATTERN = "MMMM";
  private final Calendar date;

  private enum Months {
    January, February, March, April, May, June, July, August, September, October, November, December
  }

  public MMMMMonthsDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return Months.values()[date.get(Calendar.MONTH)].name();
  }
}
