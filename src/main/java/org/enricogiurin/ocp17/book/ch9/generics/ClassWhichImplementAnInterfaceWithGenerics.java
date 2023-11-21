package org.enricogiurin.ocp17.book.ch9.generics;

interface Sport<T> {

  void play(T t);
}

public class ClassWhichImplementAnInterfaceWithGenerics {

  void use() {
    Sport<Integer> tennis = new Tennis();
    Football<String> stringFootball = new Football<>();
    Football<Integer> integerFootball = new Football<>();
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


