package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class MMinutesDatePatternTest {

  private MMinutesDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MINUTE, 2);
    pattern = new MMinutesDatePattern(calendar);
  }

  @Test
  public void getResultShouldGet2IfMinutes2() throws Exception {

    assertEquals("2", pattern.getResult());
  }
}