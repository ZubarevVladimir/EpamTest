package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class ZZZDatePatternTest {

  private ZZZDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.getTimeZone().setID("GMT+01:00");
    pattern = new ZZZDatePattern(calendar);
  }

  @Test
  public void getResult() throws Exception {
    assertEquals("+01:00", pattern.getResult());
  }

}