package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Владимир on 12.03.2017.
 */
public class MMMonthDatePatternTest {

  private MMMonthDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    pattern = new MMMonthDatePattern(calendar);
  }

  @Test
  public void getResultShouldGet01IfJanuary() throws Exception {
    assertEquals("01", pattern.getResult());
  }

}