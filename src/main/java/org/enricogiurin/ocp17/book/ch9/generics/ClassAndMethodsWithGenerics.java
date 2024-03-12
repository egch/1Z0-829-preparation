package org.enricogiurin.ocp17.book.ch9.generics;

public class ClassAndMethodsWithGenerics {

}

class Ball<X> {
  //this does not compile because:
  //X cannot be referenced from a static context
  // public static <T> void catchBall(T t, X x) {}  DOES NOT COMPILE

  //this is how to fix it
  public static <T, X> void catchBall(T t, X x) {
  }

  //or make the method instance, not static:
  public <T> void catchBall2(T t, X x) {
  }

  //here redefines X so the type on Ball is hidden.
  public <X extends Number> void inflateBall(X t, X x) {
  }

}


class MyBall extends Ball<String> {

  public static void main(String[] args) {
    MyBall myBall = new MyBall();
    myBall.inflateBall(5, 4L);
    myBall.catchBall2(new Object(), "hello");
  }

}