package task_dev2;

import java.io.*;
import java.util.*;

/**
 * This class contains method for check work programm.
 * There is static methods, because work with this methods without create exeplar more useful 
 * than create exemplar in other classes and methods, i think...
 */
public class Checker {
	
  /**
   * Methods check length given string/List and if it's 0 send error message and stop programm
   */
  public static void notNullInputArgs(String args) {
    if ((args.length() == 0) || (args.equals(".") || (args.equals("e")))) {
      System.out.println("ERROR! Please, enter expression");
      System.exit(0); 
    }
  }

  public static void notNullInputArgs(List args) {
    if ((args.size() < 3)) {
      System.out.println("ERROR! Please, enter expression.");
      System.exit(0); 
    }
  }
  
}