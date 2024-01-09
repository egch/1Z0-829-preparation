package org.enricogiurin.ocp17.book.ch8.lambda;


/**
 * This example I cannot use a class to represent a Lambda. I need to use an Interface.
 */
public class LambdaClassArgument {

  void invoke() {
    class Printer {

      void print(Generator generator) {
        System.out.println(generator.random());
      }
    }
    Printer printer = new Printer();

    //Target type of a lambda conversion must be an interface
    //printer.print(()->Math.PI); //does not compile
  }

  private static class Generator {

    double random() {
      return Math.random();
    }
  }

}
