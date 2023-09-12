package org.enricogiurin.ocp17.ch7.nested.anoymous;

public class AnonymousWithClass {

  public static void main(String[] args) {
    new AnonymousWithClass().message();
  }

  void message() {
    String name = "Marco";
    //I cannot re-assign name if used in the inner class
    //name = null;
    Printer ciao = new Printer() {

      @Override
      void printMessage() {
        //name should be final or effective final
        System.out.println("ciao "+name);
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
