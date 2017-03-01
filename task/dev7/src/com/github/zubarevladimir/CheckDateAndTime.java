package com.github.zubarevladimir;

/**
 * Contains method for check date and time.
 */
public class CheckDateAndTime {

  /**
   * Check format and validation given date and time.
   *
   * @param expression string date and time.
   * @return boolean - true, if format and validation is coorect, false if no.
   */
  public boolean checkDateAndTime(String expression) {
    Validator validator = new Validator();
    DateContainer dateAndTime = new DateContainer();
    if (validator.checkDateAndTimeFormat(expression)) {
      dateAndTime.setDate(expression);
    } else {
      return false;
    }
    int day = dateAndTime.getDay();
    int month = dateAndTime.getMonth();
    int year = dateAndTime.getYear();
    if (!validator.checkFebruaryDays(day, month, year) || !validator.isValidDayOfMonth(day, month)) {
      return false;
    }
    return true;
  }
}