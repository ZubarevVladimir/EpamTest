package task.dev2;

import task.dev2.Operations.*;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Does calculations.
 */
public class Calculator {
  private final String PLUS = "+";
  private final String MINUS = "-";
  private final String DEVIDE = "/";
  private final String MULTIPLY = "*";
  private final int MIN_LIST_SIZE = 3;
  private final String UC_EXP = "E";
  private final String LC_EXP = "e";
  
  /**
   * Calculate solve for given expression.
   * @param expression - string contains expression without spaces.
   * @return double - solve for given expression.
   */
  public double calculateSolve(String expression) {
    List<String> solveList = new ArrayList<String>();
    solveList = splitElemetaryUnits(expression);
    double solve = doPriorityOperations(solveList);
    return solve;
  }
  
  /**
   * Split string expression on elementary parts (number/operation) and add this operation in list.
   * @param expression - string contains expression without spaces.
   * @return List - list of elementary parts.
   */
  private List splitElemetaryUnits(String expression) {
    List<String> listExpression = new ArrayList<String>();
    int flag = 0;
    for (int i = 1; i < expression.length(); i++) {
      String compare = expression.substring(i, i + 1);
      if ((compare.equals(LC_EXP)) || (compare.equals(UC_EXP))) {
        i++;
      }
      if ((compare.equals(PLUS)) || (compare.equals(MINUS)) || // Search operation.
          (compare.equals(MULTIPLY)) || (compare.equals(DEVIDE))) {
        listExpression.add(expression.substring(flag, i)); // Add number before this operator
        listExpression.add(expression.substring(i, i + 1)); // and this operation in list.
        i++;
        flag = i;
      } 
      if (i == expression.length() - 1) {
        listExpression.add(expression.substring(flag, i + 1));
      }
    }
    Checker.checkSizeList(listExpression, MIN_LIST_SIZE);
    return listExpression;
  }
  
  /**
   * Set operation priority for method {changeSolve} and get solve.
   * @param splitExpression - list of elementary parts (number/operation).
   * @return double - solve according to given list.
   */
  private double doPriorityOperations(List<String> splitExpression) {
    List<String> minList = new ArrayList<String>();
    try {
      minList = changeSolveList(splitExpression, MULTIPLY, DEVIDE);
      minList = changeSolveList(minList, PLUS, MINUS);
    } catch (NumberFormatException ex) {
        System.out.println("Errorr! Number format is incorrect!");
        System.exit(0);
    } catch (ArithmeticException ex) {
        System.out.println("Errorr! Incorrect arithmetic expression!");
        System.exit(0);
    }
    double solve = Double.parseDouble(minList.remove(0));
    return solve;
  }
  
  /**
   * Change given list according to operation priority.
   * @param splitExpression - list of elementary parts (number/operation).
   * @param operationOne - first priority operation.
   * @param operationTwo - second priority operation
   * @return List - changed expression without priority operation.
   */
  private List changeSolveList(List<String> splitExpression, String operationOne, String operationTwo) {
    int i = 1;
    while (i < splitExpression.size()) {
      if ((splitExpression.get(i)).equals(operationOne) ||
          (splitExpression.get(i)).equals(operationTwo)) { // Search priority operations
        splitExpression.set(i - 1, makerOperation(splitExpression.get(i - 1),
            splitExpression.remove(i + 1), splitExpression.remove(i)));
        i -= 1;
      }
      i++;
    }
    return splitExpression;
  }
  
  /**
   * Does elementary operations ("+", "-", "*", "/") with given numbers.
   * @param numberOne - first number for elementary opertion.
   * @param numberTwo - second number for elementary operation.
   * @param operation - string operation whith need make.
   * @return double - result given operation.
   */
  private String makerOperation(String numberOne, String numberTwo, String operation) {
    BigDecimal doubleNumberOne = new BigDecimal(numberOne);
    BigDecimal doubleNumberTwo = new BigDecimal(numberTwo);
    BigDecimal doubleNumber = new BigDecimal("1");
    String stringNumber = "";
    switch (operation) {
      case (MULTIPLY):
        Multiplication multiply = new Multiplication();
        doubleNumber = multiply.solve(doubleNumberOne, doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
      case (DEVIDE):
        Division divide = new Division();
        doubleNumber = divide.solve(doubleNumberOne, doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
      case (PLUS):
        Additation add = new Additation();
        doubleNumber = add.solve(doubleNumberOne, doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
      case (MINUS):
        Subtraction subtract = new Subtraction();
        doubleNumber = subtract.solve(doubleNumberOne, doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
    }
    return stringNumber;
  }
}