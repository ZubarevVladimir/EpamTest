package dev5.Team.Team.Developers;

/**
 * Leader-developer description.
 */
public class Lead extends Developer {

  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

  /**
   * Initialize variables for class Lead.
   *
   * @param productivity describes the ability to leads work.
   * @param salary price witch need to salary lead.
   */
  public Lead(int productivity, int salary) {
    this.qualification = "Lead";
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
