package org.enricogiurin.ocp17.book.ch7.sealed;

public class SameFile {

}

//Bird is sealed

sealed class Bird {

  //The permits clause is optional if the subclass is nested or declared in the same file.
  public final class Flamingo extends Bird {

  }
}

//The permits clause is optional if the subclass is nested or declared in the same file.
final class Sparrow extends Bird {

}