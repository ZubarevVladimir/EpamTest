package task.dev3.EnterUser;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Get in console user's surname.
 */
public class EnterUserSurname {

  /**
   * Give in console user's surname.
   * @param in - object for input string in console.
   * @return String - user's surname.
   */
  public String enterUserSurname(Scanner in) {
    String userSurname = "";
    int i = 0;

    while (i < 1) {
      System.out.println("Enter user's surname: ");
      userSurname = in.nextLine();
      if (userSurname.matches("^[A-z,-]+$")) {
        i++;
      } else {
          System.out.println("Incorrect name!");
      }
    }
    return userSurname;
  }
}  