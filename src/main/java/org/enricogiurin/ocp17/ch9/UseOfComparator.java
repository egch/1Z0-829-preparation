package org.enricogiurin.ocp17.ch9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UseOfComparator {

    public static void main(String[] args) {
        new UseOfComparator().thenComparing();
    }

    void thenComparing() {
        Comparator<Person> comparator = Comparator.comparing(Person::age).thenComparing(Person::weight);
        List<Person> people = buildPeople();
        people.sort(comparator);
        people.forEach(System.out::println);
/*        Person[age=30, weight=100]
        Person[age=40, weight=90]
        Person[age=40, weight=100]*/
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
        return people;
    }
}


record Person(int age, int weight) {

}
