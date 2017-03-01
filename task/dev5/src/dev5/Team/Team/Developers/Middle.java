package dev5.Team.Team.Developers;

/**
 * Middle-developer description.
 */
public class Middle extends Developer {

  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

  /**
   * Initialize variables for class Middle.
   *
   * @param productivity describes the ability to middles work.
   * @param salary price witch need to salary middle.
   */
  public Middle(int productivity, int salary) {
    this.qualification = "Middle";
    this.productivity = productivity;
    this.salary = salary;
    this.priceIndex = salary / productivity;
  }

  public String getQualification() {
    return qualification;
  }

  public int getProductivity() {
    return productivity;
  }

  public int getSalary() {
    return salary;
  }

  public double getPriceIndex() {
    return priceIndex;
  }
}
