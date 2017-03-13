package com.github.zubarevladimir.Format;

import com.github.zubarevladimir.Format.DataContainer.DateFactory;
import java.util.*;

/**
 * Contains formatting methods.
 */
public class FormatData {

  /**
   * Formats date according to given user format.
   *
   * @param userDateFormat user-entered format.
   * @return String - current date and time in given format.
   */
  public String formatDateToUserFormat(String userDateFormat, Calendar date) {
    DateFactory dateFactory = new DateFactory();
    Map<String, String> dateMap = dateFactory.createMapOfPatterns(date);
    List<String> patternList = prioritySort(getLisUserFormatPatterns(userDateFormat));
    userDateFormat = substituteDateAccordingToFormat(patternList, dateMap, userDateFormat);
    return userDateFormat;
  }

  /**
   * Get list, contains patterns, which entered by user.
   *
   * @param userDateFormat user-entered format.
   * @return List - contains patterns, which entered by user.
   */
  private List<String> getLisUserFormatPatterns(String userDateFormat) {
    List<String> patternList = new ArrayList<>();
    for (String pattern : userDateFormat.split("[:]|[/]|[ ]")) {
      patternList.add(pattern);
    }
    return patternList;
  }

  /**
   * Substitute current date according to given user-entered format.
   *
   * @param patternList contains patterns, which entered by user.
   * @param dateMap contains all information about current time and date and linked patterns.
   * @param userDateFormat user-entered format.
   * @return String current date and time in given format.
   */
  private String substituteDateAccordingToFormat(List<String> patternList,
      Map<String, String> dateMap, String userDateFormat) {
    for (String pattern : patternList) {
      if (dateMap.containsKey(pattern)) {
        userDateFormat = userDateFormat.replaceAll(pattern, dateMap.get(pattern));
      }
    }
    return userDateFormat;
  }

  /**
   * Sort given list according to priority substitute.
   *
   * @param patternList contains patterns, which entered by user.
   * @return List - contains entered by user patterns
   */
  private List<String> prioritySort(List<String> patternList) {
    Collections.sort(patternList, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2.codePointBefore(1) - o1.codePointBefore(1)) + (o2.length() - o1.length());
      }
    });
    for (int i = 0; i < patternList.size(); i++) {
      if (patternList.get(i).equals("tt")) {
        patternList.add(0, patternList.remove(i));
      } else if (patternList.get(i).equals("t")) {
        patternList.add(1, patternList.remove(i));
      }
    }
    return patternList;
  }
}