package task.dev3.EnterUser;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Get in console user's name.
 */
public class EnterUserName {

  /**
   * Give in console user's name.
   * @param in - object for input string in console.
   * @return String - user's name.
   */
  public String enterUserName(Scanner in) {
    int i = 0;
    String userName = "";

    while (i < 1) {
      System.out.println("Enter user's name: ");
      userName = in.nextLine();
      if (userName.matches("^[A-z,-]+$")) {
        i++;
      } else {
          System.out.println("Incorrect name!");
      }
    }
    return userName; 
  }
} 
  