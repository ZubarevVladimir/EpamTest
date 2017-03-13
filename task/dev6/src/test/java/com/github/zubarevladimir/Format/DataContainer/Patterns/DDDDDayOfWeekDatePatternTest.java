package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class DDDDDayOfWeekDatePatternTest {

  private DDDDDayOfWeekDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1970, 0, 1);
    pattern = new DDDDDayOfWeekDatePattern(calendar);
  }

  @Test
  public void getResultShouldGetFridayIfItsFriday() throws Exception {
    assertEquals("Friday", pattern.getResult());
  }
}