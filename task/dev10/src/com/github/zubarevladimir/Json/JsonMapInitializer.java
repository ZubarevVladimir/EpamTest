package com.github.zubarevladimir.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains method for initialize map according to string.
 */
public class JsonMapInitializer {

  /**
   * Initialize map, contains json string variables.
   *
   * @param text contains text in json file.
   * @return Map contains json variables
   * @throws Exception if given string doesn't match json file.
   */
  public Map<String, List<Map<String, String>>> jsonMap(String text) throws Exception {
    try {
      Map<String, List<Map<String, String>>> mainMap = new LinkedHashMap<>();
      String mainKey = "";
      String atribut;
      String localKey;
      boolean normal = true;
      int index = -1;
      for (String line : text.split("([\n])")) {
        if (line.contains("[")) {
          mainKey = line.split("[:][ ]")[0].replaceAll("^[ ]*", "");
          List<Map<String, String>> atributList = new ArrayList<>();
          mainMap.put(mainKey, atributList);
          normal = false;
        } else if (line.contains("]")) {
          index = -1;
          normal = true;
        } else if (!normal) {
          if (line.contains("{")) {
            index++;
            Map<String, String> localAtributMap = new LinkedHashMap<>();
            mainMap.get(mainKey).add(index, localAtributMap);
            mainMap.put(mainKey, mainMap.get(mainKey));
          } else {
            if (line.contains(":")) {
              localKey = line.split("[:][ ]")[0].replaceAll("^[ ]*", "");
              atribut = line.split("[:][ ]")[1];
              mainMap.get(mainKey).get(index).put(localKey, atribut);
              mainMap.put(mainKey, mainMap.get(mainKey));
            }
          }
        } else if (normal && line.contains(":")) {
          List<Map<String, String>> atributList = new ArrayList<>();
          Map<String, String> localAtributMap = new HashMap<>();
          mainKey = line.split("[:][ ]")[0].replaceAll("^[ ]*", "");
          atribut = line.split("[:][ ]")[1];
          localAtributMap.put("", atribut);
          atributList.add(localAtributMap);
          mainMap.put(mainKey, atributList);
        }
      }
      return mainMap;
    } catch (Exception ex) {
      throw new Exception(ex.getMessage());
    }
  }
}