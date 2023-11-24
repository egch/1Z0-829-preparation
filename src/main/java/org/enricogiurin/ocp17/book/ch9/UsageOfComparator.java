package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsageOfComparator {

  public static void main(String[] args) {
    new UsageOfComparator().thenComparing();
  }

  void thenComparing() {
    Comparator<Person> comparator = Comparator.comparingInt(Person::age)
        .thenComparing(Person::weight);
    List<Person> people = buildPeople();
    people.sort(comparator);
    people.forEach(System.out::println);
    //now we search...but we need to specify the comparator, and we assume the collection
    //is already sorted based on that order
    int index = Collections.binarySearch(people, new Person(18, 80), comparator);
    System.out.println(index);  //0
  }


  void sorting() {
    List<Person> people = buildPeople();
    //does not compile because Person does not implement Comparable
    //reason: no instance(s) of type variable(s) T exist so that Person conforms to Comparable<? super T>
    //Collections.sort(people);

    //but we can pass a comparator as the 2nd arg
    Collections.sort(people, Comparator.comparingInt(Person::age));

  }

  List<Person> buildPeople() {
    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person(40, 90));
    people.add(new Person(40, 100));
    people.add(new Person(30, 100));
    people.add(new Person(18, 80));
    return people;
  }

  record Person(int age, int weight) {

  }
}



