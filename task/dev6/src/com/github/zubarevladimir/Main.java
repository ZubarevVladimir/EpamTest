package com.github.zubarevladimir;

import com.github.zubarevladimir.Format.FormatData;
import java.util.Calendar;
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
    Calendar date = Calendar.getInstance();
    System.out.println(format.formatDateToUserFormat(userDateFormat,date));
  }
}