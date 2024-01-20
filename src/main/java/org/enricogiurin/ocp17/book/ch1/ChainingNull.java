package org.enricogiurin.ocp17.book.ch1;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

@JarMockTest
public class ChainingNull {

  void chainingBooleanAndNull() {
    //none of this compiles
    //System.out.println(null + true);
    //System.out.println(true + null);
    //System.out.println(null + null);
  }

  void chainingStringAndNull() {
    //compiles
    System.out.println("aaa" + null);
  }


}
