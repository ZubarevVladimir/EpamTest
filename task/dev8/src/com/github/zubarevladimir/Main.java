package com.github.zubarevladimir;

import java.util.Scanner;

public class Main {

  /**
   * Entry point method.
   * @param args not used parameter.
   */
  public static void main(String[] args) {
    ReadMatrix reader = new ReadMatrix();
    MatrixMultiply multiplier = new MatrixMultiply();
    System.out.println("First matrix");
    double[][] matrixOne = reader.readMatrix();
    System.out.println("Second matrix");
    double[][] matrixTwo = reader.readMatrix();
    double[][] resultMatrix;
    try {
      resultMatrix = multiplier.doMultiply(matrixOne, matrixTwo);
      System.out.println("Result matrix: ");
      for (int i = 0; i < resultMatrix.length; i++) {
        for (int j = 0; j < resultMatrix[i].length; j++) {
          System.out.print(resultMatrix[i][j] + " ");
        }
        System.out.println();
      }
    } catch (ArithmeticException ex){
      System.out.println(ex.getLocalizedMessage());
    }
  }
}