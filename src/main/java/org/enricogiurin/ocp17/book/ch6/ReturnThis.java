package org.enricogiurin.ocp17.book.ch6;

public class ReturnThis {
  static {
    aStaticValue=4;
  }
  static final int aStaticValue;

  ReturnThis giveMeTheInstance() {
    return this;
  }

}
