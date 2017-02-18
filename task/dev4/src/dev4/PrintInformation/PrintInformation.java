package dev4.PrintInformation;

import dev4.GetInformation.GetInformation;

import java.util.List;
import java.util.Map;

/**
 * Contains methods for printing information according to given parameter.
 */
public class PrintInformation {

  /**
   * Print necessary information about given list.
   *
   * @param splitWordList - list, contains words.
   */
  public void printInformation(List<String> splitWordList) {
    printNumberWordsMore(splitWordList);
    printFrequencyRepetition(splitWordList);
  }

  /**
   * Print frequency repetition given list.
   *
   * @param splitWordList - list, contains words.
   */
  private void printFrequencyRepetition(List<String> splitWordList) {
    GetInformation getter = new GetInformation();
    for (Map.Entry<String, Integer> entry : getter.getFrequencyInformation(splitWordList)
        .entrySet()) {
      System.out
          .println(
              "Frequancy for pair of letters: " + entry.getKey() + " -> "
                  + entry.getValue() / (getter
                  .getTotalNumber(splitWordList)));
    }
  }

  /**
   * Print number words, which length more then 5.
   *
   * @param splitWordList - list, contains words.
   */
  private void printNumberWordsMore(List<String> splitWordList) {
    GetInformation geter = new GetInformation();
    System.out.println("Quantity words, which length more then " + geter.WORD_LENGTH + ": " + geter
        .getNumberWords(splitWordList));
  }
}
