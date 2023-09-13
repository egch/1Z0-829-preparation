package org.enricogiurin.ocp17.ch5;

import static java.util.Arrays.asList;

public class ImportStatic {

  public static void main(String[] args) {
    //does not compile as the Arrays class is not imported
    // Arrays.asList("enrico");
    asList("enrico");
  }

}
