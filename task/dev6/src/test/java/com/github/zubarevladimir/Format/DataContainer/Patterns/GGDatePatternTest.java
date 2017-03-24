package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class GGDatePatternTest {

  private GGDatePattern patternA;
  private GGDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.ERA, 1);
    patternA = new GGDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.ERA, 0);
    patternB = new GGDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGetADfEraAD() throws Exception {
    assertEquals("AD", patternA.getResult());
  }

  @Test
  public void getResultShouldGetBDfEraAD() throws Exception {
    assertEquals("BD", patternB.getResult());
  }

}