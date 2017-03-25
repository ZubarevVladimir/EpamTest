package com.github.zubarevladimir.CheckerFigure;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Validator.CheckerValidator;
import org.junit.Before;
import org.junit.Test;

public class BlackCheckerTest {

  CheckerFigure blackCheckerH8G1;
  CheckerFigure blackCheckerG7F8;
  CheckerFigure blackCheckerH8F8;
  CheckerValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new CheckerValidator();
    blackCheckerH8G1 = new BlackChecker();
    blackCheckerH8G1.getStartCoordinate().setCoordinates("h8", validator);
    blackCheckerH8G1.getStopCoordinate().setCoordinates("g1", validator);
    blackCheckerH8F8 = new BlackChecker();
    blackCheckerH8F8.getStartCoordinate().setCoordinates("h8", validator);
    blackCheckerH8F8.getStopCoordinate().setCoordinates("f8", validator);
    blackCheckerG7F8 = new BlackChecker();
    blackCheckerG7F8.getStartCoordinate().setCoordinates("g7", validator);
    blackCheckerG7F8.getStopCoordinate().setCoordinates("f8", validator);
  }

  @Test
  public void calculateNumberStepsShouldGet7IfBlackH8G1() throws Exception {
    assertEquals(7, blackCheckerH8G1.calculateNumberSteps());
  }

  @Test(expected = IllegalCheckersMoveException.class)
  public void calculateNumberStepsShouldGetExceptionIfBlackH8F8() throws Exception {
    blackCheckerH8F8.calculateNumberSteps();
  }

  @Test(expected = IllegalCheckersMoveException.class)
  public void calculateNumberStepsShouldGetExceptionIfBlackG7F8() throws Exception {
    blackCheckerG7F8.calculateNumberSteps();
  }
}