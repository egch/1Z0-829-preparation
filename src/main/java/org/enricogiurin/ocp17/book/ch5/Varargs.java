package org.enricogiurin.ocp17.book.ch5;

public class Varargs {

  /**
   * We can have also the main using varargs
   * @param args
   */
  public static void main(String... args) {
    // new Vararg().sumElement(1,2,3);
    // new Vararg().sumElement(new int[]{});
    new Varargs().call();
  }


  void call(){
    sumElement(0);  //result is: 0
    sumElement(1,2);  //result is: 3
    sumElement(1,2,3); //result is: 6
    sumElement(new int[]{1,2}); //result is: 3
    sumElement(null); //result is: 0
  }
  void sumElement(int... elements) {
    if(elements==null){
      System.out.println("result is: %d".formatted(0));
      return;
    }
    int result = 0;
    for (int element : elements) {
      result += element;
    }
    System.out.println("result is: %d".formatted(result));
  }

  //Vararg parameter must be the last in the list
  //there should be only one vararg parameter
  void multipleVararg(int... elements/*, String... list*/) { //does not compile

  }

  void usingVarargAsVariable(String... names) {
    //While varargs is used like an array from within the method,
    // it can only be used as a method parameter.
    //String... names2 = names;  //    //Does not compile!
  }

}
