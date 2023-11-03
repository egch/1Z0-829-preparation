package org.enricogiurin.ocp17.book.ch5;

public class Vararg {

  public static void main(String[] args) {
    // new Vararg().sumElement(1,2,3);
    // new Vararg().sumElement(new int[]{});
    new Vararg().sumElement(new int[]{4, 5});
  }

  void sumElement(int... elements) {
    int result = 0;
    for (int element : elements) {
      result += element;
    }
    System.out.println("result is: " + result);
  }

}
