package org.enricogiurin.ocp17.ch5;

public class Wrapper {

  void byteValue() {
    Integer.valueOf("10").byteValue();
    Long.valueOf("10").byteValue();
    Double.valueOf("10").byteValue();
    //the following line does not compile
    //Character.valueOf("10").byteValue();
  }

}
