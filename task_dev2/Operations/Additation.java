package task_dev2.Operations;

import java.math.BigDecimal;

/**
 * Represent an additation operation
 */
public class Additation {

  /**
   * Performs an action on two operands
   * @param operandA - first operand
   * @param operandB - second operand
   * @return BigDecimal - result of an action
   */
  public BigDecimal solve(BigDecimal operandA, BigDecimal operandB) {
    return operandA.add(operandB);
  }

}