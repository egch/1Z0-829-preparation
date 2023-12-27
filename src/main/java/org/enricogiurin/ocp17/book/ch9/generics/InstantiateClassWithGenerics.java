package org.enricogiurin.ocp17.book.ch9.generics;

public class InstantiateClassWithGenerics {

  void instantiateWrapper() {
    //standard way, diamond operator
    Wrapper<String> stringWrapper = new Wrapper<>("hello");
    //before diamond operator (before java 7)
    Wrapper<String> stringWrapperOld = new Wrapper<String>("hello");

    //without generics, but you get some warning
    Wrapper objectWrapper = new Wrapper("hello");
    //note that you get an Object, not a String!
    Object t = objectWrapper.getElement();

    //with var ww have type inference
    var varWrapper = new Wrapper<>("hello");
    //here you have string
    String element = varWrapper.getElement();

    //with var ww have type inference
    //Explicit type argument String can be replaced with <>
    var varWrapperGenerics = new Wrapper<String>("hello");
    //here you have string
    String el1 = varWrapper.getElement();

    //Raw use of parameterized class 'Wrapper'
    Wrapper rawWrapper = new Wrapper<String>("hello");
    //note that you get an Object, not a String!
    Object el2 = rawWrapper.getElement();

    //even with wildcard
    Wrapper<?> wildCardWrapper = new Wrapper<>("hello");
    Object el3 = wildCardWrapper.getElement();

    //even with wildcard
    Wrapper<?> wildCardWrapperWithGenerics = new Wrapper<String>("hello");
    //again an object
    Object el4 = wildCardWrapperWithGenerics.getElement();

    Wrapper<? extends String> wildCardWrapperWithGenericsExtends = new Wrapper<>("hello");
    //here I have a String
    String el5 = wildCardWrapperWithGenericsExtends.getElement();
  }


}


class Wrapper<T> {

  private final T element;

  Wrapper(T element) {
    this.element = element;
  }

  public T getElement() {
    return element;
  }
}