package com.github.zubarevladimir.Checker;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Validator.CheckerValidator;

import org.junit.Test;
import org.junit.Before;


public class CheckerTest {

  private CheckerValidator validator;
  private Checker checker;

  @Before
  public void setUp() throws Exception {
    validator = new CheckerValidator();
    checker = new Checker();
  }

  @Test
  public void setTypeWhiteShouldGetWhiteIfSetWhite() throws Exception {
    checker.setType("white", validator);
    assertEquals("white", checker.getType());
  }

  @Test
  public void setTypeShouldGetBlackIfSetBlack() throws Exception {
    checker.setType("black", validator);
    assertEquals("black", checker.getType());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setTypeShouldThrowExceptionForEmptyString() throws Exception {
    checker.setType("", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setTypeShouldThrowExceptionForNumbers() throws Exception {
    checker.setType("123", validator);
  }

  @Test
  public void setStartCoordinateShouldGetA1IfCoordinateA1() throws Exception {
    checker.setStartCoordinate("a1", validator);
    assertEquals("a1", checker.getStartCoordinate());
  }

  @Test
  public void setStartCoordinateShouldGetA1IfCoordinateB2() throws Exception {
    checker.setStartCoordinate("b2", validator);
    assertEquals("b2", checker.getStartCoordinate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateB1() throws Exception {
    checker.setStartCoordinate("b1", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateMoreThanMaximal() throws Exception {
    checker.setStartCoordinate("a9", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateSpecialSymbols() throws Exception {
    checker.setStopCoordinate("!@#$%^&*", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateFloatParameter() throws Exception {
    checker.setStopCoordinate("1.5", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateOnlyLetters() throws Exception {
    checker.setStopCoordinate("aa", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStartShouldThrowExceptionIfCoordinateNegativeCoordinate() throws Exception {
    checker.setStopCoordinate("a-4", validator);
  }

  @Test
  public void setStopCoordinateShouldGetA1IfCoordinateA1() throws Exception {
    checker.setStopCoordinate("a1", validator);
    assertEquals("a1", checker.getStopCoordinate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateB1() throws Exception {
    checker.setStopCoordinate("b1", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateMoreThanMaximal() throws Exception {
    checker.setStopCoordinate("a9", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateSpecialSymbols() throws Exception {
    checker.setStopCoordinate("!@#$%^&*", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateFloatParameter() throws Exception {
    checker.setStopCoordinate("1.5", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateOnlyLetters() throws Exception {
    checker.setStopCoordinate("aa", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setStopShouldThrowExceptionIfCoordinateNegativeCoordinate() throws Exception {
    checker.setStopCoordinate("a-4", validator);
  }


}