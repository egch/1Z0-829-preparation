package org.enricogiurin.ocp17.book.ch7.record;

public class UseOfRecord {

  public static void main(String[] args) {
    Person person = new Person("Enrico", "Giurin");
    Person clone = new Person("Enrico", "Giurin");
    System.out.println(person);
    System.out.println(person.equals(clone));
  }
}

record Person(String firstName, String lastName) {

  static int cnt = 0;

  static void printHello() {
    System.out.println("hello");
  }

  void printCustomHello() {
    System.out.println("hello " + firstName + ", " + lastName);
  }

}
