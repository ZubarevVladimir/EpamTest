package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class TTDatePatternTest {

  private TTDatePattern patternA;
  private TTDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.HOUR_OF_DAY, 15);
    patternA = new TTDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.HOUR_OF_DAY, 10);
    patternB = new TTDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGetPMIfHourMoreThan12() throws Exception {
    assertEquals("PM", patternA.getResult());
  }

  @Test
  public void getResultShouldGetAMIfHourLessThan12() throws Exception {
    assertEquals("AM", patternB.getResult());
  }
}