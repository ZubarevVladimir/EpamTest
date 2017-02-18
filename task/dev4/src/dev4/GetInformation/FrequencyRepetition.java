package dev4.GetInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains method for counting quantity repeat.
 */
class FrequencyRepetition {

  /**
   * Count quantity repeat pairs of letters.
   *
   * @param splitWordList - list, contains words.
   * @return Map - contains key - pars of letters, value - quantity repeats.
   */
  Map getFrequencyRepetition(List<String> splitWordList) {
    Map<String, Integer> frequencyMap = new HashMap<>();
    for (String word : splitWordList) {
      for (int j = GetInformation.NUMBER_SYMBOLS; j <= word.length(); j++) {
        String keyMap = word.substring(j - GetInformation.NUMBER_SYMBOLS, j).toLowerCase();
        char[] key = keyMap.toCharArray();
        if (areLetters(key)) {
          if (frequencyMap.containsKey(keyMap)) {
            frequencyMap.put(keyMap, frequencyMap.get(keyMap) + 1);
          } else {
            frequencyMap.put(keyMap, 1);
          }
        }
      }
    }
    return frequencyMap;
  }

  private boolean areLetters(char[] key) {
    for (char symbol : key) {
      if (!((symbol <= 'z') && (symbol >= 'a'))) {
        return false;
      }
    }
    return true;
  }
}
