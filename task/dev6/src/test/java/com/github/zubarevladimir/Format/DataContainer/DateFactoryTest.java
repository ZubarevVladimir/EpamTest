package com.github.zubarevladimir.Format.DataContainer;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;


public class DateFactoryTest {

  Calendar calendar;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
  }

  @Test
  public void createMapOfPatternsGetMapSize() throws Exception {
    DateFactory factory = new DateFactory();
    assertEquals(32, factory.createMapOfPatterns(calendar).size());
  }

  @Test
  public void createMapOfPatternsGetMapSizeNotNull() throws Exception {
    DateFactory factory = new DateFactory();
    assertNotNull(factory.createMapOfPatterns(calendar));
  }

}