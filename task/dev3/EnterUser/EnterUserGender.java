package task.dev3.EnterUser;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Get in console user's gender.
 */
public class EnterUserGender {

  /**
   * Give in console user's gender.
   * @param in - object for input string in console.
   * @return String - user's gender.
   */
  public String enterUserGender(Scanner in) {
    String userGender = "";
    int i = 0;

    while (i < 1) {
      System.out.println("Enter user's gender (man/woman): ");
      userGender = in.nextLine();
      if ((userGender.equals("man")) || (userGender.equals("woman"))) {
        i++;
      } else {
          System.out.println("Incorrect gender, choose 'man' or 'woman'.");
      }
    }
    return userGender;
  }
}
  