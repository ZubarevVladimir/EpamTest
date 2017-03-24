package com.github.zubarevladimir.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains method for get path.
 */
public class Path {

  /**
   * Get path in given string according to given type.
   *
   * @param configFileName string, contains information about path.
   * @param typePath "input" or "output" type.
   * @return String - path according to given type.
   */
  public String getPath(String configFileName, String typePath) {
    String path = "";
    Pattern p = Pattern.compile("[\"].*[\"]");
    for (String str : configFileName.split("([\n])")) {
      if (str.contains(":") && str.split("[:][ ]")[0].contains(typePath.toLowerCase())) {
        Matcher m = p.matcher(str.split("[:][ ]")[1]);
        if (m.find()) {
          path = m.group().replaceAll("\"", "");
        }
      }
    }
    return path;
  }
}
