package org.enricogiurin.ocp17.book.ch3;

import java.util.List;

public class WhileNestedLoopWithLabels {

  public static void main(String[] args) {
    new WhileNestedLoopWithLabels().breakWhile();
  }

  //17_JDK
  //17_Java
  void breakWhile() {
    final var javaVersions = List.of(17, 11, 8);
    var names = List.of("JDK", "Java");
    Outer:
    for (var e1 : javaVersions) {
      Inner:
      for (String e2 : names) {
        System.out.println(e1 + "_" + e2);
      }
      //note there ain't parenthesis
      break; //this breaks affects the Outer loop, not the Inner

    }
  }

}
