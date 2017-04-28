package TWMFramework.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains list with  tests's results and methods for getting some information about results.
 */
public class ResultContainer {

  private static ResultContainer container;
  private static List<Result> resultList;

  private ResultContainer() {
  }

  /**
   * Return created container, or create it and return.
   *
   * @return ResultContainer - single exemplar class ResultContainer.
   */
  public static ResultContainer getContainer() {
    if (container == null) {
      container = new ResultContainer();
      resultList = new ArrayList<>();
    }
    return container;
  }

  public void addResult(Result result) {
    resultList.add(result);
  }

  public List<Result> getResults() {
    return resultList;
  }

  /**
   * Count number correct tests.
   *
   * @return int - number correct tests
   */
  public int getNumberCorrectTests() {
    int counter = 0;
    for (Result result : resultList) {
      if (result.getStatus().equals("+")) {
        counter++;
      }
    }
    return counter;
  }

  /**
   * Count number incorrect tests.
   *
   * @return int - number incorrect tests.
   */
  public int getNumberIncorrectTests() {
    int counter = 0;
    for (Result result : resultList) {
      if (result.getStatus().equals("!")) {
        counter++;
      }
    }
    return counter;
  }

  /**
   * Count total test's time.
   *
   * @return double - total test's time.
   */
  public double getTotalTestTime() {
    double totalTime = 0;
    for (Result result : resultList) {
      totalTime += result.getTime();
    }
    return totalTime;
  }

  /**
   * Count average test's time.
   *
   * @return double - average test's time.
   */
  public double getAverageTestTime() {
    double totalTime = 0;
    int numberTests = 0;
    for (Result result : resultList) {
      numberTests++;
      totalTime += result.getTime();
    }
    return totalTime / numberTests;
  }
}
