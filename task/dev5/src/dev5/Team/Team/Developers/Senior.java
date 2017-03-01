package dev5.Team.Team.Developers;

/**
 * Senior-developer description
 */
public class Senior extends Developer {
  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

  /**
   * Initialize variables for class Senior.
   *
   * @param productivity describes the ability to seniors work.
   * @param salary price witch need to salary senior.
   */
  public Senior(int productivity, int salary) {
    this.qualification = "Senior";
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
