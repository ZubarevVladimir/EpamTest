package Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all tests results.
 */
public class ResultContainer {

  private static ResultContainer instance;
  private static List<TestResult> resultList;

  private ResultContainer() {
  }

  public static ResultContainer getInstance() {
    if (instance == null) {
      instance = new ResultContainer();
      resultList = new ArrayList<>();
    }
    return instance;
  }

  public List<TestResult> getResult(){
    return resultList;
  }

  /**
   * Add result to result list.
   *
   * @param result - added result to result list.
   */
  public void addResult(TestResult result){
    resultList.add(result);
  }
}
