package org.enricogiurin.ocp17.book.ch5;

public class Vararg {

  public static void main(String[] args) {
    // new Vararg().sumElement(1,2,3);
    // new Vararg().sumElement(new int[]{});
    new Vararg().sumElement(new int[]{4, 5});
  }

  void sumElement(int... elements) {
    int result = 0;
    for (int element : elements) {
      result += element;
    }
    System.out.println("result is: " + result);
  }

  //Vararg parameter must be the last in the list
  //there should be only one vararg parameter
  void multipleVararg(int... elements
      /*, String... list*/  //does not compile
  ) {
  }

  void usingVarargAsVariable(String... names) {
    //While varargs is used like an array from within the method,
    // it can only be used as a method parameter.
    //String... names2 = names;  //    //Does not compile!
  }

}
