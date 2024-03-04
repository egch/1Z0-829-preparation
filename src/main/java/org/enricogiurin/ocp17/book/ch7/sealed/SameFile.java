package org.enricogiurin.ocp17.book.ch7.sealed;

public class SameFile {
}

//

/**
 * Bird is sealed.
 * The permits clause is optional if the subclass is nested or declared in the same file.

 */
sealed class Bird {

  //nested class
  public final class Flamingo extends Bird {

  }
}

//same file
final class Sparrow extends Bird {

}