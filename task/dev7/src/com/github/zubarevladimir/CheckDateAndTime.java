package com.github.zubarevladimir;

/**
 * Created by Владимир on 28.02.2017.
 */
public class CheckDateAndTime {

  public boolean checkDateAndTime(String expression) {
    Validator validator = new Validator();
    DateAndTime dateAndTime = new DateAndTime();
    if (validator.checkDate(expression) && validator.checkTime(expression)) {
      dateAndTime.setDateAndTime(expression);
    } else {
      return false;
    }
    int day = dateAndTime.getDateList().get(0);
    int month = dateAndTime.getDateList().get(1);
    int year = dateAndTime.getDateList().get(2);
    if (!validator.checkFebruary(day, month, year) || !validator.isValidDayOfMonth(day, month)) {
      return false;
    }
    return true;
  }
}