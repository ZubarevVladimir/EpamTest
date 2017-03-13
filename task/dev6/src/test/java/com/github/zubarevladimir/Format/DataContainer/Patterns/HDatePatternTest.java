package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class HDatePatternTest {

  private HDatePattern patternA;
  private HDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.HOUR_OF_DAY, 15);
    patternA = new HDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.HOUR_OF_DAY, 5);
    patternB = new HDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet3IfHour15() throws Exception {
    assertEquals("3", patternA.getResult());
  }

  @Test
  public void getResultShouldGet5IfHour5() throws Exception {
    assertEquals("5", patternB.getResult());
  }
}