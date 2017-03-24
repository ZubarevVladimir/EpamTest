package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class MMMMonthDatePatternTest {

  private MMMMonthDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    pattern = new MMMMonthDatePattern(calendar);
  }

  @Test
  public void getResultShouldGetJanIfJanuary() throws Exception {
    assertEquals("Jan", pattern.getResult());
  }
}