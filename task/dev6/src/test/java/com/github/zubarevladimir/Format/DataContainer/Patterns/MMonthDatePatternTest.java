package com.github.zubarevladimir.Format.DataContainer.Patterns;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Владимир on 12.03.2017.
 */
public class MMonthDatePatternTest {

  private MMonthDatePattern pattern;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    pattern = new MMonthDatePattern(calendar);
  }

  @Test
  public void getResultShouldGet1IfJanuary() throws Exception {
    assertEquals("1", pattern.getResult());
  }

}