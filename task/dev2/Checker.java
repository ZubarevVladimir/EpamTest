package task.dev2;

import java.io.*;
import java.util.*;

/**
 * Does simple checks what date input correctly.
 */
public class Checker {
  
/* There is static methods, because work with this methods without create exeplar more useful
 * than create exemplar in other classes and methods, i think, but, of course, if this programm
 * will grow this methods can be not static. But there is no information about it.
 */
  /**
   * Methods check length given string and if it's 0 send error message and stop programm.
   * @param args - checking string.
   */
  public static void notNullInputArgs(String args) {
    if ((args.length() == 0) || (args.equals(".") || (args.equals("e")))) {
      System.out.println("ERROR! Please, enter expression");
      System.exit(0); 
    }
  }
  /**
   * Methods check length given string/List and if it's 0 send error message and stop programm.
   * @param args - checking list.
   * @param SIZE - minimum list size.
   */
  public static void checkSizeList(List args, int SIZE) {
    if ((args.size() < SIZE)) {
      System.out.println("ERROR! Please, enter expression.");
      System.exit(0);
    }
  }
}