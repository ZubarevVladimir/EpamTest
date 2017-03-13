package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class YYYYDatePatternTest {

  private YYYYDatePattern patternA;
  private YYYYDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.YEAR, 1970);
    patternA = new YYYYDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.YEAR, 970);
    patternB = new YYYYDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet1970IfYear1970() throws Exception {
    assertEquals("1970", patternA.getResult());
  }

  @Test
  public void getResultShouldGet0970IfYear970() throws Exception {
    assertEquals("0970", patternB.getResult());
  }


}