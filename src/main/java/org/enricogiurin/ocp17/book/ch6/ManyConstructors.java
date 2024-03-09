package org.enricogiurin.ocp17.book.ch6;

public class ManyConstructors {

  private final int age;
  private final String name;


  public ManyConstructors(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public ManyConstructors(int age) {
    this(age, "Enrico");
    //I cannot combine this() with super() because they both need to be the first statement in the body
    //Call to 'super()' must be first statement in constructor body
    //super();  //DOES NOT COMPILE!
  }

  public ManyConstructors() {
    this(30);
  }

  public static void main(String[] args) {
    var enrico = new ManyConstructors();
    System.out.println(enrico);

  }

  public void setAge(int age) {
    //does not compile as this.age is final
    // this.age = age;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + " - age: " + this.age;
  }
}
