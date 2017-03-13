package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class YYYDatePatternTest {

  private YYYDatePattern patternA;
  private YYYDatePattern patternB;

  @Before
  public void setUp() throws Exception {
    Calendar calendarA = Calendar.getInstance();
    calendarA.set(Calendar.YEAR, 1070);
    patternA = new YYYDatePattern(calendarA);
    Calendar calendarB = Calendar.getInstance();
    calendarB.set(Calendar.YEAR, 1970);
    patternB = new YYYDatePattern(calendarB);
  }

  @Test
  public void getResultShouldGet070IfTake1070() throws Exception {
    assertEquals("070", patternA.getResult());
  }

  @Test
  public void getResultShouldGet970IfTake1970() throws Exception {
    assertEquals("970", patternB.getResult());
  }

}