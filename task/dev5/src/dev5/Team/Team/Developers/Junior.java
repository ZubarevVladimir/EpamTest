package dev5.Team.Team.Developers;

/**
 * Created by Владимир on 21.02.2017.
 */
public class Junior extends Developer{
  private String qualification;
  private int productivity;
  private int salary;
  private double priceIndex;

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

