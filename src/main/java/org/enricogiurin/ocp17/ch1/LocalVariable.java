package org.enricogiurin.ocp17.ch1;

public class LocalVariable {

  //this compiles
  void local() {
    int x = 5;
    int y;
    if (x < 5) {
      y = 2;
    } else {
      y = 7;
    }
  }

  //this compiles
  void local_wrong() {
    int x = 5;
    int y;
    //does not compile: Variable 'y' might not have been initialized
    //int z=x+y;

  }
}
