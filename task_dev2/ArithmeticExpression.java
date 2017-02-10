package task_dev2;

import java.io.*;
import java.util.*;

/**
 * Comment :)
 */
public class ArithmeticExpression {

  private String expression;
  private double solve;

  ArithmeticExpression(String expression) {
    this.expression = expression;
    this.solve = setSolve(expression);
  }

  public String getExpression() {
    return this.expression;
  }

  public double getSolve() {
    return this.solve;
  }

  public void printExpression() {
    System.out.println("Expression: " + getExpression());
    System.out.println("Solve: " + getSolve());
  }

  public void setExpression(String expression) {
    this.expression = expression;
    this.solve = setSolve(expression);
  }

  private double setSolve(String expression) {
    List<String> solveList = new ArrayList<String>();
    solveList = splitElemetaryUnits(expression);
    double solve = calculateSolve(solveList);
    return solve;
  }

  private List splitElemetaryUnits(String expression) {
    List<String> listExpression = new ArrayList<String>();
    int flag = 0;
    for (int i = 0; i < expression.length(); i++) {
      String compare = expression.substring(i, i + 1);
      if ((compare.equals("+")) || (compare.equals("-")) || (compare.equals("*")) || (compare.equals("/"))) {
        listExpression.add(expression.substring(flag, i));
        listExpression.add(expression.substring(i, i + 1));
        i++;
        flag = i;
      } else {
      }
      if (i == expression.length() - 1) {
        listExpression.add(expression.substring(flag, i + 1));
      }
    }
    return listExpression;
  }

  public double calculateSolve(List<String> splitExpression) {
    int i = 0;

    while (i < splitExpression.size()) {
      if ((splitExpression.get(i)).equals("*") || (splitExpression.get(i)).equals("/")) {
        splitExpression.set(i - 1, makerOperation(splitExpression.get(i - 1), 
            splitExpression.remove(i + 1), splitExpression.remove(i)));
        i -= 1;
      }
      i++;
    }
    int j = 0;
    while (j < splitExpression.size()) {
      if ((splitExpression.get(j)).equals("+") || (splitExpression.get(j)).equals("-")) {
        splitExpression.set(j - 1, makerOperation(splitExpression.get(j - 1), 
            splitExpression.remove(j + 1), splitExpression.remove(j)));
        j -= 1;
      }
      j++;
    }
    double firstSolve = Double.parseDouble(splitExpression.get(0));
    return firstSolve;
  }

  private String makerOperation(String numberOne, String numberTwo, String operation) {
    double doubleNumber;
    String stringNumber = "";
    switch (operation) {
      case ("*"):
        doubleNumber = (Double.parseDouble(numberOne)) * (Double.parseDouble(numberTwo));
        stringNumber = doubleNumber + "";
        break;
      case ("/"):
        doubleNumber = (Double.parseDouble(numberOne)) / (Double.parseDouble(numberTwo));
        stringNumber = doubleNumber + "";
        break;
      case ("+"):
        doubleNumber = (Double.parseDouble(numberOne)) + (Double.parseDouble(numberTwo));
        stringNumber = doubleNumber + "";
        break;
      case ("-"):
        doubleNumber = (Double.parseDouble(numberOne)) - (Double.parseDouble(numberTwo));
        stringNumber = doubleNumber + "";
        break;
    }
    return stringNumber;
  }
}