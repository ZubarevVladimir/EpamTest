package com.github.zubarevladimir.Format.DateContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains necessary method for work with month.
 */
class Month {

  /**
   * Return full month name according to given short name.
   *
   * @param keyShortName days short name.
   * @return String- days full name.
   */
  String getFullName(String keyShortName) {
    Map<String, String> fullMonthNames = new HashMap<>();
    fullMonthNames.put("Jan", "January");
    fullMonthNames.put("Feb", "February");
    fullMonthNames.put("Mar", "March");
    fullMonthNames.put("Apr", "April");
    fullMonthNames.put("May", "May");
    fullMonthNames.put("Jun", "June");
    fullMonthNames.put("Jul", "July");
    fullMonthNames.put("Aug", "August");
    fullMonthNames.put("Sep", "September");
    fullMonthNames.put("Oct", "October");
    fullMonthNames.put("Nov", "November");
    fullMonthNames.put("Dec", "December");
    return fullMonthNames.get(keyShortName);
  }
}
