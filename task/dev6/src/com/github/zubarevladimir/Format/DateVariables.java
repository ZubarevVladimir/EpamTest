package com.github.zubarevladimir.Format;

import java.util.*;

/**
 * Description class DataVariables.
 */
public class DateVariables {

  /**
   * Description method getDateVariables().
   *
   * @return Map.
   */
  public Map<String, String> getDateVariables() {
    Date date = new Date();
    List<String> splitWordsList = new ArrayList<>();
    for (String word : (date.toString().split("[ :]+"))) {
      if (word.contains("GMT")) {
        splitWordsList.add(word.substring(3, 6));
      } else {
        splitWordsList.add(word);
      }
    }
    Map<String, String> formatDateMap = new HashMap<>();
    Calendar calendar = new GregorianCalendar();
    formatDateMap.put("f", "0");
    formatDateMap.put("F", "");
    formatDateMap.put("d", "" + calendar.get(Calendar.DAY_OF_MONTH));
    formatDateMap.put("dd", splitWordsList.get(2));
    formatDateMap.put("ddd", splitWordsList.get(0));
    formatDateMap.put("dddd", Day.getFullName(splitWordsList.get(0)));
    formatDateMap.put("M", "" + (calendar.get(Calendar.MONTH) + 1));
    formatDateMap.put("MMM", splitWordsList.get(1));
    formatDateMap.put("MMMM", Month.getFullName(splitWordsList.get(1)));
    formatDateMap.put("HH", splitWordsList.get(3));
    formatDateMap.put("mm", splitWordsList.get(4));
    formatDateMap.put("cc", splitWordsList.get(5));
    formatDateMap.put("zz", splitWordsList.get(6));
    formatDateMap.put("zzz", splitWordsList.get(6) + ":" + splitWordsList.get(7));
    formatDateMap.put("K", splitWordsList.get(6) + ":" + splitWordsList.get(7));
    if (Integer.parseInt(splitWordsList.get(4)) < 10) {
      formatDateMap.put("m", splitWordsList.get(4).substring(1, 2));
    } else {
      formatDateMap.put("m", splitWordsList.get(4));
    }
    if (splitWordsList.get(6).charAt(1) == '0') {
      formatDateMap
          .put("z", splitWordsList.get(6).substring(0, 1) + splitWordsList.get(6).substring(2, 3));
    } else {
      formatDateMap.put("z", splitWordsList.get(6));
    }
    if (Integer.parseInt(splitWordsList.get(3)) > 12) {
      formatDateMap.put("hh", "" + (Integer.parseInt(splitWordsList.get(3)) - 12));
      formatDateMap.put("h", "" + (Integer.parseInt(splitWordsList.get(3)) - 12));
      if (Integer.parseInt(splitWordsList.get(3)) - 12 < 10) {
        formatDateMap.put("h", "" + (Integer.parseInt(splitWordsList.get(3)) - 12));
        formatDateMap.put("hh", "0" + (Integer.parseInt(splitWordsList.get(3)) - 12));
      }
    } else {
      formatDateMap.put("hh", splitWordsList.get(3));
      formatDateMap.put("h", splitWordsList.get(3).substring(1, 2));
    }
    if (Integer.parseInt(splitWordsList.get(3)) < 10) {
      formatDateMap.put("H", splitWordsList.get(3).substring(1, 2));
    } else {
      formatDateMap.put("H", splitWordsList.get(3));
    }
    if ((calendar.get(Calendar.MONTH) + 1) < 10) {
      formatDateMap.put("MM", "0" + Calendar.MONTH);
    } else {
      formatDateMap.put("MM", "" + Calendar.MONTH);
    }
    if (splitWordsList.get(5).charAt(0) == '0') {
      formatDateMap.put("s", splitWordsList.get(5).substring(1, 2));
    } else {
      formatDateMap.put("s", splitWordsList.get(5));
    }
    if (Integer.parseInt(splitWordsList.get(3)) < 12) {
      formatDateMap.put("tt", "AM");
      formatDateMap.put("t", "A");
    } else {
      formatDateMap.put("tt", "PM");
      formatDateMap.put("t", "P");
    }
    if (splitWordsList.get(8).substring(2, 4).charAt(0) == '0') {
      formatDateMap.put("y", splitWordsList.get(8).substring(3, 4));
      formatDateMap.put("yy", splitWordsList.get(8).substring(2, 4));
    } else {
      formatDateMap.put("y", splitWordsList.get(8).substring(2, 4));
      formatDateMap.put("yy", splitWordsList.get(8).substring(2, 4));
    }
    if (splitWordsList.get(8).substring(1, 4).charAt(0) == '0') {
      formatDateMap.put("yyy", splitWordsList.get(8).substring(1, 4));
    } else {
      formatDateMap.put("yyy", splitWordsList.get(8));
    }
    formatDateMap.put("yyyy", splitWordsList.get(8));
    formatDateMap.put("yyyyy", "0" + splitWordsList.get(8));

    return formatDateMap;
  }
}
