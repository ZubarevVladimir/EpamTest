package com.github.zubarevladimir.Validator;

/**
 * Contains methods for validate variables class Checker.
 */
public class CheckerValidator {

  /**
   * Validate given checker's type.
   *
   * @param type validated type.
   * @return boolean true - if given type match checker's type.
   */
  public boolean validateType(String type)  {
    final String TYPE_WHITE = "white";
    final String TYPE_BLACK = "black";
    return (type.toLowerCase().equals(TYPE_WHITE) || type.toLowerCase().equals(TYPE_BLACK));
  }

  /**
   * Validate given checker's coordinate.
   *
   * @param coordinate validated coordinate.
   * @return boolean true - if given coordinate match checker's coordinate.
   */
  public boolean validateCoordinate(String coordinate) {
    return (coordinate.matches("(?iu)([aceg][1357])") || coordinate.matches("(?iu)[bdfh][2468]"));
  }

  /**
   * Validate given checker's coordinate.
   *
   * @param coordinate validated coordinate.
   * @return boolean true - if given coordinate match checker's coordinate.
   */
  public boolean validateCoordinate(int coordinate) {
    final int maxCoordinate = 8;
    final int minCoordinate = 1;
    return (coordinate <= maxCoordinate && coordinate >= minCoordinate);
  }
}
