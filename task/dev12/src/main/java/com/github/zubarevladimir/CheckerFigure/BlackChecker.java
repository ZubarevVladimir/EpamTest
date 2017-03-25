package com.github.zubarevladimir.CheckerFigure;

public class BlackChecker extends CheckerFigure {

  /**
   * Calculate number move, for coming to necessary coordinate.
   *
   * @return int - necessary number moves.
   */
  @Override
  public int calculateNumberMove() throws IllegalCheckersMoveException {
    int numberMoves;
    if (super.getStartCoordinate().getYCoordinate() > super.getStopCoordinate().getYCoordinate()
        &&
        (super.getStartCoordinate().getYCoordinate() - super.getStopCoordinate().getYCoordinate())
            >=
            (super.getStartCoordinate().getXCoordinate() - super.getStopCoordinate()
                .getXCoordinate())) {
      numberMoves = (super.getStartCoordinate().getYCoordinate() - super.getStopCoordinate()
          .getYCoordinate());
    } else {
      throw new IllegalCheckersMoveException(super.getMESSAGE_MOVE_ERROR() + super
          .getStopCoordinate().getCoordinate().toUpperCase());
    }
    return numberMoves;
  }
}
