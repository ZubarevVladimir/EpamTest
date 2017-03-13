package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for era.
 */
public class GDatePattern extends DatePattern {

  private static final String PATTERN = "g";
  private final Calendar date;

  public GDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    if (date.get(date.get(Calendar.ERA)) > 0) {
      return "A";
    } else {
      return "B";
    }
  }
}
