package com.github.zubarevladimir;

import com.github.zubarevladimir.Checker.CalculateNumberMove;
import com.github.zubarevladimir.Checker.Checker;
import com.github.zubarevladimir.Checker.InputChecker;
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
      CheckerValidator validator = new CheckerValidator();
      Checker checker = new Checker();
      InputChecker setter = new InputChecker();
      setter.setInputsCoordinates(checker,validator);
      CalculateNumberMove counter = new CalculateNumberMove();
      System.out.printf("Necessary number moves: %s", counter.getNumberMove(checker));
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}
