package org.enricogiurin.ocp17.book.ch1;

public class MultipleVariables {
  void usage() {
    long x=5, y=6L;
    //only one type
    //long x=5, double f = 5.0D;  //does not compile

    //only one type
    //long a1 = 5L, long a2 =6L;  //does not compile
  }

  void withVar() {
    //'var' is not allowed in a compound declaration
    //var s = "Hello", t ="ciao";  does not compile
  }

  void withFinal() {
    final int x = 0, y=6;
    //x = 4;  cannot change x is final
    //y = 7;  //but also y is final

    //final only once
    //final int d=0, final t=5;
  }

}
