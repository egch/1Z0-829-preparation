package org.enricogiurin.ocp17.ch5;

public class RopeSwing {

  private static final String leftRope;
  private static final String rightRope;
  //Variable 'bench' might not have been initialized
  //   private static final String bench;
  private static final String name = "name";

  static {
    leftRope = "left";
    rightRope = "right";
  }

  static {
    //compilation issue - Cannot assign a value to final variable 'name'
    //name = "name";

    //compilation issue - Cannot assign a value to final variable 'rightRope'
    //rightRope = "right";
  }

  public static void main(String[] args) {
    // bench = "bench";
  }
}