package com.github.zubarevladimir.Validator;

/**
 * Contains methods for validate variables class Checker.
 */
public class CheckerValidator {

  private final String MESSAGE_INCORRECT_COORDINATE = "Incorrect checker's coordinate: ";
  private final String MESSAGE_INCORRECT_TYPE = "Incorrect checker's coordinate: ";

  /**
   * Validate given checker's type.
   *
   * @param type validated type.
   * @return boolean true - if given type match checker's type.
   */
  public boolean validateType(String type) throws IllegalArgumentException {
    final String TYPE_WHITE = "white";
    final String TYPE_BLACK = "black";

    if (type.toLowerCase().equals(TYPE_WHITE) || type.toLowerCase().equals(TYPE_BLACK)) {
      return true;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_TYPE + type);
    }
  }

  /**
   * Validate given checker's coordinate.
   *
   * @param coordinate validated coordinate.
   * @return boolean true - if given coordinate match checker's coordinate.
   */
  public boolean validateCoordinate(String coordinate) throws IllegalArgumentException {
    if (coordinate.matches("(?iu)([aceg][1357])") || coordinate.matches("(?iu)[bdfh][2468]")) {
      return true;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + coordinate);
    }
  }
}
