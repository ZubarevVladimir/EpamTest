package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for era.
 */
public class GGDatePattern extends DatePattern {

  private static final String PATTERN = "gg";
  private final Calendar date;

  public GGDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    if (date.get(Calendar.ERA) > 0) {
      return "AD";
    } else {
      return "BD";
    }
  }
}
