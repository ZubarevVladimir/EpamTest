package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class FFFDatePatternTest {

  private FFFDatePattern patternA;
  private FFFDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.MILLISECOND, 654);
    patternA = new FFFDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.MILLISECOND, 0);
    patternB = new FFFDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGetGet654IfMilliseconds654() throws Exception {
    assertEquals("654", patternA.getResult());
  }

  @Test
  public void getResultShouldGetGet0IfMilliseconds065() throws Exception {
    assertEquals("000", patternB.getResult());
  }
}