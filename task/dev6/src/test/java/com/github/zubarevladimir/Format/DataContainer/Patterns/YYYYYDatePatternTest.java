package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class YYYYYDatePatternTest {

  private YYYYYDatePattern patternA;
  private YYYYYDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.YEAR, 1970);
    patternA = new YYYYYDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.YEAR, 21970);
    patternB = new YYYYYDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet01970IfYear1970() throws Exception {
    assertEquals("01970", patternA.getResult());
  }
  @Test
  public void getResultShouldGet21970IfYear21970() throws Exception {
    assertEquals("21970", patternB.getResult());
  }
}