package org.enricogiurin.ocp17.ch7.nested;

public class ClassWithNestedStatic {

  private int count;

  static class StaticNested {

    public int stampede() {
      //on-static field 'count' cannot be referenced from a static context
      // return count;

      return 0;
    }
  }
}