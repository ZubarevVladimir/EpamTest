package com.github.zubarevladimir;

import com.github.zubarevladimir.CheckerFigure.CheckerFigure;
import com.github.zubarevladimir.CheckerFigureInputer.CheckerFigureInputer;
import com.github.zubarevladimir.Validator.CheckerValidator;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point method.
   * @param args not used parameter.
   */
  public static void main(String[] args) {
    try {
      int maximalNumberIncorrectInputs = 5;
      CheckerValidator validator = new CheckerValidator();
      CheckerFigureInputer inputer = new CheckerFigureInputer(validator);
      CheckerFigure checkerFigure = inputer.CheckerInput(maximalNumberIncorrectInputs);
      System.out.printf("Necessary steps: %s", checkerFigure.calculateNumberSteps());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
