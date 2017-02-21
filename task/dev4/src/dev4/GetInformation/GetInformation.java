package dev4.GetInformation;

import java.util.List;
import java.util.Map;

/**
 * Contains methods for getting necessary information.
 */
public class GetInformation {

  public static final int NUMBER_SYMBOLS = 2;
  public final int WORD_LENGTH = 5;

  /**
   * Get number words, which is longer WORD_LENGTH.
   *
   * @param splitWordsList - list, contains words.
   * @return int - number words longest WORD_LENGTH.
   */
  public int getNumberWords(List<String> splitWordsList) {
    NumberWords number = new NumberWords();
    int numberWords;
    numberWords = number
        .searchWordsLongestFiveSymbols(splitWordsList, WORD_LENGTH);
    return numberWords;
  }

  /**
   * Get frequency information for given list.
   *
   * @param splitWordsList - list, contains words.
   * @return Map - contains key - pars of letters, value - quantity repeats.
   */
  public Map<String, Integer> getFrequencyInformation(List<String> splitWordsList) {
    FrequencyRepetition frequencyRepetition = new FrequencyRepetition();
    Map<String, Integer> frequencyMap;
    frequencyMap = frequencyRepetition.getFrequencyRepetition(splitWordsList);
    return frequencyMap;
  }

  /**
   * Get total number pairs of letters.
   *
   * @param splitWordsList - list, contains words.
   * @return double - total number pairs of letters.
   */
  public double getTotalNumber(List<String> splitWordsList) {
    double totalLength = 0;
    for (String word : splitWordsList) {
      totalLength += ((word.length()) + 1) - GetInformation.NUMBER_SYMBOLS;
    }
    return totalLength;
  }
}
