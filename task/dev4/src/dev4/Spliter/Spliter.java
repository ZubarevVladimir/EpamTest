package dev4.Spliter;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains method for splitting string.
 */
public class Spliter {

  /**
   * Splits string into words on spaces.
   *
   * @param text - string for splitting.
   * @return List - list, contains words without spaces.
   */
  public List splitStringIntoWords(String text) {
    List<String> splitWordsList = new ArrayList<>();
    for (String word : (text.split("[\\s,.!?:;'\"]+"))) {
      if (word.length() != 0) {
        splitWordsList.add(word.replaceAll("[\\W\\d_]+", ""));
      }
    }
    return splitWordsList;
  }
}