package com.github.zubarevladimir.CheckerFigure;

import com.github.zubarevladimir.Coordinate.Coordinate;

public abstract class CheckerFigure {

  private Coordinate startCoordinate = new Coordinate();
  private Coordinate stopCoordinate = new Coordinate();
  private String MESSAGE_MOVE_ERROR = "Checker hasn't move to ";

  protected String getMessageMoveError(){
    return MESSAGE_MOVE_ERROR;
  }

  public Coordinate getStartCoordinate() {
    return startCoordinate;
  }

  public Coordinate getStopCoordinate() {
    return stopCoordinate;
  }

  /**
   * Calculate number steps, for move to necessary coordinate.
   *
   * @return int - necessary number steps.
   * @throws IllegalCheckersMoveException if checker can't move from start coordinate to stop
   * coordinate.
   */
  public abstract int calculateNumberSteps() throws IllegalCheckersMoveException;
}

