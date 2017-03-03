package com.github.zubarevladimir;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains methods for check validation parameters.
 */
public class Validator {

  private final int[] MONTH_WITH_30_DAY = {2, 4, 6, 9, 11};
  private final int FEBRUARY = 2;
  private final int DAYS_IN_FEBRUARY_NORMAL = 28;
  private final int DAYS_IN_FEBRUARY_LEAP_YEAR = 29;
  private final int MAX_DAY_IN_MONTH = 31;

  /**
   * Check format given expression.
   *
   * @param expression date and time in any format.
   * @return boolean - true, if satisfy format, false if no.
   */
  public boolean checkDateAndTimeFormat(String expression) {
    Pattern all = Pattern.compile(
        "^(0[1-9]|[12][0-9]|3[01])[/]([0][1-9]|[1][0-2])[/][0-9]{1,4}[ ]([0-1][0-9]|[2][0-4])[:]([0-5][0-9])[:]([0-5][0-9])$");
    Matcher m = all.matcher(expression);
    return m.matches();
  }

  /**
   * Check days in month with 30 days.
   *
   * @param day value means number of days.
   * @param month value means month.
   * @return boolean - true, if given day in given month exist, false if no
   */
  public boolean isValidDayOfMonth(int day, int month) {
    for (int arrayMonth : MONTH_WITH_30_DAY) {
      if (month == arrayMonth) {
        if (day < MAX_DAY_IN_MONTH) {
          return true;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Check Februarys days in normal year and leap year.
   *
   * @param day value means number of days.
   * @param month value means number of month.
   * @param year value means number of years.
   * @return boolean true if given February day exist, false if no.
   */
  public boolean checkFebruaryDays(int day, int month, int year) {
    if (month == FEBRUARY) {
      if (day <= DAYS_IN_FEBRUARY_NORMAL) {
        return true;
      } else if (checkFebruaryDaysLeapYear(day, year)) {
        return true;
      } else {
        return false;
      }
    } else if (!(month == FEBRUARY)) {
      return true;
    }
    return false;
  }

  /**
   * Check number of days in leap year.
   *
   * @param day value means number of days.
   * @param year value means year.
   * @return boolean - true if normak, false if no.
   */
  private boolean checkFebruaryDaysLeapYear(int day, int year) {
    if (isLeapYear(year)) {
      if (day <= DAYS_IN_FEBRUARY_LEAP_YEAR) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check given year is leap year.
   *
   * @param year value means year.
   * @return boolean - trueif given year is keap year, false, if no.
   */
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