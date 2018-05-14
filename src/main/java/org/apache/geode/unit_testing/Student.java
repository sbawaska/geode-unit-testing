package org.apache.geode.unit_testing;

/**
 * A simple Entity used in the unit testing examples
 */
public class Student {
  private int id;
  private String name;
  private float gpa;

  public Student() {
  }
  public Student(int id, String name, float gpa) {
    this.id = id;
    this.name = name;
    this.gpa = gpa;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getGpa() {
    return gpa;
  }

  public void setGpa(float gpa) {
    this.gpa = gpa;
  }
}
