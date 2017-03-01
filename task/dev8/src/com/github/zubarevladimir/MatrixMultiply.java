package com.github.zubarevladimir;

/**
 * Contains method for multiply matrix.
 */
public class MatrixMultiply {

  /**
   * Multiply given matrix.
   *
   * @param matrixOne array contains first matrix elements.
   * @param matrixTwo array contains second matrix elements.
   * @return double[][] - result matrix.
   * @throws ArithmeticException throw if matrix can't multiply.
   */
  public double[][] doMultiply(double[][] matrixOne, double[][] matrixTwo)
      throws ArithmeticException {

    final String MULTIPLY_ERROR_MESSAGE = "Can't multiply given matrix";
    int linesOne = matrixOne.length;
    int columnsOne = matrixOne[0].length;
    int linesTwo = matrixTwo.length;
    int columnsTwo = matrixTwo[0].length;

    if (columnsOne != linesTwo) {
      throw new ArithmeticException(MULTIPLY_ERROR_MESSAGE);
    }
    double[][] resultMatrix = new double[linesOne][columnsTwo];
    for (int i = 0; i < linesOne; i++) {
      for (int j = 0; j < columnsTwo; j++) {
        resultMatrix[i][j] = 0;
        for (int k = 0; k < columnsOne; k++) {
          resultMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
        }
      }
    }
    return resultMatrix;
  }

}
