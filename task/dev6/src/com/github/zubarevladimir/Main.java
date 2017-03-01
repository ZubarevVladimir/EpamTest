package com.github.zubarevladimir;

import com.github.zubarevladimir.Format.FormatData;
import java.util.Scanner;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point.
   */
  public static void main(String[] args) {
    System.out.println("Enter date-format");
    Scanner in = new Scanner(System.in);
    String userDateFormat = in.nextLine();
    FormatData format = new FormatData();
    userDateFormat = format.doDateFormat(userDateFormat);
    System.out.println(userDateFormat);
  }
}