package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class HHFullDatePatternTest {

  private HHFullDatePattern patternA;
  private HHFullDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.HOUR_OF_DAY, 15);
    patternA = new HHFullDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.HOUR_OF_DAY, 5);
    patternB = new HHFullDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet15IfHour15() throws Exception {
    assertEquals("15", patternA.getResult());
  }

  @Test
  public void getResultShouldGet05IfHour5() throws Exception {
    assertEquals("05", patternB.getResult());
  }
}