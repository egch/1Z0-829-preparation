package org.enricogiurin.ocp17.book.ch9.generics;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaticMethodGenerics {

  public static void main(String[] args) {
    invokeAdd();
  }

  public static void invokeAdd() {
    List<String> listOfString = new ArrayList<>();
    StaticMethodGenerics.add(listOfString, "hello");

    List<Integer> listOfInteger = new ArrayList<>();
    StaticMethodGenerics.add(listOfInteger, 5);

    Set<String> set = new HashSet<>();
    //complicate ways but still valid
    StaticMethodGenerics.<Set<String>, String>add(set, "John");

    System.out.println(listOfString);  //[hello]
    System.out.println(listOfInteger); //[5]
    System.out.println(set); //[John]
  }

  public static void invokePrintMessage() {
    printMessage(new FileNotFoundException("not found"));
    StaticMethodGenerics.<NullPointerException>printMessage(new NullPointerException("D"));
  }

  private static <U extends Exception> void printMessage(U u) {
    System.out.println(u.getMessage());
  }

  private static <T extends Collection<U>, U> U add(T list, U element) {
    list.add(element);
    return element;
  }


}
