package org.enricogiurin.ocp17.book.ch2;

public class ReturnValueOfAssignment {

  public static void main(String[] args) {
    new ReturnValueOfAssignment().trickyCheck();
  }


  void trickyCheck() {
    boolean healthy = false;
    //in this case healthy is assigned to true so true is returned
    if (healthy = true) {
      System.out.println("I am healthy");
    }
  }
}
