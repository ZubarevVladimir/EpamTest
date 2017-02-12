package task.dev2.Operations;

import java.math.BigDecimal;

/**
 * Represent an additation operation.
 */
public class Additation {
  
  /**
   * Performs an action on two numbers.
   * @param numberOne - first numbers.
   * @param numberTwo - second numbers.
   * @return BigDecimal - result of an action.
   */
  public BigDecimal solve(BigDecimal numberOne, BigDecimal numberTwo) {
    return numberOne.add(numberTwo);
  }
}