package dev5.Team.Developers;

/**
 * Created by Владимир on 20.02.2017.
 */
public class Developer {

  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

  public Developer(String qualification, int productivity, int salary) {
    this.qualification = qualification;
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

  public void printDevelopersInfo() {
    System.out.println(
        "Qualification: " + qualification + ", salary: " + salary + ", productivity: " + productivity
            + ", priceIndex: " + priceIndex);
  }
}
