package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class MMMinutesDatePatternTest {

  private MMMinutesDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MINUTE, 2);
    pattern = new MMMinutesDatePattern(calendar);
  }

  @Test
  public void getResultShouldGet02IfMinutes2() throws Exception {
    assertEquals("02", pattern.getResult());
  }
}