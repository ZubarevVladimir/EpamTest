package com.github.zubarevladimir;

import java.util.Scanner;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Владимир on 01.03.2017.
 */
public class ReadMatrix {

  private final String MESSAGE_FOR_ENTER_CORRECT_NUMBER = "Enter correct number: ";

  /**
   * Read matrix in console.
   *
   * @return double[][] - read matrix.
   */
  public double[][] readMatrix() {

    final String MESSAGE_FOR_ENTER_LINES_MATRIX = "Enter number lines in matrix: ";
    final String MESSAGE_FOR_ENTER_COLUMNS_MATRIX = "Enter number column in matrix: ";
    final String MESSAGE_FOR_ENTER_MATRIX_ELEMENT = "Enter matrix element";
    int a, b;
    System.out.print(MESSAGE_FOR_ENTER_LINES_MATRIX);
    a = correctIntElement();
    System.out.print(MESSAGE_FOR_ENTER_COLUMNS_MATRIX);
    b = correctIntElement();
    double[][] matrix = new double[a][b];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(MESSAGE_FOR_ENTER_MATRIX_ELEMENT + "[" + i + "][" + j + "]: ");
        matrix[i][j] = correctDoubleElement();
      }
    }
    return matrix;
  }

  /**
   * Read double number in console, and if it's not double, request to repeat input.
   *
   * @return double - written to console number.
   */
  private double correctDoubleElement() {
    double number;
    for (; ; ) {
      Scanner input = new Scanner(System.in);
      try {
        number = Double.parseDouble(input.nextLine());
        break;
      } catch (NumberFormatException ex) {
        System.out.print(MESSAGE_FOR_ENTER_CORRECT_NUMBER);
      }
    }
    return number;
  }

  /**
   * Read ineger number in console, and if it's not integer, request to repeat input.
   *
   * @return int - written to console number.
   */
  private int correctIntElement() {
    int number;
    for (; ; ) {
      Scanner input = new Scanner(System.in);
      try {
        number = Integer.parseInt(input.nextLine());
        break;
      } catch (NumberFormatException ex) {
        System.out.print(MESSAGE_FOR_ENTER_CORRECT_NUMBER);
      }
    }
    return number;
  }
}