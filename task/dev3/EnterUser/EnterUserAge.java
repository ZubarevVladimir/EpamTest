package task.dev3.EnterUser;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Get in console user's age.
 */
public class EnterUserAge {

  /**
   * Give in console user's age
   * @param in - object for input string in console
   * @return int - user's age
   */
  public int enterUserAge(Scanner in) {
    int age = 0;
    int i = 0;

    while (i < 1) {
      System.out.println("Enter user's age: ");
      String stringAge = in.nextLine();
        if (stringAge.matches("^\\d+$")) {
          age = Integer.parseInt(stringAge);
          i++;
      } else {
          System.out.println("Incorrect name!");
      }
    }
    return age;
  }
 }
  