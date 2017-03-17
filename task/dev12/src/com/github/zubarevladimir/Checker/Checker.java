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
  private final String MESSAGE_INCORRECT_COORDINATE =  "Incorrect checker's coordinate: ";
  private final String MESSAGE_INCORRECT_TYPE = "Incorrect checker's coordinate: ";

  public void setyStart(int yStart, CheckerValidator validator) {
    if (validator.validateCoordinate(yStart)) {
      this.yStart = yStart;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + yStart);
    }
  }

  public void setyStop(int yStop, CheckerValidator validator) {
    if (validator.validateCoordinate(yStop)) {
      this.yStop = yStop;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + yStop);
    }
  }

  public void setxStart(int xStart, CheckerValidator validator) {
    if (validator.validateCoordinate(xStart)) {
      this.xStart = xStart;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + xStart);
    }
  }

  public void setxStop(int xStop, CheckerValidator validator) {
    if (validator.validateCoordinate(xStop)) {
      this.xStop = xStop;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + xStop);
    }
  }

  public void setType(String type, CheckerValidator validator) throws IllegalArgumentException {
    if (validator.validateType(type)) {
      this.type = type;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_TYPE + type);
    }
  }

  public void setStartCoordinate(String startCoordinate, CheckerValidator validator) {
    if (validator.validateCoordinate(startCoordinate)) {
      this.startCoordinate = startCoordinate;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + startCoordinate);
    }
  }

  public void setStopCoordinate(String stopCoordinate, CheckerValidator validator) {
    if (validator.validateCoordinate(stopCoordinate)) {
      this.stopCoordinate = stopCoordinate;
    } else {
      throw new IllegalArgumentException(MESSAGE_INCORRECT_COORDINATE + stopCoordinate);
    }
  }

  public int getyStart() {
    return yStart;
  }

  public int getyStop() {
    return yStop;
  }

  public int getxStart() {
    return xStart;
  }

  public int getxStop() {
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
