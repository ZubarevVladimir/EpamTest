package com.github.zubarevladimir;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Contains method for search value.
 */
public class Searcher {

  private final String MESSAGE_NOT_FOUND_SECTION = "Not found section: ";
  private final String MESSAGE_NOT_FOUND_KEY = "Not found key: ";

  /**
   * Search value(values) in given map by section and key.
   *
   * @param searchMap contains texts sections, keys and values.
   * @param section contains searched section's value.
   * @param key contains searched key's value.
   * @return List - contains found value(values).
   */
  public List<String> searchValue(Map<String, Map<String, String>> searchMap, String section,
      String key) throws NoSuchElementException {
    List<String> valueList = new ArrayList<>();
    int sectionCount = 0;
    for (Map.Entry<String, Map<String, String>> entry : searchMap.entrySet()) {
      if (entry.getKey().equals(section)) {
        valueList = searchValueByKey(entry, key);
      } else {
        sectionCount++;
        if (sectionCount == searchMap.size()) {
          throw new NoSuchElementException(MESSAGE_NOT_FOUND_SECTION + section);
        }
      }
    }
    return valueList;
  }

  /**
   * Search value(values) in given section by key.
   *
   * @param entry map,contains key(keys) and value(values).
   * @param key contains searched key's value.
   * @return List - contains found value(values).
   */
  private List<String> searchValueByKey(Map.Entry<String, Map<String, String>> entry,
      String key) {
    int keyCount = 0;
    List<String> valueList = new ArrayList<>();
    for (Map.Entry<String, String> entryTwo : entry.getValue().entrySet()) {
      if (entryTwo.getKey().equals(key)) {
        for (String s : entryTwo.getValue().split("[,]")) {
          valueList.add(s.replaceAll("^[\\s]*", ""));
        }
      } else {
        keyCount++;
        if (keyCount == entry.getValue().size()) {
          throw new NoSuchElementException(MESSAGE_NOT_FOUND_KEY + key);
        }
      }
    }
    return valueList;
  }
}

