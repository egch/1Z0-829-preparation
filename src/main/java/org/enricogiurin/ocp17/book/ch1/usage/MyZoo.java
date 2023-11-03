package org.enricogiurin.ocp17.book.ch1.usage;

import org.enricogiurin.ocp17.book.ch1.fruits.Apple;

public class MyZoo {


  //apparent confusion as it seems Apple can belong to both the package fruits and the package phones.
  //but actually is from the package fruit as importing from class name takes precedence over wildcards
  public static void main(String[] args) {
    Apple apple = new Apple();
    System.out.println(apple.getClass());
    //prints: class org.enricogiurin.ocp17.ch1.fruits.Apple

  }
}
