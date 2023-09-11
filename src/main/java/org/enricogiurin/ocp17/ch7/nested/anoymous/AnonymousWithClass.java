package org.enricogiurin.ocp17.ch7.nested.anoymous;

public class AnonymousWithClass {

  public static void main(String[] args) {
    new AnonymousWithClass().message();
  }

  void message() {
    Printer ciao = new Printer() {

      @Override
      void printMessage() {
        System.out.println("ciao");
      }
    };
    ciao.printMessage();
  }
}

class Printer {
  void printMessage() {
    System.out.println("hello World");
  }
}
