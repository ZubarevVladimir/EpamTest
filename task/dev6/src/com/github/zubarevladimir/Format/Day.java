package com.github.zubarevladimir.Format;

import java.util.HashMap;
import java.util.Map;

/**
 * Description class Day.
 */
public final class Day {

  /**
   * Description method getFullName.
   *
   * @param keyShortName
   * @return
   */
 public static String getFullName(String keyShortName){
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
