package com.github.zubarevladimir.Matrix;

import java.util.Scanner;

/**
 * Contains methods for read matrix.
 */
public class MatrixReader {

  private final String MESSAGE_FOR_ENTER_CORRECT_NUMBER = "Enter correct number: ";
  private final String MESSAGE_ATTEMPTS_REMAINING = "Attempts remaining: ";
  private final int MAX_INPUT_ATTEMPTS = 5;

  /**
   * Read matrix in console.
   *
   * @return double[][] - read matrix.
   * @throws NumberFormatException if number inputs more then MAX_INPUT_ATTEMPTS.
   */
  public double[][] readMatrix() throws NumberFormatException {

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
   * @throws NumberFormatException if number inputs more then MAX_INPUT_ATTEMPTS.
   */
  private double correctDoubleElement() throws NumberFormatException {
    double number;
    int attempt = 1;
    while (attempt <= MAX_INPUT_ATTEMPTS) {
      Scanner input = new Scanner(System.in);
      try {
        number = Double.parseDouble(input.nextLine());
        return number;
      } catch (NumberFormatException ex) {
        if (attempt == MAX_INPUT_ATTEMPTS) {
          throw new NumberFormatException();
        }
        System.out.println(MESSAGE_ATTEMPTS_REMAINING + (MAX_INPUT_ATTEMPTS - attempt++));
        System.out.print(MESSAGE_FOR_ENTER_CORRECT_NUMBER);
      }
    }
    return 0;
  }

  /**
   * Read integer number in console, and if it's not integer, request to repeat input.
   *
   * @return int - written to console number.
   * @throws NumberFormatException if number inputs more then MAX_INPUT_ATTEMPTS.
   */
  private int correctIntElement() throws NumberFormatException {
    int number;
    int attempt = 1;
    while (attempt <= MAX_INPUT_ATTEMPTS) {
      Scanner input = new Scanner(System.in);
      try {
        number = Integer.parseInt(input.nextLine());
        return number;
      } catch (NumberFormatException ex) {
        if (attempt == MAX_INPUT_ATTEMPTS) {
          throw new NumberFormatException();
        }
        System.out.println(MESSAGE_ATTEMPTS_REMAINING + (MAX_INPUT_ATTEMPTS - attempt++));
        System.out.print(MESSAGE_FOR_ENTER_CORRECT_NUMBER);
      }
    }
    return 0;
  }
}