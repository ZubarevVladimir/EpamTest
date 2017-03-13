package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for day of week.
 * Gets days in range from Monday - Sunday
 */
public class DDDDDayOfWeekDatePattern extends DatePattern {

  private static final String PATTERN = "DDDD";
  private final Calendar date;

  private enum DaysOfWeek {
    No, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
  }

  public DDDDDayOfWeekDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return DaysOfWeek.values()[date.get(Calendar.DAY_OF_WEEK) + 1].toString();
  }
}
