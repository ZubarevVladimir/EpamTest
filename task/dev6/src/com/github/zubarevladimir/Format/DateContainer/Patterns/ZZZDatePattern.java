package com.github.zubarevladimir.Format.DataContainer.Patterns;

import java.util.Calendar;

/**
 * Created by Владимир on 12.03.2017.
 */
public class ZZZDatePattern extends DatePattern {

  private static final String PATTERN = "zzz";
  private final Calendar date;

  public ZZZDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  public String getPattern() {
    return PATTERN;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.getTimeZone().getID().replaceAll("GMT", ""));
  }
}

