package com.github.zubarevladimir.Format;

import static org.junit.Assert.*;

import com.github.zubarevladimir.Format.DataContainer.DateFactory;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class FormatDataTest {

  private Calendar calendar;
  private FormatData formater;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    formater = new FormatData();
    calendar.set(1970, 0, 1, 15, 2, 3);
    calendar.set(Calendar.MILLISECOND, 303);
  }

  @Test
  public void formatDateToUserFormatGetSimpleCombineFormat() throws Exception {
    assertEquals("January/Friday/1970/70 15:03:02:2:3:03",
        formater.formatDateToUserFormat("MMMM/DDDD/yyyy/y HH:hh:mm:m:s:cc", calendar));
  }

  @Test
  public void formatDateToUserFormatGetFormatMonths() throws Exception {
    assertEquals("January/Jan/01/1",
        formater.formatDateToUserFormat("MMMM/MMM/MM/M", calendar));
  }

  @Test
  public void formatDateToUserFormatGetFormatDays() throws Exception {
    assertEquals("Friday/FRI/01/1",
        formater.formatDateToUserFormat("DDDD/DDD/DD/D", calendar));
  }

  @Test
  public void formatDateToUserFormatGetFormatYears() throws Exception {
    assertEquals("01970/1970/970/70/70",
        formater.formatDateToUserFormat("yyyyy/yyyy/yyy/yy/y", calendar));
  }

  @Test
  public void formatDateToUserFormatGetFormatTime() throws Exception {
    assertEquals("15:15:03:3:02:2:3:03",
        formater.formatDateToUserFormat("HH:H:hh:h:mm:m:s:cc", calendar));
  }

  @Test
  public void formatDateToUserFormatGetFormatMiliseconds() throws Exception {
    assertEquals("303:30:3:303:30:3",
        formater.formatDateToUserFormat("FFF:FF:F:fff:ff:f", calendar));
  }

}