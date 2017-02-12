package task_dev2;

import java.io.*;
import java.util.*;

/**
 * This class input parametres in programm, or modify in workable type
 */
public class Taker {
	
  /**
  * Compare what user input in comand line and, if user enter nothing,
  * request input expression. Also this method delete spaces between numbers and operators
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