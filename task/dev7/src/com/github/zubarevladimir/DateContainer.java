package com.github.zubarevladimir;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains date variables.
 */
public class DateContainer {

  private String date;
  private int day;
  private int month;
  private int year;

  /**
   * Get date in given string and set variable date.
   */
  public void setDate(String expression) {
    date = expression.split(" ")[0];
    setDateParametres(date);
  }

  /**
   * Set parametris according to given string date.
   *
   * @param date string contains variablrs in format dd/MM/yyyy order.
   */
  private void setDateParametres(String date) {
    List<Integer> dateList = new ArrayList<>();
    for (String variable : (date.split("[/]+"))) {
      dateList.add(Integer.parseInt(variable));
    }
    setDay(dateList);
    setMonth(dateList);
    setYear(dateList);
  }

  public void setDay(List<Integer> dateList) {
    this.day = dateList.get(0);
  }

  public void setMonth(List<Integer> dateList) {
    this.month = dateList.get(1);
  }

  public void setYear(List<Integer> dateList) {
    this.year = dateList.get(2);
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }
}