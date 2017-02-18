package dev4.EnterText;

import java.util.Scanner;

/**
 * Contains method for inputting text.
 */
public class EnterText {

  /**
   * Get text in console.
   *
   * @return String - getting text.
   */
  public String enterText() {
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }
}
