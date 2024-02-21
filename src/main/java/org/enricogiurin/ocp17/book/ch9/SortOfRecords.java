package org.enricogiurin.ocp17.book.ch9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOfRecords {

  public static void main(String[] args) {
    SortOfRecords instance = new SortOfRecords();
    instance.sort();
    instance.sort2();

  }

  void sort() {
    List<Person> boys = boys();
    Comparator<Person> comparator = Comparator.comparing(Person::name)
        .thenComparingInt(Person::age)
        .reversed();
    Collections.sort(boys, comparator);
    //[Person[name=Peter, age=7], Person[name=Peter, age=5], Person[name=Paula, age=3], Person[name=John, age=7]]
    System.out.println(boys);
  }

  void sort2() {
    List<Person> boys = boys();
    Comparator<Person> personComparator = Comparator.comparingInt(Person::age)
        .thenComparing(Person::name);
    boys.sort(personComparator);
    //[Person[name=Paula, age=3], Person[name=Peter, age=5], Person[name=John, age=7], Person[name=Peter, age=7]]
    System.out.println(boys);
  }

  List<Person> boys() {
    Person p1 = new Person("Paula", 3);
    Person p2 = new Person("Peter", 5);
    Person p3 = new Person("Peter", 7);
    Person p4 = new Person("John", 7);
    return Arrays.asList(p1, p2, p3, p4);
  }

  record Person(String name, int age) {

  }

}

