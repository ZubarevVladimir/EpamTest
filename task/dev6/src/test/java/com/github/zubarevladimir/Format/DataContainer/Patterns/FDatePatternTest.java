package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class FDatePatternTest {

  private FDatePattern patternA;
  private FDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.MILLISECOND, 7654);
    patternA = new FDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.MILLISECOND, 0);
    patternB = new FDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGetGet6IfMilliseconds654() throws Exception {
    assertEquals("6", patternA.getResult());
  }

  @Test
  public void getResultShouldGetGet0IfMilliseconds065() throws Exception {
    assertEquals("0", patternB.getResult());
  }
}