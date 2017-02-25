package com.github.zubarevladimir.Format.DateContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains necessary method for work with days name.
 */
class Day {

  /**
   * Return full day name according to given short name.
   *
   * @param keyShortName days short name.
   * @return days full name.
   */
 String getFullName(String keyShortName){
   Map<String, String> fullDaysNames = new HashMap<>();
   fullDaysNames.put("Mon", "Monday");
   fullDaysNames.put("Tue", "Tuesday");
   fullDaysNames.put("Wed", "Wednesday");
   fullDaysNames.put("Thu", "Thursday");
   fullDaysNames.put("Fri", "Friday");
   fullDaysNames.put("Sat", "Saturday");
   fullDaysNames.put("Sun", "Sunday");
   return fullDaysNames.get(keyShortName);
 }
}