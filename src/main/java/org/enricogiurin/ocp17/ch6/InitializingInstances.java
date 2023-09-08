package org.enricogiurin.ocp17.ch6;



class Animal {

  // Static block in the Animal class
  static {
    System.out.print("A");
  }

  // Instance block in the Animal class
  {
    System.out.print("B");
  }

  Animal(String name) {
    this(1);
    System.out.print("C");
  }

  Animal(int a) {
    System.out.print("D");
  }

  Animal() {
    System.out.print("E");
  }
}

class Cat extends Animal {

  // Static block in the Cat class
  static {
    System.out.print("F");
  }

  // Instance block in the Cat class
  {
    System.out.print("G");
  }

  Cat(int age) {
    super("super");
    System.out.print("H");
  }
}


public class InitializingInstances {

  public static void main(String[] args) {
    new Cat(2);  //AFBDCGH
    System.out.println();  //BDCGH
    new Cat(1);
  }

}
