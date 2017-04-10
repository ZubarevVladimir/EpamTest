package com.github.zubarevladimir.Checker;

import com.github.zubarevladimir.Coordinate.Coordinate;

public class CheckerFigure {

  private Coordinate startCoordinate = new Coordinate();
  private Coordinate stopCoordinate = new Coordinate();

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
  public int calculateNumberMove(){return 0;};
}
