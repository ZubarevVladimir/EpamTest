package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class FNotZeroDatePatternTest {

  private FNotZeroDatePattern patternA;
  private FNotZeroDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.MILLISECOND, 654);
    patternA = new FNotZeroDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.MILLISECOND, 0);
    patternB = new FNotZeroDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet6IfMilliseconds654() throws Exception {
    assertEquals("6", patternA.getResult());
  }

  @Test
  public void getResultgfShouldGetNothingIfMilliseconds0() throws Exception {
    assertEquals("", patternB.getResult());
  }
}