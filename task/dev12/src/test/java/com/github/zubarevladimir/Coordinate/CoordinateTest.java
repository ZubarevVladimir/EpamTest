package com.github.zubarevladimir.Coordinate;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Validator.CheckerValidator;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

  Coordinate coordinateA1;
  Coordinate coordinateB4;
  Coordinate incorrectCoordinate;
  CheckerValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new CheckerValidator();
    coordinateA1 = new Coordinate();
    coordinateA1.setCoordinates("a3",validator);
    coordinateB4 = new Coordinate();
    coordinateB4.setCoordinates("b4",validator);
    incorrectCoordinate = new Coordinate();
  }

  @Test
  public void setCoordinatesShouldGet1IfA3() throws Exception {
    assertEquals(1, coordinateA1.getXCoordinate());
  }

  @Test
  public void setCoordinatesShouldGet3IfA3() throws Exception {
    assertEquals(3,coordinateA1.getYCoordinate());
  }

  @Test
  public void setCoordinatesShouldGet2IfB4() throws Exception {
    assertEquals(2, coordinateB4.getXCoordinate());
  }

  @Test
  public void setCoordinatesShouldGet4IfB4() throws Exception {
    assertEquals(4,coordinateB4.getYCoordinate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCoordinatesShouldGetExceptionIfA0() throws Exception {
    incorrectCoordinate.setCoordinates("a0", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCoordinatesShouldGetExceptionIfA9() throws Exception {
    incorrectCoordinate.setCoordinates("a9", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCoordinatesShouldGetExceptionIfI3() throws Exception {
    incorrectCoordinate.setCoordinates("i3", validator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCoordinatesShouldGetExceptionIfA2() throws Exception {
    incorrectCoordinate.setCoordinates("a2", validator);
  }
}