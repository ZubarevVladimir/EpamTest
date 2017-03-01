package com.github.zubarevladimir.Format;

import com.github.zubarevladimir.Format.DateContainer.DateVariables;
import java.util.*;

/**
 * Contains formating methods.
 */
public class FormatData {

  /**
   * Formats date according to given format.
   *
   * @param userDateFormat format entered by user.
   * @return String - date in given format.
   */
  public String doDateFormat(String userDateFormat) {
    DateVariables data = new DateVariables();
    Map<String, String> dateMap = data.getDateVariables();
    userDateFormat = formatDateToUserFormat(dateMap, userDateFormat);
    return userDateFormat;
  }

  /**
   * Replace format abbreviation to date value.
   *
   * @param dateMap date and time variables container.
   * @param userDateFormat format entered by user.
   * @return String - date in given format.
   */
  private String formatDateToUserFormat(Map<String, String> dateMap, String userDateFormat) {
    userDateFormat = userDateFormat.replaceAll("[f]", dateMap.get("f"));
    userDateFormat = userDateFormat.replaceAll("[F]", dateMap.get("F"));
    userDateFormat = userDateFormat.replaceAll("[s]", dateMap.get("s"));
    userDateFormat = userDateFormat.replaceAll("[c]{2}", dateMap.get("cc"));
    userDateFormat = userDateFormat.replaceAll("[K]", dateMap.get("K"));

    userDateFormat = userDateFormat.replaceAll("[m]{2}", dateMap.get("mm"));
    userDateFormat = userDateFormat.replaceAll("[m]", dateMap.get("m"));

    userDateFormat = userDateFormat.replaceAll("[H]{2}", dateMap.get("HH"));
    userDateFormat = userDateFormat.replaceAll("[h]{2}", dateMap.get("hh"));
    userDateFormat = userDateFormat.replaceAll("[H]", dateMap.get("H"));
    userDateFormat = userDateFormat.replaceAll("[h]", dateMap.get("h"));

    userDateFormat = userDateFormat.replaceAll("[y]{5}", dateMap.get("yyyyy"));
    userDateFormat = userDateFormat.replaceAll("[y]{4}", dateMap.get("yyyy"));
    userDateFormat = userDateFormat.replaceAll("[y]{3}", dateMap.get("yyy"));
    userDateFormat = userDateFormat.replaceAll("[y]{2}", dateMap.get("yy"));
    userDateFormat = userDateFormat.replaceAll("[y]", dateMap.get("y"));

    userDateFormat = userDateFormat.replaceAll("[z]{3}", dateMap.get("zzz"));
    userDateFormat = userDateFormat.replaceAll("[z]{2}", dateMap.get("zz"));
    userDateFormat = userDateFormat.replaceAll("[z]", dateMap.get("z"));

    userDateFormat = userDateFormat.replaceAll("[M]{4}", dateMap.get("MMMM"));
    userDateFormat = userDateFormat.replaceAll("[M]{3}", dateMap.get("MMM"));
    userDateFormat = userDateFormat.replaceAll("[M]{2}", dateMap.get("MM"));
    userDateFormat = userDateFormat.replaceAll("[M]", dateMap.get("M"));

    userDateFormat = userDateFormat.replaceAll("[d]{4}", dateMap.get("dddd"));
    userDateFormat = userDateFormat.replaceAll("[d]{3}", dateMap.get("ddd"));
    userDateFormat = userDateFormat.replaceAll("[d]{2}", dateMap.get("dd"));
    userDateFormat = userDateFormat.replaceAll("[ ][d][ ]", " " + dateMap.get("d") + " ");
    userDateFormat = userDateFormat.replaceAll("[\\W][d]", "/" + dateMap.get("d"));
    userDateFormat = userDateFormat.replaceAll("[d][\\W]", dateMap.get("d") + "/");

    userDateFormat = userDateFormat.replaceAll("[t]{2}", dateMap.get("tt"));
    userDateFormat = userDateFormat.replaceAll("[ ][t][ ]", " " + dateMap.get("t") + " ");
    userDateFormat = userDateFormat.replaceAll("[\\W][t]", ":" + dateMap.get("t"));
    userDateFormat = userDateFormat.replaceAll("[\\W][t][\\W]", ":"+dateMap.get("t") + ":");
    return userDateFormat;
  }
}