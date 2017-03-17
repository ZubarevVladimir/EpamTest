package com.github.zubarevladimir.Validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckerValidatorTest {

  private CheckerValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new CheckerValidator();
  }

  @Test
  public void validateTypeShouldGetTrueIfTypeWhite() throws Exception {
    assertTrue(validator.validateType("white"));
  }

  @Test
  public void validateTypeShouldGetTrueIfTypeBlack() throws Exception {
    assertTrue(validator.validateType("black"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateTypeShouldGetExceptionIfTypeNumber() throws Exception {
    validator.validateType("1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateTypeShouldGetExceptionIfTypeSpecialSymbols() throws Exception {
    validator.validateType("!@#$%");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateTypeShouldGetExceptionIfTypeFloat() throws Exception {
    validator.validateType("1.5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateTypeShouldGetExceptionIfTypeSeparateSymbol() throws Exception {
    validator.validateType("w");
  }

  @Test
  public void validateCoordinateShouldGetTrueIfCoordinateA1() throws Exception {
    assertTrue(validator.validateCoordinate("a1"));
  }

  @Test
  public void validateCoordinateShouldGetTrueIfCoordinateB2() throws Exception {
    assertTrue(validator.validateCoordinate("b2"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateA2() throws Exception {
    validator.validateCoordinate("a2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateB1() throws Exception {
    validator.validateCoordinate("b1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateNumber() throws Exception {
    validator.validateCoordinate("1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateSpecialSymbols() throws Exception {
    validator.validateCoordinate("!@#$%");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateFloat() throws Exception {
    validator.validateCoordinate("1.5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateCoordinateShouldGetExceptionIfCoordinateSeparateSymbol() throws Exception {
    validator.validateCoordinate("w");
  }

}