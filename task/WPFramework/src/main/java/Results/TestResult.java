package Results;

/**
 * Class contains information about test result
 */
public class TestResult {

  private boolean status;
  private String name;
  private String parameters;
  private long testTime;
  private int testsAtempts;

  public TestResult(boolean status, String name, String parameters, long testTime,
      int testsAtempts) {
    this.status = status;
    this.name = name;
    this.parameters = parameters;
    this.testTime = testTime;
    this.testsAtempts = testsAtempts;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParameters() {
    return parameters;
  }

  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  public long getTestTime() {
    return testTime;
  }

  public void setTestTime(long testTime) {
    this.testTime = testTime;
  }

  public int getTestsAtempts() {
    return testsAtempts;
  }

  public void setTestsAtempts(int testsAtempts) {
    this.testsAtempts = testsAtempts;
  }

  @Override
  public String toString() {
    return ((status) ? "+" : "-") + " Name: \"" + name + "\", Parameters:\""
        + parameters + "\", Test  time:\"" + testTime + "Incorrect attempts: "
        + testsAtempts;
  }
}
