package org.enricogiurin.ocp17.book.ch7.interfaces;

public interface InterfaceWithMain {

  //it works
  //java -cp target/classes org.enricogiurin.ocp17.book.ch7.interfaces.InterfaceWIthMain
  //and the public modifier is optional
  static void main(String[] args) {
    System.out.println("I am in an interface!");
  }

}
