package org.enricogiurin.ocp17.crashcourse.casting;

class Pair<E> {
  private E left;
  private E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public boolean equals(Object other) {
//    if (other instanceof Pair otherP) {
//      return this.left == otherP.left &&
//          this.right == otherP.right;
//    }
//    else return false;
    return other instanceof Pair otherP &&
        this.left == otherP.left &&
        this.right == otherP.right;
  }
}

public class Pattern2 {
}
