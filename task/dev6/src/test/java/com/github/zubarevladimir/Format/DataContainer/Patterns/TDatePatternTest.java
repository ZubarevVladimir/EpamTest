package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class TDatePatternTest {

  private TDatePattern patternA;
  private TDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.HOUR_OF_DAY, 15);
    patternA = new TDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.HOUR_OF_DAY, 10);
    patternB = new TDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGetPIfHourMoreThan12() throws Exception {
    assertEquals("P", patternA.getResult());
  }

  @Test
  public void getResultShouldGetAIfHourLessThan12() throws Exception {
    assertEquals("A", patternB.getResult());
  }
}