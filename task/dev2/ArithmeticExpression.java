package task.dev2;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Contains information about arithmetic expression.
 */
public class ArithmeticExpression {
  private String expression;
  private double solve;
  
 /**
  * Initialize object while creating.
  */
  ArithmeticExpression(String expression) {
    this.expression = expression;
    solve = 0;
  }

  /**
   * Get variable expression.
   * @return String - string expression.
   */  
  public String getExpression() {
    return this.expression;
  }
  
  /**
   * Get variable solve.
   * @return double - solve for our exemplar.
   */
  public double getSolve() {
    return this.solve;
  }
  
  /**
   * Print variables {expression} and {solve}.
   */
  public void printVariables() {
    System.out.println("Expression: " + getExpression());
    System.out.println("Solve: " + getSolve());
  }
  
  /**
   * Set variable expression and call method for set other variable according to expression.
   * @param expression - string contains expression without spaces.
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }
  
  /**
   * Sets variable solve and uses class Calculator for it.
   * @param expression - string contains expression without spaces.
   */
  public void setSolve(double outerSolve) {
    this.solve = outerSolve;
  }
}