package org.enricogiurin.ocp17.ch6;

public class ManyConstructors {

  private final int age;
  private final String name;


  public ManyConstructors(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public ManyConstructors(int age) {
    this(age, "Enrico");
  }

  public ManyConstructors() {
    this(30);
  }

  public static void main(String[] args) {
    var enrico = new ManyConstructors();
    System.out.println(enrico);

  }

  @Override
  public String toString() {
    return "Name: " + this.name + " - age: " + this.age;
  }
}
