package task_dev2;



import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Contains information about arithmetic expression
 */
public class ArithmeticExpression {

  private String expression;
  private double solve;

  ArithmeticExpression(String expression) {
    this.expression = expression;
    setSolve(expression);
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
    setSolve(expression);
  }

  /**
   * Sets variable solve and uses class Calculator for it 
   * @param expression - string contains expression without spaces 
   */
  private void setSolve(String expression) {
    Calculator calc = new Calculator();
    this.solve = calc.calculateSolve(expression);
  }
 
}