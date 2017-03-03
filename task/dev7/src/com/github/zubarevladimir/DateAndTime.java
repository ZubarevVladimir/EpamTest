package com.github.zubarevladimir;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владимир on 28.02.2017.
 */
public class DateAndTime {

  private String date;
  private String time;
  private List<Integer> dateList = new ArrayList<>();
  private List<Integer> timeList = new ArrayList<>();


  public List<Integer> getDateList() {
    return dateList;
  }

  public List<Integer> getTimeList() {
    return timeList;
  }

  public void setDateAndTime(String expression){
    date = expression.split(" ")[0];
    time = expression.split(" ")[1];
    setDateList(date);
    setTimeList(time);
  }

  private void setDateList(String date) {
    for (String variable : (date.split("[/]+"))) {
      dateList.add(Integer.parseInt(variable));
    }
  }

  private void setTimeList(String time) {
    for (String variable : (time.split("[:]+"))) {
      timeList.add(Integer.parseInt(variable));
    }
  }
}
