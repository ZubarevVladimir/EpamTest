package task_dev2;

import java.io.*;
import java.util.*;

/**
 * Make basic operations with expression and contains string expression and solve for it
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
  
  /**
   * Print information about class
   */
  public void printExpression() {
    System.out.println("Expression: " + getExpression());
    System.out.println("Solve: " + getSolve());
  }
  /**
   * Set variable expression and call method for set other variable according to expression
   * @param expression - string contains expression without spaces 
   */
  public void setExpression(String expression) {
    this.expression = expression;
    this.solve = setSolve(expression);
  }
  /**
   * Set variable solve used other private method for it
   * Return variable which contain solve
   * @param expression - string contains expression without spaces 
   * @return double - solve for given expression
   */
  private double setSolve(String expression) {
    List<String> solveList = new ArrayList<String>();
    solveList = splitElemetaryUnits(expression);
    double solve = calculateSolve(solveList);
    return solve;
  }
  
  /**
   * Split string expression on elementary parts (number/operation) and add this operation in list,
   * also includes checking which contains class Checker.
   * Return list of elementary parts
   * @param expression - string contains expression without spaces
   * @return List - list of elementary parts
   */
  private List splitElemetaryUnits(String expression) {
    List<String> listExpression = new ArrayList<String>();
    int flag = 0;
    for (int i = 1; i < expression.length(); i++) {
      String compare = expression.substring(i, i + 1);
      if((compare.equals("e")) || (compare.equals("E"))) {
        i++;
      }
      if ((compare.equals("+")) || (compare.equals("-")) || // Search operation
	      (compare.equals("*")) || (compare.equals("/"))) { 
        listExpression.add(expression.substring(flag, i));  // Add number before this operator 
        listExpression.add(expression.substring(i, i + 1)); // and this operation in list 
        i++;
        flag = i;
      } else {
      }
      if (i == expression.length() - 1) {
        listExpression.add(expression.substring(flag, i + 1));
      }
    }
	Checker.notNullInputArgs(listExpression);
    Checker.checkExpression(listExpression);
	Checker.checkExpressionNext(listExpression);
    return listExpression;
  }
 
  /**
   * Calculate solve using operation and numbers in given list according to operations priority:
   * first ("*", "/"), second ("+", "-")
   * Return solve
   * @param splitExpression - list of elementary parts (number/operation)
   * @return double - solve our expression
   */ 
  public double calculateSolve(List<String> splitExpression) {
    int i = 0;

    while (i < splitExpression.size()) {
      if ((splitExpression.get(i)).equals("*") || (splitExpression.get(i)).equals("/")) { // First operations priority
        splitExpression.set(i - 1, makerOperation(splitExpression.get(i - 1), 
            splitExpression.remove(i + 1), splitExpression.remove(i)));
        i -= 1;
      }
      i++;
    }
    int j = 0;
    while (j < splitExpression.size()) {
      if ((splitExpression.get(j)).equals("+") || (splitExpression.get(j)).equals("-")) { // Second operations priority
        splitExpression.set(j - 1, makerOperation(splitExpression.get(j - 1), 
            splitExpression.remove(j + 1), splitExpression.remove(j)));
        j -= 1;
      }
      j++;
    }
    double mainSolve = Double.parseDouble(splitExpression.get(0));
    return mainSolve;
  }
  
  /**
   * Make elementary operations ("+", "-", "*", "/") and return result this operation
   * Return result this operation
   * @param numberOne - first number for elementary opertion
   * @param numberTwo - second number for elementary operation
   * @param operation - string operation whith need make
   * @return double - result given operation
   */   
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