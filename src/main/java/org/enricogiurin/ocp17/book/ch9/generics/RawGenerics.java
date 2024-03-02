package org.enricogiurin.ocp17.book.ch9.generics;

public class RawGenerics {

  void create() {
    SimpleGenerics<String> stringSimpleGenerics = new SimpleGenerics<>("hello");
    //here I have the proper type String
    String st = stringSimpleGenerics.getELement();

  }

  void createWithRawGenerics() {
    //Raw use of parameterized class 'SimpleGenerics'
    SimpleGenerics rawGenerics = new SimpleGenerics<>("hello");
    //here I have the type of Object as the left side is declared not with generics
    Object element2 = rawGenerics.getELement();
    //Raw use of parameterized class 'SimpleGenerics'
    SimpleGenerics objectGenerics = new SimpleGenerics("hello");
    //here I have the type of Object as the left side is declared not with generics
    Object element1 = objectGenerics.getELement();

    //Raw use of parameterized class 'SimpleGenerics'
    SimpleGenerics exceptionSimpleGenerics = new SimpleGenerics<Exception>(new RuntimeException());
    //here I have the type of Object as the left side is declared not with generics
    Object element = exceptionSimpleGenerics.getELement();
  }

  void createWithVar() {
    // uses local variable type inference,
    var sg = new SimpleGenerics<String>("hello");
    //here I have the proper type String
    String element = sg.getELement();
  }

}

class SimpleGenerics<T> {

  private final T t;

  public SimpleGenerics(T t) {
    this.t = t;
  }

  T getELement() {
    return t;
  }
}
