package task.dev3.User;

import java.io.*;
import java.util.*;

/**
 * Contains informations about user.
 */
public class User {
  private String name;
  private String surname;
  private String gender;
  private int age;
    
  public String getName() {
    return this.name;
  }
  public String getSurname() {
    return this.surname;
  }
  public String getGender() {
    return this.gender;
  }
  public int getAge() {
    return this.age;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void setAge(int age) {
    this.age = age;
  }
  /**
   * Print information about user.
   */  
  public void printUsersInfo() {
    System.out.println(this.name + " " + this.surname + " " + this.gender + " " + this.age);
  }  
}