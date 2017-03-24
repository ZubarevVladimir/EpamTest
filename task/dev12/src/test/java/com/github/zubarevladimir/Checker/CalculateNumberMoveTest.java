package com.github.zubarevladimir.Checker;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Checker.DoingWithCheckers.CalculateNumberMove;
import com.github.zubarevladimir.Validator.CheckerValidator;
import org.junit.Before;
import org.junit.Test;

public class CalculateNumberMoveTest {

  private CalculateNumberMove calculator;
  private Checker checkerOne;
  private Checker checkerTwo;
  private Checker checkerThree;
  private Checker checkerFour;
  private Checker checkerFive;
  private Checker checkerSix;

  @Before
  public void setUp() throws Exception {
    CheckerValidator validator = new CheckerValidator();
    calculator = new CalculateNumberMove();
    checkerOne = new Checker();
    checkerOne.setType("white", validator);
    checkerOne.setStartCoordinate("a1", validator);
    checkerOne.setStopCoordinate("b8", validator);
    checkerTwo = new Checker();
    checkerTwo.setType("black", validator);
    checkerTwo.setStartCoordinate("h8", validator);
    checkerTwo.setStopCoordinate("g1", validator);
    checkerThree = new Checker();
    checkerThree.setType("white", validator);
    checkerThree.setStartCoordinate("a1", validator);
    checkerThree.setStopCoordinate("c1", validator);
    checkerFour = new Checker();
    checkerFour.setType("white", validator);
    checkerFour.setStartCoordinate("b2", validator);
    checkerFour.setStopCoordinate("c1", validator);
    checkerFive = new Checker();
    checkerFive.setType("black", validator);
    checkerFive.setStartCoordinate("h8", validator);
    checkerFive.setStopCoordinate("f8", validator);
    checkerSix = new Checker();
    checkerSix.setType("black", validator);
    checkerSix.setStartCoordinate("g7", validator);
    checkerSix.setStopCoordinate("f8", validator);
  }

  @Test
  public void getNumberMoveShouldGet1IfWhiteA1B8() throws Exception {
    assertEquals(7, calculator.getNumberMove(checkerOne));
  }

  @Test
  public void getNumberMoveShouldGet1IfBlackH8G1() throws Exception {
    assertEquals(7, calculator.getNumberMove(checkerTwo));
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumberMoveShouldGetExceptionIfWhiteA1C1() throws Exception {
    calculator.getNumberMove(checkerThree);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumberMoveShouldGetExceptionIfWhiteB2C1() throws Exception {
    calculator.getNumberMove(checkerFour);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumberMoveShouldGetExceptionIfBlackH8F8() throws Exception {
    calculator.getNumberMove(checkerFive);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumberMoveShouldGetExceptionIfBlackG7F8() throws Exception {
    calculator.getNumberMove(checkerSix);
  }

}