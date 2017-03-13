package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class SDatePatternTest {

  private SDatePattern patternA;
  private SDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.SECOND, 3);
    patternA = new SDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.SECOND, 33);
    patternB = new SDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet3IfSeconds3() throws Exception {
    assertEquals("3", patternA.getResult());
  }

  @Test
  public void getResultShouldGet33IfSeconds33() throws Exception {
    assertEquals("33", patternB.getResult());
  }
}