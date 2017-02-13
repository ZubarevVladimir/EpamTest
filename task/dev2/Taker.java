package task.dev2;

import java.io.*;
import java.util.*;

/**
 * This class input parametres in programm, or modify in workable type.
 */
public class Taker {
  
  /**
  * Give string in console or combine array in string.
  * and add given string in List
  * @param args - array, giving in comand line
  * @return List - list contain expression without spaces
  */
  public String inputArgs(String[] args) {
    String expression = "";
    if (args.length == 0) {
      System.out.println("Enter arifmetical expression:");
      Scanner in = new Scanner(System.in);
      expression = in.nextLine();
      expression = expression.replaceAll(" ", ""); // Delete spaces in input string
    } else {
      for (int i = 0; i < args.length; i++) {
        expression = expression.concat(args[i]);
      }
    }
    Checker.notNullInputArgs(expression);
    return expression;
  }
}