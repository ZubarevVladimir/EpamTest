package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for AM / PM indicator first character.
 * Gets A or P
 */
public class TDatePattern extends DatePattern {

  private static final String PATTERN = "t";
  private final Calendar date;

  private enum AM_PM {
    A, P
  }

  public TDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return AM_PM.values()[date.get(Calendar.AM_PM)].name();
  }
}
