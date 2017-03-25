package com.github.zubarevladimir.CheckerFigure;

import com.github.zubarevladimir.Coordinate.Coordinate;

public abstract class CheckerFigure {

  private Coordinate startCoordinate = new Coordinate();
  private Coordinate stopCoordinate = new Coordinate();
  private String MESSAGE_MOVE_ERROR = "Checker hasn't move to ";

  protected String getMESSAGE_MOVE_ERROR(){
    return MESSAGE_MOVE_ERROR;
  }

  public Coordinate getStartCoordinate() {
    return startCoordinate;
  }

  public Coordinate getStopCoordinate() {
    return stopCoordinate;
  }

  /**
   *
   * @return
   * @throws IllegalCheckersMoveException
   */
  public abstract int calculateNumberMove() throws IllegalCheckersMoveException;
}
