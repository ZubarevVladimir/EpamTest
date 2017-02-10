package task_dev2;

import java.io.*;
import java.util.*;

/**
 * This class is entry point to work.
 */
public class Checker {

  public String inputArgs(String[] args) {
    String expression = "";
    if (args.length == 0) {
      System.out.println("Enter arifmetical expression:");
      Scanner in = new Scanner(System.in);
      expression = in.nextLine();
      expression = expression.replaceAll(" ", "");
    } else {
      for (int i = 0; i < args.length; i++) {
        expression = expression.concat(args[i]);
      }
    }
    return expression;
  }
}