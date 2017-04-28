package TWMFramework.Results;

/**
 * Contains results test and methods for work with it.
 */
public class Result {

  private String status;
  private String instruction;
  private double time;

  public Result(String status, String instruction, double time) {
    this.status = status;
    this.instruction = instruction;
    this.time = time;
  }

  public String getStatus() {
    return status;
  }

  public String getInstruction() {
    return instruction;
  }

  public double getTime() {
    return time;
  }

  @Override
  public String toString() {
    return status + " " + instruction + " " + time;
  }
}