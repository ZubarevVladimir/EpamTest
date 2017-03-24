package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class MMMMMonthsDatePatternTest {

  private MMMMMonthsDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    pattern = new MMMMMonthsDatePattern(calendar);
  }

  @Test
  public void getResultShouldGetJanuaryIfJanuary() throws Exception {
    assertEquals("January", pattern.getResult());
  }
}