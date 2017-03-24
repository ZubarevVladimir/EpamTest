package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class CCDatePatternTest {

  private CCDatePattern patternA;
  private CCDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.SECOND, 3);
    patternA = new CCDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.SECOND, 33);
    patternB = new CCDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet03IfSeconds3() throws Exception {
    assertEquals("03", patternA.getResult());
  }

  @Test
  public void getResultShouldGet33IfSeconds33() throws Exception {
    assertEquals("33", patternB.getResult());
  }
}