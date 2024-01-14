package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive.mixed;

import java.util.function.ObjDoubleConsumer;

public class UsageOfObjDoubleConsumer {

  public static void main(String[] args) {
    new UsageOfObjDoubleConsumer().use();
  }

  void use() {
    ObjDoubleConsumer<String> fi = (d, s) -> System.out.println("double: " + d + " obj: " + s);
    fi.accept("hello", 4.5D); //hello obj: 4.5
  }

}
