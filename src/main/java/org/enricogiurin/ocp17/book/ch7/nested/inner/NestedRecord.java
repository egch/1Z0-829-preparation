package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class NestedRecord {

  public static void main(String[] args) {
    Person john = new Person("John", "Doe", 30);
    System.out.println("name: " + john.firstName);
    new NestedRecord().printData(john);
  }

  void printData(Person person) {
    //in this case, I can access to the instance attribute of the record with accessor method
    System.out.println(person.firstName + " - " + person.lastName + " - " + person.age);
  }

  record Person(String firstName, String lastName, int age) {

  }

}
