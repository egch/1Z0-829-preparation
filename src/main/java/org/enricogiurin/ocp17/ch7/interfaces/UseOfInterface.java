package org.enricogiurin.ocp17.ch7.interfaces;

public class UseOfInterface {

}

//does not compile
//final interface Walk {}

interface A {
  int weight();
}

interface B {
  void weight();
}

interface C {
  void weight();
}
//it does not compile as A, B both define weight() but with different return type
/*class ImplementsAB implements A, B {

}*/

//in this case the method is the same in B, C
class ImplementsBC implements B, C {

  @Override
  public void weight() {

  }
}

interface D {
  //public static and final are implicit
  public static final int x = 5;
  int y = 5;
}

