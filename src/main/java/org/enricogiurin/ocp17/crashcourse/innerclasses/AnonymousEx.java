package org.enricogiurin.ocp17.crashcourse.innerclasses;

import java.util.function.Predicate;

public class AnonymousEx {
  public void doStuff() {
    int len = 3;
    // parent type can be class, abstract class, or interface
    // if parent is a class (incl abstract) we can pass
    // constructor args
    // Lifetime (also for lambdas) is governed by reachability and GC
    // But, lifetime of len (above) would normally be method invocation
    Predicate<String> ps = new Predicate<String>() {
      // declare arbitrary fields, methods, etc.

      private int x = 99;

      @Override
      public String toString() {
        return "Hah, I'm a anonymous";
      }

      @Override
      public boolean test(String s) {
//        len ++;
        return s.length() > len; // line n1
      }
    };
    // line n2
  }
}
