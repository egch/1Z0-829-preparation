package org.enricogiurin.ocp17.ch7.record;

public class UseOfRecord {
    public static void main(String[] args) {
        Person person = new Person("Enrico", "Giurin");
        Person clone = new Person("Enrico", "Giurin");
        System.out.println(person);
        System.out.println(person.equals(clone));
    }
}

record Person(String firstName, String lastName) {

}



