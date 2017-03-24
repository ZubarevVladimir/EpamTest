package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class YYDatePatternTest {

  private YYDatePattern patternA;
  private YYDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.YEAR, 1970);
    patternA = new YYDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.YEAR, 1907);
    patternB = new YYDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet70IfYear1970() throws Exception {
    assertEquals("70", patternA.getResult());
  }

  @Test
  public void getResultShouldGet07IfYear1907() throws Exception {
    assertEquals("07", patternB.getResult());
  }

}