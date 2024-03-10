package org.enricogiurin.ocp17.book.ch9.generics;

import java.util.ArrayList;
import java.util.List;

public class ComplexInheritanceWithGenerics {


  class Parent {

    public <T> List<T> createList(List<T> list) {
      return new ArrayList<T>();
    }
  }

  class Child extends Parent {
    //not valid,
/*
    @Override
    public ArrayList<Object> createList(List<Object> list) {
      return new ArrayList<Object>();
    }
*/

    //valid
    @Override
    public <T> ArrayList<T> createList(List<T> list) {
      return new ArrayList<T>();
    }

  }
}
