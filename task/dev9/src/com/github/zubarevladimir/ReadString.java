package com.github.zubarevladimir;

import java.util.Scanner;

/**
 * Contains method for read string in console.
 */
public class ReadString {

  /**
   * Read not empty string in console.
   *
   * @return String read string
   * @throws IllegalArgumentException if number incorrect inputs more then necessary number.
   */
  public String readString() throws IllegalArgumentException {
    final int MAX_INPUT_ATTEMPTS = 5;
    final String MESSAGE_REQUEST_REPEAT_INPUT = "Please, input line: ";
    final String MESSAGE_INCORRECT_USERS_INPUTS = "Incorrect user's inputs: ";
    Scanner in = new Scanner(System.in);
    String line = "";
    int attempt = 1;
    while (attempt <= MAX_INPUT_ATTEMPTS) {
      attempt++;
      line = in.nextLine();
      if (attempt > MAX_INPUT_ATTEMPTS) {
        throw new IllegalArgumentException(MESSAGE_INCORRECT_USERS_INPUTS + MAX_INPUT_ATTEMPTS);
      }
      if (line.length() == 0) {
        System.out.print(MESSAGE_REQUEST_REPEAT_INPUT);
      } else {
        break;
      }
    }
    return line;
  }
}
