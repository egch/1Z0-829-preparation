package org.enricogiurin.ocp17.book.ch7.nested.staticnested;

public class ClassWithNestedStatic {

  private int count;
  private static int staticField = 5;

  static class StaticNested {

    public int stampede() {
      //on-static field 'count' cannot be referenced from a static context
      //it cannot access the instance member count.

      //but I can access to static field although private
      System.out.println(staticField);

      // return count;  //DOES NOT COMPILE!
      return 0;
    }
  }
}