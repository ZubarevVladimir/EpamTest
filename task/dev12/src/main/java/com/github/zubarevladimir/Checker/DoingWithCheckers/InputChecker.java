package com.github.zubarevladimir.Checker.DoingWithCheckers;

import com.github.zubarevladimir.Checker.Checker;
import com.github.zubarevladimir.Validator.CheckerValidator;
import java.util.Scanner;

/**
 * Contains methods for reads information from console and set variable class checker.
 */
public class InputChecker {

  private final int MAX_INCORRECT_INPUTS = 5;
  private final String MESSAGE_INPUT_START_COORDINATE = "Input start coordinate";
  private final String MESSAGE_INPUT_STOP_COORDINATE = "Input stop coordinate";
  private final String MESSAGE_INPUT_TYPE = "Enter type (white/black): ";
  private final String MESSAGE_INCORRECT_INPUT = "Incorrect user's inputs: ";
  private final String MESSAGE_INPUT_CORRECT_TYPE = "Input correct type (white/black): ";
  private final String MESSAGE_INPUT_CORRECT_COORDINATE = "Input correct coordinate: ";

  /**
   * Reads information from console and set it's to variable given class checker.
   *
   * @param checker setted exemplar class Checker.
   * @param validator contains methods for validate setted variables.
   * @throws IllegalArgumentException if user's number inputs more than maximal number.
   */
  public void setInputsCoordinates(Checker checker, CheckerValidator validator)
      throws IllegalArgumentException {
    Scanner in = new Scanner(System.in);
    checker.setType(inputType(in, validator), validator);
    System.out.println(MESSAGE_INPUT_START_COORDINATE);
    String startCoordinate = inputCoordinate(in, validator);
    checker.setStartCoordinate(startCoordinate, validator);
    System.out.println(MESSAGE_INPUT_STOP_COORDINATE);
    String stopCoordinate = inputCoordinate(in, validator);
    checker.setStopCoordinate(stopCoordinate, validator);
  }

  /**
   * Read checker's type from console.
   *
   * @param in variable class Scanner for read information from console.
   * @param validator contains methods for validate setted variables.
   * @return String - inputted type.
   * @throws IllegalArgumentException if user's number inputs more than maximal number.
   */
  private String inputType(Scanner in, CheckerValidator validator) throws IllegalArgumentException {
    System.out.print(MESSAGE_INPUT_TYPE);
    String type;
    int errorCounter = 0;
    while (true) {
      type = in.nextLine().replaceAll(" ", "").toLowerCase();
      try {
        if (validator.validateType(type)) {
          break;
        }
      } catch (IllegalArgumentException ex) {
        errorCounter++;
        if (errorCounter == MAX_INCORRECT_INPUTS) {
          throw new IllegalArgumentException(MESSAGE_INCORRECT_INPUT + errorCounter);
        }
        System.out.println(ex.getMessage());
        System.out.print(MESSAGE_INPUT_CORRECT_TYPE);
      }
    }

    return type;
  }

  /**
   * Read checker's type from console.
   *
   * @param in variable class Scanner for read information from console.
   * @param validator contains methods for validate setted variables.
   * @return - String inputted coordinate.
   * @throws IllegalArgumentException if user's number inputs more than maximal number.
   */
  private String inputCoordinate(Scanner in, CheckerValidator validator)
      throws IllegalArgumentException {
    String coordinate;
    int errorCounter = 0;
    while (true) {
      coordinate = in.nextLine().replaceAll(" ", "").toUpperCase();
      try {
        if (validator.validateCoordinate(coordinate)) {
          break;
        }
      } catch (IllegalArgumentException ex) {
        errorCounter++;
        if (errorCounter == MAX_INCORRECT_INPUTS) {
          throw new IllegalArgumentException(MESSAGE_INCORRECT_INPUT + errorCounter);
        }
        System.out.println(ex.getMessage());
        System.out.print(MESSAGE_INPUT_CORRECT_COORDINATE);
      }
    }
    return coordinate;
  }
}