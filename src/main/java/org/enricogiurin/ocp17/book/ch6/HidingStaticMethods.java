package org.enricogiurin.ocp17.book.ch6;

public class HidingStaticMethods {

  class Mammal {

    public static void sleep() {
      System.out.println("The Mammal is sleeping");
    }

    public static void swim() {
      System.out.println("Mammal is swimming");
    }

    public void name() {
      System.out.println("name is Mammal");
    }

    public static final void message() {}
  }

  class Whale extends Mammal {

    //I cannot hide a static final method
    //public static final void message() {}  //does not compile

    public static void sleep() {
      System.out.println("The Whale is sleeping");
    }

    //does not compile as it has the same method as the static method in the Mammal
    /*
    public void swim() {
      System.out.println("Mammal is swimming");
    }
    */

    //does not compile as it has the same method as the instance method in the Mammal
    /*
    public static void name() {
      System.out.println("name is Mammal");
    }
    */
  }

  public static void main(String[] args) {
    Mammal.sleep();  //The Mammal is sleeping
    Whale.sleep();  //The Whale is sleeping
  }

}

