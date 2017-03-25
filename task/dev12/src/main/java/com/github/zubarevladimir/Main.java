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
      CheckerFigureInputer inputer = new CheckerFigureInputer();
      CheckerValidator validator = new CheckerValidator();
      CheckerFigure checkerFigure = inputer.CheckerInput(validator);
      System.out.printf("Necessary number moves: %s", checkerFigure.calculateNumberMove());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
