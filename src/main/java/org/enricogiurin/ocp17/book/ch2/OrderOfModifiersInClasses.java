package org.enricogiurin.ocp17.book.ch2;

import java.io.Serializable;

public class OrderOfModifiersInClasses {

  //extends come always earlier than implements
  class A extends Object implements Serializable {

  }

  //invalid
  //class B implements Serializable extends Object  {}  //does not compile


}
