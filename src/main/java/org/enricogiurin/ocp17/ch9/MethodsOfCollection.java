package org.enricogiurin.ocp17.ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodsOfCollection {

    public static void main(String[] args) {
        new MethodsOfCollection().remove();
    }
    void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ab");
        list.add("bc");
        System.out.println("size: "+list.size()); //3
        list.removeIf(s->s.startsWith("a"));  //we remove aa, ab
        System.out.println("size: "+list.size());  //1
    }

    void replaceAll() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ab");
        list.add("bc");

        list.replaceAll(s -> s+"xxx");
        list.forEach(System.out::println);
    }

    void remove() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(2); //remove element at index 2 ->[3,2]
        list.forEach(System.out::println);  //3,2
        list.remove(Integer.valueOf(2));  //remove the element 2, as here I am calling the method remove(T)
        System.out.println();
        list.forEach(System.out::println);  //3

    }
}
