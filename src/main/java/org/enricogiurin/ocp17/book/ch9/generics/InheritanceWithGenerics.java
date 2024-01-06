package org.enricogiurin.ocp17.book.ch9.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InheritanceWithGenerics {

  class Parent {
    public <T extends Number, Z extends Number> Map<T, Z> createMap(T t, Z z) {
      return new HashMap<T, Z>();
    }
  }

  class Child extends Parent {
    //this is not an override of the method createMap() in the class Parent
    //but it is an overload. The signature is different ... although it is weird
    public <T, Z> TreeMap<T, Z> createMap(T t, Z z)  {
      return new TreeMap<T, Z>();
    }

  }

}
