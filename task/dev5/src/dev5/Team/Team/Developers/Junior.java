package dev5.Team.Team.Developers;

/**
 * Juniors-developer description.
 */
public class Junior extends Developer {

  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

  /**
   * Initialize variables for class Junior.
   *
   * @param productivity describes the ability to juniors work.
   * @param salary price witch need to salary junior.
   */
  public Junior(int productivity, int salary) {
    this.qualification = "Junior";
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

