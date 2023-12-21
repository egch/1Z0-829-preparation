package org.enricogiurin.ocp17.book.ch5;

public class MethodMatchingOverloading {

  public static void main(String[] args) {
    //double
    //int
    new MethodMatchingOverloading().matchPrimitive();

  }

  void matchPrimitive() {
    //there is no exact match, choose(float f), Java attempts to promote the primitive type
    // to double before trying to wrap it as a Float,
    choose(2F);
    choose((byte) 2 + 1);
  }

  private void choose(int choice) {
    System.out.println("int");
  }

  private void choose(short choice) {
    System.out.println("short");
  }

  private void choose(long choice) {
    System.out.println("long");
  }

  private void choose(double choice) {
    System.out.println("double");
  }

  private void choose(Float choice) {
    System.out.println("Float");
  }

}
