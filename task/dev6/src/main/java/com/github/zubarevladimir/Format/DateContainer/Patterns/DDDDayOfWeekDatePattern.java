package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for day of week. Gets days in range from Mon - Sun
 */
public class DDDDayOfWeekDatePattern extends DatePattern {

  private static final String PATTERN = "DDD";
  private final Calendar date;

  private enum DaysOfWeek {
    No, SUN, MON, TUE, WED, THU, FRI, SAT
  }

  public DDDDayOfWeekDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return DaysOfWeek.values()[date.get(Calendar.DAY_OF_WEEK) + 1].toString();
  }
}
