package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class GDatePatternTest {

  private GDatePattern patternA;
  private GDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.ERA, 1);
    patternA = new GDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.ERA, 0);
    patternB = new GDatePattern(calendarB);
  }

  @Test
  public void getResultSholdGetAIfEraAD() throws Exception {
    assertEquals("A", patternA.getResult());
  }

  @Test
  public void getResultSholdGetBfEraBD() throws Exception {
    assertEquals("B", patternB.getResult());
  }
}