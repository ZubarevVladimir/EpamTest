package com.github.zubarevladimir.Checker;

import com.github.zubarevladimir.Coordinate.Coordinate;

public class BlackChecker extends CheckerFigure {

  private Coordinate startCoordinate = new Coordinate();
  private Coordinate stopCoordinate = new Coordinate();
  private String MESSAGE_MOVE_ERROR = " can't move to ";

  public Coordinate getStartCoordinate() {
    return startCoordinate;
  }

  public Coordinate getStopCoordinate() {
    return stopCoordinate;
  }

  /**
   * Calculate number move, for coming to necessary coordinate.
   * @return int - necessary number moves.
   */
  @Override
  public int calculateNumberMove() {
    int numberMoves;
    if (startCoordinate.getYCoordinate() > stopCoordinate.getYCoordinate() && Math.abs(
        (startCoordinate.getYCoordinate() - stopCoordinate.getYCoordinate())) >
        (startCoordinate.getXCoordinate() - stopCoordinate.getXCoordinate())) {
      numberMoves = (startCoordinate.getYCoordinate() - stopCoordinate.getYCoordinate());
    } else {
      throw new IllegalArgumentException(
          startCoordinate.getCoordinate().toUpperCase() + MESSAGE_MOVE_ERROR + stopCoordinate
              .getCoordinate().toUpperCase());
    }
    return numberMoves;
  }
}
