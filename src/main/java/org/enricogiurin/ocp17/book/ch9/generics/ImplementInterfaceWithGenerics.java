package org.enricogiurin.ocp17.book.ch9.generics;

interface Box<T> {

  T getItem();
}

public class ImplementInterfaceWithGenerics {


}

class SimpleBox implements Box<String> {

  @Override
  public String getItem() {
    return "Simple box";
  }
}

//not valid, I cannot use the generics type of the interface but I should use the class type.
/*
  class NotValidBox implements Box<Integer> {
    public T getItem() {
      return null;
    }
  }
*/
