package dev4.GetInformation;

import java.util.List;

/**
 * Contains methods for search necessary number words.
 */
class NumberWords {

  /**
   * Search words in list, which length more given length.
   *
   * @param splitWordList - list, contains words.
   * @param wordLength - minimal words length.
   * @return int - number words longest given length
   */
  int searchWordsLongestFiveSymbols(List<String> splitWordList, int wordLength) {
    int symbolLengthCount;
    int symbolCount;
    int wordCount = 0;
    for (String word : splitWordList) {
      symbolLengthCount = 0;
      symbolCount = 0;
      char[] charWord = word.toLowerCase().toCharArray();
      for (char ch : charWord) {
        if ((ch <= 'z') && (ch >= 'a')) {
          symbolLengthCount++;
        } else {
          symbolCount++;
          break;
        }
      }
      if ((symbolLengthCount >= wordLength) && (symbolCount < 2)) {
        wordCount++;
      }
    }
    return wordCount;
  }
}


