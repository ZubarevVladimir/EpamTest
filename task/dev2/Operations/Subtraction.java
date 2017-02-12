package task.dev2.Operations;

import java.math.BigDecimal;

/**
 * Represent an subtraction operation.
 */
public class Subtraction {
  
  /**
   * Performs an action on two numbers.
   * @param numberOne - first numbers.
   * @param numberTwo - second numbers.
   * @return BigDecimal - result of an action.
   */
  public BigDecimal solve(BigDecimal numberOne, BigDecimal numberTwo) {
    return numberOne.subtract(numberTwo);
  }
}