package com.github.zubarevladimir;

import com.github.zubarevladimir.Matrix.*;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class Main {

  /**
   * Entry point method.
   *
   * @param args not used parameter.
   */
  public static void main(String[] args) {
    MatrixReader reader = new MatrixReader();
    MatrixMultiply multiplier = new MatrixMultiply();
    MatrixPrinter printer = new MatrixPrinter();
    double[][] resultMatrix;
    double[][] matrixOne;
    double[][] matrixTwo;
    try {
      System.out.println("First matrix");
      matrixOne = reader.readMatrix();
      System.out.println("Second matrix");
      matrixTwo = reader.readMatrix();
      resultMatrix = multiplier.doMultiply(matrixOne, matrixTwo);
      System.out.println("Result matrix: ");
      printer.printMatrix(resultMatrix);
    } catch (NumberFormatException ex) {
      System.out.println("Error! Too much incorrect inputs");
    } catch (InvalidArgumentException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}