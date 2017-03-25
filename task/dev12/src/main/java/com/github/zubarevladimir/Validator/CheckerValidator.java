package com.github.zubarevladimir.Validator;

/**
 * Contains methods for validate variables class Checker.
 */
public class CheckerValidator {

  private final String MESSAGE_INCORRECT_COORDINATE = "Incorrect checker's coordinate: ";
  private final String MESSAGE_INCORRECT_TYPE = "Incorrect checker's coordinate: ";
  private final String TYPE_WHITE = "white";
  private final String TYPE_BLACK = "black";
  private final String FIRST_REGEX_FOR_COORDINATE = "(?iu)([aceg][1357])";
  private final String SECOND_REGEX_FOR_COORDINATE = "(?iu)[bdfh][2468]";

  /**
   * Validate given checker's type.
   *
   * @param type validated type.
   * @return boolean true - if given type match checker's type.
   * @throws IllegalArgumentException if get incorrect argument.
   */
  public boolean validateType(String type) throws IllegalArgumentException {

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
   * @throws IllegalArgumentException if get incorrect argument.
   */
  public boolean validateCoordinate(String coordinate) throws IllegalArgumentException {
    if (coordinate.matches(FIRST_REGEX_FOR_COORDINATE) || coordinate
        .matches(SECOND_REGEX_FOR_COORDINATE)) {
      return true;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + coordinate);
    }
  }

}
