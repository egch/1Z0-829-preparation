package org.enricogiurin.ocp17.book.ch6;

public class ReturnThis {

  static final int aStaticValue;

  static {
    aStaticValue = 4;
  }

  ReturnThis giveMeTheInstance() {
    return this;
  }

}
