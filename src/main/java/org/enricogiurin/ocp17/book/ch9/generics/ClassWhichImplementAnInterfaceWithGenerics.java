package org.enricogiurin.ocp17.book.ch9.generics;


interface Sport<T> {

  void play(T t);
}

public class ClassWhichImplementAnInterfaceWithGenerics {

  void use() {
    Tennis tennis = new Tennis();
    Football<String> stringFootball = new Football<>();
    Football<Integer> integerFootball = new Football<>();
    //another way
    var sbf = new Sport<StringBuilder>() {
      @Override
      public void play(StringBuilder stringBuilder) {
      }
    };
  }
}

class Tennis implements Sport<Integer> {
  @Override
  public void play(Integer integer) {
  }
}

class Football<T> implements Sport<T> {
  @Override
  public void play(T t) {
  }
}

//I can also implement the interface without using Generics
//Compiler warning: Raw use of parameterized class 'Sport'
class RawSport implements Sport {

  @Override
  public void play(Object o) {
  }
}


