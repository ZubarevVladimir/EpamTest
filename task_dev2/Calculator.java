package task_dev2;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Does calculations for given parametres
 */
public class Calculator {

  private final String PLUS = "+";
  private final String MINUS = "-";
  private final String DEVIDE = "/";
  private final String MULTIPLY = "*";

  /**
   * Set variable solve used other private method for it
   * Return variable which contain solve
   * @param expression - string contains expression without spaces 
   * @return double - solve for given expression
   */
  public double calculateSolve(String expression) {
    List<String> solveList = new ArrayList<String>();
    solveList = splitElemetaryUnits(expression);
    double solve = doPriorityOperations(solveList);
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
      if ((compare.equals(PLUS)) || (compare.equals(MINUS)) || // Search operation
	    (compare.equals(MULTIPLY)) || (compare.equals(DEVIDE))) { 
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
    return listExpression;
  }

  /**
   * Set operation priority for method changeSolve and get solve
   * Return received solve
   * @param splitExpression - list of elementary parts (number/operation)
   * @return double - solve according to given list
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
   * Change given list according to operation priority 
   * Return list without priority operations
   * @param splitExpression - list of elementary parts (number/operation)
   * @param operationOne - first priority operation
   * @param operationTwo - second priority operation
   * @return List - changed expression without priority operation
   */ 
  private List changeSolveList(List<String> splitExpression, String operationOne, String operationTwo) {
    int i = 0;
    while (i < splitExpression.size()) {
      if ((splitExpression.get(i)).equals(operationOne) || (splitExpression.get(i)).equals(operationTwo)) { // First operations priority
        splitExpression.set(i - 1, makerOperation(splitExpression.get(i - 1), 
            splitExpression.remove(i + 1), splitExpression.remove(i)));
        i -= 1;
      }
      i++;
    }
  return splitExpression; 
  }
  
  /**
   * Make elementary operations ("+", "-", "*", "/") with given numbers
   * Return result this operation
   * @param numberOne - first number for elementary opertion
   * @param numberTwo - second number for elementary operation
   * @param operation - string operation whith need make
   * @return double - result given operation
   */   
  private String makerOperation(String numberOne, String numberTwo, String operation) {
    BigDecimal doubleNumberOne = new BigDecimal(numberOne);
    BigDecimal doubleNumberTwo = new BigDecimal(numberTwo);
    BigDecimal doubleNumber = new BigDecimal("1");
    String stringNumber = "";
    switch (operation) {
      case (MULTIPLY):
        doubleNumber = doubleNumberOne.multiply(doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
      case (DEVIDE):
        doubleNumber = doubleNumberOne.divide(doubleNumberTwo, 5, BigDecimal.ROUND_HALF_UP);
        stringNumber = doubleNumber.toString();
        break;
      case (PLUS):
        doubleNumber = doubleNumberOne.add(doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
      case (MINUS):
        doubleNumber = doubleNumberOne.subtract(doubleNumberTwo);
        stringNumber = doubleNumber.toString();
        break;
    }
    return stringNumber;
  }
}