package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;


public class HHDatePatternTest {

  private HHDatePattern patternA;
  private HHDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.HOUR_OF_DAY, 15);
    patternA = new HHDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.HOUR_OF_DAY, 5);
    patternB = new HHDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet03IfHour15() throws Exception {
    assertEquals("03", patternA.getResult());
  }

  @Test
  public void getResultShouldGet05IfHour5() throws Exception {
    assertEquals("05", patternB.getResult());
  }
}