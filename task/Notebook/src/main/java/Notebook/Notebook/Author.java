package Notebook.Notebook;

public class Author {

  private String name;
  private String surname;

  Author(String name, String surname){
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  @Override
  public String toString() {
    return "Author: " + name + " " + surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Author author = (Author) o;

    if (name != null ? !name.equals(author.name) : author.name != null) {
      return false;
    }
    return surname != null ? surname.equals(author.surname) : author.surname == null;
  }

  @Override
  public int hashCode() {
    return name.hashCode() | surname.hashCode();
  }
}
