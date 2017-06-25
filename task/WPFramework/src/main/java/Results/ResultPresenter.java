package Results;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Present results for final parsing to XML.
 */
@XmlRootElement
public class ResultPresenter {


  private int correctTests;
  private int totalTests;
  private List<TestResult> result;


  @XmlElement
  public int getCorrectTests() {
    return correctTests;
  }

  @XmlElement
  public int getTotalTests() {
    return totalTests;
  }

  @XmlElement
  public List<TestResult> getResult() {
    return result;
  }

  public void setData(List<TestResult> resultList) {
    totalTests = resultList.size();
    result = new ArrayList<>();
    for (TestResult result : resultList) {
      if (result.getStatus()) {
        correctTests++;
      } else {
        this.result.add(result);
      }
    }
  }
}
