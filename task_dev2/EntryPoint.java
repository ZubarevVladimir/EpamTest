package task_dev2;

import task_dev2.Operations.*;

import java.io.*;
import java.util.*;
 
/**
 * This class is entry point to work.
 */
public class EntryPoint {
  public static void main(String[] args) {
  Taker take = new Taker();
  String expression = take.inputArgs(args);
  ArithmeticExpression arphmeticalExpression = new ArithmeticExpression(expression);
  arphmeticalExpression.printExpression();
  } 
}