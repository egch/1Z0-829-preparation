package org.enricogiurin.ocp17.book.ch1;

public class UseOfUnderscore {

  public static void main(String[] args) {
    new UseOfUnderscore().useOfUnderscore();
  }

  void useOfUnderscore() {
    //this is a valid use of underscore.
    var x = 5_______1;
    System.out.println(x);
  }
}
