package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class DDDDayOfWeekDatePatternTest {

  private DDDDayOfWeekDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1970, 0, 1);
    pattern = new DDDDayOfWeekDatePattern(calendar);
  }

  @Test
  public void getResultShouldGetFRIIfItsFriday() throws Exception {
    assertEquals("FRI", pattern.getResult());
  }
}