package com.github.zubarevladimir;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владимир on 28.02.2017.
 */
public class Validator {

  private final int[] MONTH_WITH_30_DAY = {2, 4, 6, 9, 11};
  private final int MONTH_FEBRUARY = 2;
  private final int DAYS_IN_FEBRUARY_NORMAL = 28;
  private final int DAYS_IN_FEBRUARY_LEAP_YEAR = 29;



  public boolean checkDate(String expression) {
    Pattern date = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[/]([0][1-9]|[1][0-2])[/][0-9]{1,4}");
    Matcher m = date.matcher(expression);
    return m.find();
  }

  public boolean checkTime(String expression) {
    Pattern time = Pattern.compile("([0-1][0-9]|[2][0-4])[:]([0-5][0-9])[:]([0-5][0-9])$");
    Matcher m = time.matcher(expression);
    return m.find();
  }

  public boolean isValidDayOfMonth(int day, int month) {
    for (int arrayMonth : MONTH_WITH_30_DAY) {
      if (month == arrayMonth) {
        if (day <= 30) {
          return true;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public boolean checkFebruary(int day, int month, int year) {
    if (month == MONTH_FEBRUARY) {
      if (day <= DAYS_IN_FEBRUARY_NORMAL) {
        return true;
      } else if (checkFebruaryLeapYear(day, year)) {
        return true;
      } else {
        return false;
      }
    } else if (!(month == MONTH_FEBRUARY)) {
      return true;
    }
    return false;
  }

  private boolean checkFebruaryLeapYear(int day, int year) {
    if (isLeapYear(year)) {
      if (day <= DAYS_IN_FEBRUARY_LEAP_YEAR) {
        return true;
      }
    }
    return false;
  }

  private boolean isLeapYear(int year) {
    if (year % 4 == 0) {
      if (year % 100 != 0) {
        return true;
      } else if ((year % 100 == 0) && (year % 400 == 0)) {
        return true;
      }
    }
    return false;
  }
}
