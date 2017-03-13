package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class FFFNotZeroDatePatternTest {

  private FFFNotZeroDatePattern patternA;
  private FFFNotZeroDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.MILLISECOND, 654);
    patternA = new FFFNotZeroDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.MILLISECOND, 0);
    patternB = new FFFNotZeroDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet654IfMilliseconds654() throws Exception {
    assertEquals("654", patternA.getResult());
  }

  @Test
  public void getResultShouldGetNothingIfMilliseconds0() throws Exception {
    assertEquals("", patternB.getResult());
  }

}