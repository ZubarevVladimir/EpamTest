package com.github.zubarevladimir.Matrix;

import com.sun.javaws.exceptions.InvalidArgumentException;

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
      throws InvalidArgumentException {

    int linesOne = matrixOne.length;
    int columnsOne = matrixOne[0].length;
    int linesTwo = matrixTwo.length;
    int columnsTwo = matrixTwo[0].length;

    if (columnsOne != linesTwo) {
      String[] argumentsArray = {"Columns first matrix: " + Integer.toString(columnsOne),
          "Lines second matrix: " + Integer.toString(linesTwo)};
      throw new InvalidArgumentException(argumentsArray);
    }
    double[][] resultMatrix = new double[linesOne][columnsTwo];
    for (int i = 0; i < linesOne; i++) {
      for (int j = 0; j < columnsTwo; j++) {
        resultMatrix[i][j] += calculateResultMatrixElement(matrixOne, matrixTwo, i, j);
      }
    }
    return resultMatrix;
  }

  /**
   * Calculate result matrix element.
   *
   * @param matrixOne array contains first matrix elements.
   * @param matrixTwo array contains second matrix elements.
   * @param i number line in first matrix.
   * @param j number columns in second matrix.
   * @return double element result matrix.
   */
  private double calculateResultMatrixElement(double[][] matrixOne, double[][] matrixTwo, int i,
      int j) {
    double resultMatrixElement = 0;
    int columnsOne = matrixOne[0].length;
    for (int k = 0; k < columnsOne; k++) {
      resultMatrixElement += matrixOne[i][k] * matrixTwo[k][j];
    }
    return resultMatrixElement;
  }
}
