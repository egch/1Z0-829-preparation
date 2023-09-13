package org.enricogiurin.ocp17.ch5;

public class LocalVariables {

  void sum() {
    //local variables need to be initialized before being used
    final int a = 5;
    int b = 6;
    //Cannot assign a value to final variable 'a'
    //a+=6;
    int result = 0;
    result = a + b;
  }

  void localVariablesNotUsed() {
    //I can omit to initialize a, b since they are never used
    int a, b;

    //I can split creation & assignment of a final variable in 2 lines
    final int c;
    c = 4;
    System.out.println("hello");
  }

  void effectiveFinal() {
    //a is effective final as once initialized is never changed
    int a = 5;
    System.out.println(a);
  }

  void varLocalVariables() {
    final var x = 5;

  }


}
