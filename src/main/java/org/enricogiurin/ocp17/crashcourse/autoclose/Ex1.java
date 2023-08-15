package org.enricogiurin.ocp17.crashcourse.autoclose;

class AC implements AutoCloseable {

  private String name;

  public AC(String name) {
    this.name = name;
  }

  @Override
  public void close() {
    System.out.print("Closing " + name);
  }
}

public class Ex1 {

  public static void main(String[] args) {
    var ac0 = new AC("zero");
    try (
        var ac1 = new AC("one");
        var ac2 = new AC("two");
        ac0;
    ) {
    }
//    ac0 = null; // must be final or effectively final!
  }
}
