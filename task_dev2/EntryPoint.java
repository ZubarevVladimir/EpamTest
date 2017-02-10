package task_dev2;

import java.io.*;
import java.util.*;
 
/**
 * This class is entry point to work.
 */
public class EntryPoint {
  public static void main(String[] args) {
  Checker check = new Checker();
  String expression = check.inputArgs(args);
  ArithmeticExpression arphmeticalExpression = new ArithmeticExpression(expression);
  arphmeticalExpression.printExpression();
  }  
}