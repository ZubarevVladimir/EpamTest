package com.github.zubarevladimir;

import java.util.Scanner;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point to work.
   *
   * @param args not used parameter.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter date in format: \"dd/MM/yyyy HH:mm:cc\"");
    String dateAndTime = in.nextLine();
    CheckDateAndTime checker = new CheckDateAndTime();
    System.out.println(checker.checkDateAndTime(dateAndTime));
  }
}