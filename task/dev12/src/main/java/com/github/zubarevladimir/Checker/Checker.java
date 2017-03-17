package com.github.zubarevladimir.Checker;

import com.github.zubarevladimir.Validator.CheckerValidator;

public class Checker {

  private String type;
  private String startCoordinate;
  private String stopCoordinate;
  private int yStart;
  private int yStop;
  private int xStart;
  private int xStop;

  private enum Coordinates {
    A, B, C, D, E, F, G, H
  }

  private void setYStart(int yStart) {
    this.yStart = yStart;
  }

  private void setYStop(int yStop) {
    this.yStop = yStop;
  }

  private void setXStart(int xStart) {
    this.xStart = xStart;
  }

  private void setXStop(int xStop) {
    this.xStop = xStop;
  }

  public void setType(String type, CheckerValidator validator) throws IllegalArgumentException {
    if (validator.validateType(type)) {
      this.type = type;
    }
  }

  public void setStartCoordinate(String startCoordinate, CheckerValidator validator)
      throws IllegalArgumentException {
    if (validator.validateCoordinate(startCoordinate)) {
      this.startCoordinate = startCoordinate;
      this.setXStart(getXCoordinates(startCoordinate));
      this.setYStart(getYCoordinates(startCoordinate));
    }
  }

  public void setStopCoordinate(String stopCoordinate, CheckerValidator validator)
      throws IllegalArgumentException {
    if (validator.validateCoordinate(stopCoordinate)) {
      this.stopCoordinate = stopCoordinate;
      this.setXStop(getXCoordinates(stopCoordinate));
      this.setYStop(getYCoordinates(stopCoordinate));
    }
  }

  /**
   * Get y-coordinate from all coordinate.
   *
   * @param coordinates checker's coordinates.
   * @return int - numerical y-coordinate.
   */
  private int getYCoordinates(String coordinates) {
    return Integer.parseInt(coordinates.substring(1));
  }

  /**
   * Represent letter-coordinate like number.
   *
   * @param coordinates checker's coordinates.
   * @return int - numerical x-coordinate.
   */
  private int getXCoordinates(String coordinates) {
    int coordinate = 0;
    for (int i = 0; i < Coordinates.values().length; i++) {
      if (coordinates.substring(0, 1).equals(Coordinates.values()[i].name())) {
        coordinate = i + 1;
      }
    }
    return coordinate;
  }

  public int getYStart() {
    return yStart;
  }

  public int getYStop() {
    return yStop;
  }

  public int getXStart() {
    return xStart;
  }

  public int getXStop() {
    return xStop;
  }

  public String getType() {

    return type;
  }

  public String getStartCoordinate() {
    return startCoordinate;
  }

  public String getStopCoordinate() {
    return stopCoordinate;
  }
}
