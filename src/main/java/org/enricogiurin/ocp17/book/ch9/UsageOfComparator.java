package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class UsageOfComparator {

  public static void main(String[] args) {
    new UsageOfComparator().naturalOrderVsReverseOrder();
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

  @JarMockTest
  void reversed() {
    Comparator<String> reversedComparator = Comparator.reverseOrder();
    List<String> list = Arrays.asList("a", "hgh", "81a", "dhY", "Ya", "Y3");
    list.sort(reversedComparator);
    String result = String.join(" ", list);
    System.out.println(result);  //hgh dhY a Ya Y3 81a

    list.sort(Comparator.naturalOrder());
    result = String.join(" ", list);
    System.out.println(result);  //81a Y3 Ya a dhY hgh
  }

  void naturalOrderVsReverseOrder() {
    List<Integer> list = List.of(1, 5, 9, 3, 4, 6);
    var mutableList = new ArrayList<>(list);
    Comparator<Integer> naturalOrder = Comparator.naturalOrder();
    Comparator<Integer> reverseOrder = Comparator.reverseOrder();
    Collections.sort(mutableList, naturalOrder); //[1, 3, 4, 5, 6, 9]
    System.out.println(mutableList);
    Collections.sort(mutableList, reverseOrder); //[9, 6, 5, 4, 3, 1]
    System.out.println(mutableList);
  }

  record Person(int age, int weight) {

  }
}



