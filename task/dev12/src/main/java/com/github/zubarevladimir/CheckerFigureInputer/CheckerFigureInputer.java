package com.github.zubarevladimir.CheckerFigureInputer;

import com.github.zubarevladimir.CheckerFigure.BlackChecker;
import com.github.zubarevladimir.CheckerFigure.CheckerFigure;
import com.github.zubarevladimir.CheckerFigure.WhiteChecker;
import com.github.zubarevladimir.Validator.CheckerValidator;
import java.util.Scanner;

/**
 * Contains methods for reads information from console and set variable class checker.
 */
public class CheckerFigureInputer {

  private CheckerFigure inputsCheckerFigure;
  private CheckerValidator validator;
  private final String TYPE_WHITE = "white";
  private final String TYPE_BLACK = "black";
  private final String MESSAGE_INPUT_START_COORDINATE = "Input start coordinate";
  private final String MESSAGE_INPUT_STOP_COORDINATE = "Input stop coordinate";
  private final String MESSAGE_INPUT_TYPE = "Enter type (white/black): ";
  private final String MESSAGE_INCORRECT_INPUT = "Incorrect user's inputs: ";
  private final String MESSAGE_INPUT_CORRECT_TYPE = "Input correct type (white/black): ";
  private final String MESSAGE_INPUT_CORRECT_COORDINATE = "Input correct coordinate: ";

  public CheckerFigureInputer(CheckerValidator validator) {
    this.validator = validator;
  }

  /**
   * Inputs checker.
   *
   * @param maximalNumberIncorrectInputs contains maximal number incorrect user's inputs.
   * @return CheckerFigure - inputs checker.
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  public CheckerFigure CheckerInput(int maximalNumberIncorrectInputs) throws NumberInputsException {
    Scanner in = new Scanner(System.in);
    String inputsType = inputType(in, maximalNumberIncorrectInputs);
    if (inputsType.equals(TYPE_BLACK)) {
      inputsCheckerFigure = new BlackChecker();
    } else if (inputsType.equals(TYPE_WHITE)) {
      inputsCheckerFigure = new WhiteChecker();
    }
    System.out.println(MESSAGE_INPUT_START_COORDINATE);
    String startCoordinate = inputCoordinate(in, maximalNumberIncorrectInputs);
    inputsCheckerFigure.getStartCoordinate().setCoordinates(startCoordinate, validator);
    System.out.println(MESSAGE_INPUT_STOP_COORDINATE);
    String stopCoordinate = inputCoordinate(in, maximalNumberIncorrectInputs);
    inputsCheckerFigure.getStopCoordinate().setCoordinates(stopCoordinate, validator);
    return inputsCheckerFigure;
  }

  /**
   * Input checker's type.
   *
   * @param in variable for console inputs.
   * @param maximalNumberIncorrectInputs contains maximal number incorrect user's inputs.
   * @return String - inputs checker's type(white or black).
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  private String inputType(Scanner in, int maximalNumberIncorrectInputs)
      throws NumberInputsException {
    System.out.print(MESSAGE_INPUT_TYPE);
    String type;
    int errorInputsCounter = 0;
    while (true) {
      type = in.nextLine().replaceAll(" ", "").toLowerCase();
      try {
        if (validator.validateType(type)) {
          break;
        }
      } catch (IllegalArgumentException ex) {
        errorInputsCounter++;
        if (errorInputsCounter == maximalNumberIncorrectInputs) {
          throw new NumberInputsException(MESSAGE_INCORRECT_INPUT + errorInputsCounter);
        }
        System.out.println(ex.getMessage());
        System.out.print(MESSAGE_INPUT_CORRECT_TYPE);
      }
    }
    return type;
  }

  /**
   * Inputs checker's coordinate.
   *
   * @param in variable for console inputs.
   * @param maximalNumberIncorrectInputs contains maximal number incorrect user's inputs.
   * @return String - inputs checker's coordinate.
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  private String inputCoordinate(Scanner in, int maximalNumberIncorrectInputs)
      throws NumberInputsException {
    String coordinate;
    int errorInputsCounter = 0;
    while (true) {
      coordinate = in.nextLine().replaceAll(" ", "").toUpperCase();
      try {
        if (validator.validateCoordinate(coordinate)) {
          break;
        }
      } catch (IllegalArgumentException ex) {
        errorInputsCounter++;
        if (errorInputsCounter == maximalNumberIncorrectInputs) {
          throw new NumberInputsException(MESSAGE_INCORRECT_INPUT + errorInputsCounter);
        }
        System.out.println(ex.getMessage());
        System.out.print(MESSAGE_INPUT_CORRECT_COORDINATE);
      }
    }
    return coordinate;
  }
}