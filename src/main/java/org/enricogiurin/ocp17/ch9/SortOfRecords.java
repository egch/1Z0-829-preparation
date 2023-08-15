package org.enricogiurin.ocp17.ch9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOfRecords {

  public static void main(String[] args) {
    Person enrico = new Person("Paula", 3);
    Person luca = new Person("Peter", 5);
    Person fabio = new Person("Peter", 7);
    List<Person> boys = Arrays.asList(enrico, luca, fabio);

    Comparator<Person> comparator = Comparator.comparing(Person::name).thenComparingInt(Person::age)
        .reversed();

    Collections.sort(boys, comparator);
    //[7, 5, 3]
    System.out.println(boys);

  }


  static record Person(String name, int age) {

    @Override
    public String toString() {
      return "" + age;
    }
  }

}

