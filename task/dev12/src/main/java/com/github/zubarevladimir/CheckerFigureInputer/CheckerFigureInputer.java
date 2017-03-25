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
  private final int MAX_INCORRECT_INPUTS = 5;
  private final String MESSAGE_INPUT_START_COORDINATE = "Input start coordinate";
  private final String MESSAGE_INPUT_STOP_COORDINATE = "Input stop coordinate";
  private final String MESSAGE_INPUT_TYPE = "Enter type (white/black): ";
  private final String MESSAGE_INCORRECT_INPUT = "Incorrect user's inputs: ";
  private final String MESSAGE_INPUT_CORRECT_TYPE = "Input correct type (white/black): ";
  private final String MESSAGE_INPUT_CORRECT_COORDINATE = "Input correct coordinate: ";

  /**
   * Read to console inputs parameters and represent it like checker.
   *
   * @param validator contains methods for validate setted variables.
   * @return CheckerFigure - inputs checker.
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  public CheckerFigure CheckerInput(CheckerValidator validator) throws NumberInputsException {
    Scanner in = new Scanner(System.in);
    String inputsType = inputType(in, validator);
    if (inputsType.equals("black")) {
      inputsCheckerFigure = new BlackChecker();
    } else if (inputsType.equals("white")) {
      inputsCheckerFigure = new WhiteChecker();
    }
    System.out.println(MESSAGE_INPUT_START_COORDINATE);
    String startCoordinate = inputCoordinate(in, validator);
    inputsCheckerFigure.getStartCoordinate().setCoordinates(startCoordinate, validator);
    System.out.println(MESSAGE_INPUT_STOP_COORDINATE);
    String stopCoordinate = inputCoordinate(in, validator);
    inputsCheckerFigure.getStopCoordinate().setCoordinates(stopCoordinate, validator);
    return inputsCheckerFigure;
  }


  /**
   * Inputs checker's type.
   *
   * @param in variable for console inputs.
   * @param validator contains methods for validate setted variables.
   * @return String - inputs checker's type(white or black).
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  private String inputType(Scanner in, CheckerValidator validator) throws NumberInputsException {
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
          throw new NumberInputsException(MESSAGE_INCORRECT_INPUT + errorCounter);
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
   * @param validator contains methods for validate setted variables.
   * @return String - inputs checker's coordinate.
   * @throws NumberInputsException if number incorrect user's inputs more then maximal number.
   */
  private String inputCoordinate(Scanner in, CheckerValidator validator)
      throws NumberInputsException {
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
          throw new NumberInputsException(MESSAGE_INCORRECT_INPUT + errorCounter);
        }
        System.out.println(ex.getMessage());
        System.out.print(MESSAGE_INPUT_CORRECT_COORDINATE);
      }
    }
    return coordinate;
  }
}