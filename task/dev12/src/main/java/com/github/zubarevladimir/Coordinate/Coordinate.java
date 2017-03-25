package com.github.zubarevladimir.Coordinate;

import com.github.zubarevladimir.Validator.CheckerValidator;

public class Coordinate {

  private String coordinate;
  private int xCoordinate;
  private int yCoordinate;
  private String MESSAGE_INCORRECT_COORDINATE = "Incorrect checker's coordinate: ";

  private enum Coordinates {
    A, B, C, D, E, F, G, H
  }

  /**
   * Set X and Y coordinates according to given string coordinates.
   *
   * @param stringCoordinate coordinate, contains x and y coordinates.
   * @param validator contains methods for validate setted variables.
   * @throws IllegalArgumentException if get incorrect argument.
   */
  public void setCoordinates(String stringCoordinate, CheckerValidator validator)
      throws IllegalArgumentException {
    if (validator.validateCoordinate(stringCoordinate)) {
      coordinate = stringCoordinate;
      xCoordinate = getXCoordinate(stringCoordinate);
      yCoordinate = getYCoordinate(stringCoordinate);
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + stringCoordinate);
    }
  }

  /**
   * Get Y coordinate from string coordinate.
   * For example (H7, B4)->(7, 4).
   *
   * @param coordinates string coordinate, contains x and y coordinates.
   * @return int - Y numerical coordinate.
   */
  private int getYCoordinate(String coordinates) {
    return Integer.parseInt(coordinates.substring(1));
  }

  /**
   * Get X coordinate from string coordinate.
   * For example (H7, B4)->(8, 2).
   *
   * @param coordinates string coordinate, contains x and y coordinates.
   * @return int - X numerical coordinate.
   */
  private int getXCoordinate(String coordinates) {
    int coordinate = 0;
    for (int i = 0; i < Coordinates.values().length; i++) {
      if (coordinates.substring(0, 1).equals(Coordinates.values()[i].name())) {
        coordinate = i + 1;
      }
    }
    return coordinate;
  }

  public String getCoordinate() {
    return coordinate;
  }

  public int getYCoordinate() {
    return yCoordinate;
  }

  public int getXCoordinate() {
    return xCoordinate;
  }
}
