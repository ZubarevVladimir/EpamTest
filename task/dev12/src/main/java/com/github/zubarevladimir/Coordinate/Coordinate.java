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

  public Coordinate() {
    this.coordinate = "";
    this.xCoordinate = 0;
    this.yCoordinate = 0;
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
      xCoordinate = getXCoordinate(stringCoordinate);
      yCoordinate = getYCoordinate(stringCoordinate);
      coordinate = stringCoordinate;
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
    String yCoordinate = coordinates.substring(1);
    return Integer.parseInt(yCoordinate);
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
    String xCoordinateLetter = coordinates.substring(0, 1);
    for (int i = 0; i < Coordinates.values().length; i++) {
      if (xCoordinateLetter.toUpperCase().equals(Coordinates.values()[i].name())) {
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
