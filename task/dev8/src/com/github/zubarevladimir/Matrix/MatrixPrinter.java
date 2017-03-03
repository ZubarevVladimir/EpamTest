package com.github.zubarevladimir.Matrix;

/**
 * Contains method for print matrix.
 */
public class MatrixPrinter {

  /**
   * Print given matrix.
   *
   * @param matrix array contains matrix elements.
   */
  public void printMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
