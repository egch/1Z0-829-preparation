package org.enricogiurin.ocp17.book.ch5.overloading;

public class MethodMatchingOverloading2 {

  public static void main(String[] args) {
    new MethodMatchingOverloading2().call();
  }

  void call() {
    method(4);  //float
    method(4D);  //double
  }

  void method(double d) {
    System.out.println("double");
  }

  void method(float d) {
    System.out.println("float");
  }


}
