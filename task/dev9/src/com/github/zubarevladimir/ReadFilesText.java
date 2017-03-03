package com.github.zubarevladimir;

import java.io.FileReader;
import java.io.IOException;

/**
 * Contains methods for read text in file.
 */
public class ReadFilesText {

  private final int MIN_NUMBER_SYMBOLS = 0;

  /**
   * Read given file.
   *
   * @param arg file name.
   * @return String - text, contained in file.
   * @throws IOException if given file not found.
   */
  public String readFileToString(String arg) throws IOException {
    String text = "";
    int variable;
    try (FileReader reader = new FileReader(arg)) {
      while ((variable = reader.read()) != -1) {
        text += (char) variable;
      }
      checkNumberSymbols(text);
    } catch (IOException ex) {
      throw new IOException(ex.getMessage());
    }
    return text;
  }

  /**
   * Check number symbols in given string.
   *
   * @param text string contains files text.
   * @throws IOException if given strng not contain necessary number symbols.
   */
  private void checkNumberSymbols(String text) throws IOException {
    final String EXCEPTION_MESSAGE = "Too small text";
    if (text.replaceAll("[\\w]]", "").length() <= MIN_NUMBER_SYMBOLS) {
      throw new IOException(EXCEPTION_MESSAGE);
    }
  }
}
