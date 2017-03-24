package com.github.zubarevladimir;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains method for initialize map according to string.
 */
public class IniMapInitializer {

  /**
   * Initialize map according to string made of .ini file.
   *
   * @param text string made of .ini file.
   * @return Map - contains key(section) and value(Map - key(key) and value(value)) according to
   * given string.
   */
  public Map<String, Map<String, String>> iniMap(String text) {
    final String COMMENT_SYMBOL = "#";
    final String SYMBOL_SEPARATOR_KEY_VALUE = "=";
    final String SECTION_SYMBOL = "[";
    Map<String, Map<String, String>> sectionMap = new HashMap<>();
    String section = "";
    for (String line : text.split("([\n])")) {
      if (line.length() != 0 && !line.contains(COMMENT_SYMBOL)) {
        if (line.contains(SECTION_SYMBOL)) {
          section = getSection(line);
          Map<String, String> keyMap = new HashMap<>();
          sectionMap.put(section, keyMap);
        } else if (line.contains(SYMBOL_SEPARATOR_KEY_VALUE)) {
          sectionMap.get(section).put(line.split("=")[0], line.split("=")[1]);
        }
      }
    }
    return sectionMap;
  }

  /**
   * Get section from given string.
   *
   * @param line string, contains section
   * @return String - section contains only section.
   */
  private String getSection(String line) {
    String section;
    section = line.replaceFirst("(\\[)", "");
    section = section.replaceFirst("(\\])", "");
    section = section.replaceAll("[\\s]*$", "");
    return section;
  }
}