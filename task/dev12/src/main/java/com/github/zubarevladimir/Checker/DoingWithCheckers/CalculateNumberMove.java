package com.github.zubarevladimir.Checker.DoingWithCheckers;

import com.github.zubarevladimir.Checker.Checker;

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
    if (checker.getYStop() > checker.getYStart() && Math.abs(
        (checker.getYStop() - checker.getYStart())) > (checker.getXStop() - checker.getXStart())) {
      numberMoves = (checker.getYStop() - checker.getYStart());
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
    if (checker.getYStart() > checker.getYStop() && Math.abs(
        (checker.getYStart() - checker.getYStop())) > (checker.getXStart() - checker.getXStop())) {
      numberMoves = (checker.getYStart() - checker.getYStop());
    } else {
      throw new IllegalArgumentException(
          checker.getStartCoordinate().toUpperCase() + MESSAGE_MOVE_ERROR + checker
              .getStopCoordinate().toUpperCase());
    }
    return numberMoves;
  }
}
