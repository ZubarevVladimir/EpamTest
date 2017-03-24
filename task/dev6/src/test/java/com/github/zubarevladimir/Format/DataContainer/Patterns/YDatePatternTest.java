package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class YDatePatternTest {

  private YDatePattern patternA;
  private YDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.YEAR, 1970);
    patternA = new YDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.YEAR, 1907);
    patternB = new YDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet70IfYear1970() throws Exception {
    assertEquals("70", patternA.getResult());
  }

  @Test
  public void getResultShouldGet7IfYear1907() throws Exception {
    assertEquals("7", patternB.getResult());
  }

}