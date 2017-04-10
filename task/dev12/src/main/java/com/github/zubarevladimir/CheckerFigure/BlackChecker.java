package com.github.zubarevladimir.CheckerFigure;

public class BlackChecker extends CheckerFigure {

  /**
   * Calculate number steps, for move to necessary coordinate.
   *
   * @return int - necessary number steps.
   * @throws IllegalCheckersMoveException if checker can't move from start coordinate to stop
   * coordinate.
   */
  @Override
  public int calculateNumberSteps() throws IllegalCheckersMoveException {
    int numberSteps;
    if (super.getStartCoordinate().getYCoordinate() > super.getStopCoordinate().getYCoordinate()
        &&
        (super.getStartCoordinate().getYCoordinate() - super.getStopCoordinate().getYCoordinate())
            >=
            (super.getStartCoordinate().getXCoordinate() - super.getStopCoordinate()
                .getXCoordinate())) {
      numberSteps = (super.getStartCoordinate().getYCoordinate() - super.getStopCoordinate()
          .getYCoordinate());
    } else {
      throw new IllegalCheckersMoveException(super.getMessageMoveError() + super
          .getStopCoordinate().getCoordinate().toUpperCase());
    }
    return numberSteps;
  }
}
