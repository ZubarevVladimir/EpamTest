package com.github.zubarevladimir.Checker;

/**
 * Contains methods for calculate number moves to go from start to finish for checker.
 */
public class CalculateNumberMove {

  private final String TYPE_WHITE = "white";
  private final String MESSAGE_MOVE_ERROR = " can not move to ";

  /**
   * Get number moves to go from start to finish for given checker.
   *
   * @param checker checker exemplar class Checker.
   * @return int - number moves to go from start to finish.
   * @throws IllegalArgumentException if checkers can not move to stop coordinate.
   */
  public int getNumberMove(Checker checker) throws IllegalArgumentException {
    int numberMoves;
    if (checker.getType().equals(TYPE_WHITE)) {
      numberMoves = calculateForWhite(checker);
    } else {
      numberMoves = calculateForBlack(checker);
    }
    return numberMoves;
  }

  /**
   * Calculate number moves to go from start to finish for white checker.
   *
   * @param checker checker exemplar class Checker.
   * @return int - number moves to go from start to finish.
   * @throws IllegalArgumentException if checkers can not move to stop coordinate.
   */
  private int calculateForWhite(Checker checker) throws IllegalArgumentException {
    int numberMoves;
    if (checker.getyStop() > checker.getyStart() && Math.abs(
        (checker.getyStop() - checker.getyStart())) > (checker.getxStop() - checker.getxStart())) {
      numberMoves = (checker.getyStop() - checker.getyStart());
    } else {
      throw new IllegalArgumentException(
          checker.getStartCoordinate().toUpperCase() + MESSAGE_MOVE_ERROR + checker
              .getStopCoordinate().toUpperCase());
    }
    return numberMoves;
  }

  /**
   * Calculate number moves to go from start to finish for black checker.
   *
   * @param checker exemplar class Checker.
   * @return int - number moves to go from start to finish.
   * @throws IllegalArgumentException if checkers can not move to stop coordinate.
   */
  private int calculateForBlack(Checker checker) throws IllegalArgumentException {
    int numberMoves;
    if (checker.getyStart() > checker.getyStop() && Math.abs(
        (checker.getyStart() - checker.getyStop()) / (checker.getxStart() - checker.getxStop()))
        >= 1) {
      numberMoves = (checker.getyStart() - checker.getyStop());
    } else {
      throw new IllegalArgumentException(
          checker.getStartCoordinate().toUpperCase() + MESSAGE_MOVE_ERROR + checker
              .getStopCoordinate().toUpperCase());
    }
    return numberMoves;
  }
}
