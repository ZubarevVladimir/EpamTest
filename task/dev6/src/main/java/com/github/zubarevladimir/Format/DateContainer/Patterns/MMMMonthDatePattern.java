package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for months.
 * Gets in range from Jan - Dec
 */
public class MMMMonthDatePattern extends DatePattern {

  private static final String PATTERN = "MMM";
  private final Calendar date;

  private enum Months {
    Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
  }

  public MMMMonthDatePattern(Calendar date) {
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
