package com.github.zubarevladimir.Format.DataContainer;


import com.github.zubarevladimir.Format.DataContainer.Patterns.*;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Contains method for get current date and time.
 */
public class DateFactory {

  /**
   * Creates map of patterns names and values.
   *
   * @return Map - contains all information about current time and date and linked patterns.
   */
  public Map<String, String> createMapOfPatterns(Calendar date) {
    Map<String, String> patterns = new LinkedHashMap<>();

    patterns.put("DDDD", new DDDDDayOfWeekDatePattern(date).getResult());
    patterns.put("DDD", new DDDDayOfWeekDatePattern(date).getResult());
    patterns.put("DD", new DDDayOfMonthsDatePattern(date).getResult());
    patterns.put("D", new DDayOfMonthsDatePattern(date).getResult());

    patterns.put("f", new FDatePattern(date).getResult());
    patterns.put("ff", new FFDatePattern(date).getResult());
    patterns.put("fff", new FFFDatePattern(date).getResult());
    patterns.put("F", new FNotZeroDatePattern(date).getResult());
    patterns.put("FF", new FFNotZeroDatePattern(date).getResult());
    patterns.put("FFF", new FFFNotZeroDatePattern(date).getResult());

    patterns.put("zzz", new ZZZDatePattern(date).getResult());

    patterns.put("G", new GDatePattern(date).getResult());
    patterns.put("GG", new GGDatePattern(date).getResult());

    patterns.put("h", new HDatePattern(date).getResult());
    patterns.put("hh", new HHDatePattern(date).getResult());
    patterns.put("H", new HFullDatePattern(date).getResult());
    patterns.put("HH", new HHFullDatePattern(date).getResult());

    patterns.put("m", new MMinutesDatePattern(date).getResult());
    patterns.put("mm", new MMMinutesDatePattern(date).getResult());

    patterns.put("MM", new MMMonthDatePattern(date).getResult());
    patterns.put("M", new MMonthDatePattern(date).getResult());
    patterns.put("MMM", new MMMMonthDatePattern(date).getResult());
    patterns.put("MMMM", new MMMMMonthsDatePattern(date).getResult());

    patterns.put("s", new SDatePattern(date).getResult());
    patterns.put("cc", new CCDatePattern(date).getResult());

    patterns.put("t", new TDatePattern(date).getResult());
    patterns.put("tt", new TTDatePattern(date).getResult());

    patterns.put("y", new YDatePattern(date).getResult());
    patterns.put("yy", new YYDatePattern(date).getResult());
    patterns.put("yyy", new YYYDatePattern(date).getResult());
    patterns.put("yyyy", new YYYYDatePattern(date).getResult());
    patterns.put("yyyyy", new YYYYYDatePattern(date).getResult());

    return patterns;
  }

}
