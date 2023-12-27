package org.enricogiurin.ocp17.book.ch9.generics;

public class GenericsWIthWildOperator {

  void wildOperatorRight() {
    //Wildcard type '?' cannot be instantiated directly
    //List<String> list = new ArrayList<?>();  //does not compile

  }

}
