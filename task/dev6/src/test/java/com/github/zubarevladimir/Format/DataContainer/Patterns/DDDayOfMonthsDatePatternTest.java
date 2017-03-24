package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class DDDayOfMonthsDatePatternTest {

  private DDDayOfMonthsDatePattern patternA;
  private DDDayOfMonthsDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.DAY_OF_MONTH, 1);
    patternA = new DDDayOfMonthsDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.DAY_OF_MONTH, 11);
    patternB = new DDDayOfMonthsDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet01IfDay1() throws Exception {
    assertEquals("01", patternA.getResult());
  }

  @Test
  public void getResultShouldGet11IfDay11() throws Exception {
    assertEquals("11", patternB.getResult());
  }
}