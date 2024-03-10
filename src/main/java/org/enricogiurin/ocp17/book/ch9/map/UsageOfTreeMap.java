package org.enricogiurin.ocp17.book.ch9.map;

import java.util.Map;
import java.util.TreeMap;

public class UsageOfTreeMap {

  public static void main(String[] args) {
    new UsageOfTreeMap().keysAsRecord();
  }

  /**
   * This will throw ClassCastException because the keys of a TreeMap must be mutually comparable.
   * I start to add Integer then I add String as a key.
   *
   */
  void nonGenerics() {
    Map map = new TreeMap<>();
    map.put(1, "2");
    //java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
    map.put("hello", "2");
    System.out.println(map);
  }

  /**
   * Wrapper does not implement Comparable so as soon as I add an element
   * it will throw a ClassCastException.
   */

  void keysNotComparable() {
    class Wrapper {
      int n;
      public Wrapper(int n) {
        this.n = n;
      }
    }
    Map<Wrapper, String> map = new TreeMap<>();
    // java.lang.ClassCastException: class org.enricogiurin.ocp17.book.ch9.map.UsageOfTreeMap$1Wrapper
    // cannot be cast to class java.lang.Comparable (org.enricogiurin.ocp17.book.ch9.map.UsageOfTreeMap$1Wrapper
    map.put(new Wrapper(12), "hello");
  }

  /**
   * You need to explicitly implement Comparable in your record.
   * which is: record does not implement Comparable by default.
   */

  void keysAsRecord() {
    record Name(String name){}
    Map<Name, String> map = new TreeMap<>();
    //Exception in thread "main" java.lang.ClassCastException: class org.enricogiurin.ocp17.book.ch9.map.UsageOfTreeMap$1Name cannot be cast to class java.lang.Comparable
    map.put(new Name("john"), "Doe");
  }


}
