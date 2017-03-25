package com.github.zubarevladimir.CheckerFigure;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Validator.CheckerValidator;
import org.junit.Before;
import org.junit.Test;

public class WhiteCheckerTest {

  CheckerFigure whiteCheckerA1B8;
  CheckerFigure whiteCheckerA1C1;
  CheckerFigure whiteCheckerB2C1;
  CheckerValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new CheckerValidator();
    whiteCheckerA1B8 = new WhiteChecker();
    whiteCheckerA1B8.getStartCoordinate().setCoordinates("a1", validator);
    whiteCheckerA1B8.getStopCoordinate().setCoordinates("b8", validator);
    whiteCheckerA1C1 = new WhiteChecker();
    whiteCheckerA1C1.getStartCoordinate().setCoordinates("a1", validator);
    whiteCheckerA1C1.getStopCoordinate().setCoordinates("c1", validator);
    whiteCheckerB2C1 = new WhiteChecker();
    whiteCheckerB2C1.getStartCoordinate().setCoordinates("b2", validator);
    whiteCheckerB2C1.getStopCoordinate().setCoordinates("c1", validator);
  }

  @Test
  public void calculateNumberStepsShouldGet7IfWhiteA1B8() throws Exception {
    assertEquals(7, whiteCheckerA1B8.calculateNumberSteps());
  }

  @Test(expected = IllegalCheckersMoveException.class)
  public void calculateNumberStepsShouldGetExceptionIfWhiteA1C1() throws Exception {
    whiteCheckerA1C1.calculateNumberSteps();
  }

  @Test(expected = IllegalCheckersMoveException.class)
  public void calculateNumberStepsShouldGetExceptionIfWhiteB2C1() throws Exception {
    whiteCheckerB2C1.calculateNumberSteps();
  }

}