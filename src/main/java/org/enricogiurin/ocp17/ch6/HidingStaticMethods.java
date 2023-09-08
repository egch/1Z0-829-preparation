package org.enricogiurin.ocp17.ch6;


class Mammal {
 public static void sleep() {
   System.out.println("The Mammal is sleeping");
 }
 public void name() {
   System.out.println("name is Mammal");
 }
 public static void swim() {
   System.out.println("Mammal is swimming");
 }
}

class Whale extends Mammal {
  public static void sleep() {
    System.out.println("The Whale is sleeping");
  }

  //does not compile as it has the same method as the static method in the Mammal
/*  public  void swim() {
    System.out.println("Mammal is swimming");
  }*/


  //does not compile as it has the same method as the instance method in the Mammal
/*
  public static void name() {
    System.out.println("name is Mammal");
  }
*/


  public class HidingStaticMethods {
    public static void main(String[] args) {
      Mammal.sleep();
      Whale.sleep();
    }
  }

}

