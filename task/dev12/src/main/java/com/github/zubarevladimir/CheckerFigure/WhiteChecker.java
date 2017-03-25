package com.github.zubarevladimir.CheckerFigure;

public class WhiteChecker extends CheckerFigure {

  /**
   *
   * @return
   * @throws IllegalCheckersMoveException
   */
  @Override
  public int calculateNumberMove() throws IllegalCheckersMoveException{
    int numberMoves;
    if (super.getStopCoordinate().getYCoordinate() > super.getStartCoordinate().getYCoordinate()
        &&
        (super.getStopCoordinate().getYCoordinate() - super.getStartCoordinate().getYCoordinate())
        >=
        (super.getStopCoordinate().getXCoordinate() - super.getStartCoordinate()
            .getXCoordinate())) {
      numberMoves = (super.getStopCoordinate().getYCoordinate() - super.getStartCoordinate()
          .getYCoordinate());
    } else {
      throw new IllegalCheckersMoveException(super.getMESSAGE_MOVE_ERROR() + super
              .getStopCoordinate().getCoordinate().toUpperCase());
    }
    return numberMoves;
  }
}
