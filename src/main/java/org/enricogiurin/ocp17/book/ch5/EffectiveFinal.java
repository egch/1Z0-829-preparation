package org.enricogiurin.ocp17.book.ch5;

public class EffectiveFinal {

  public void feed() {
    //this is not effective final, as it's changed later
    int monkey = 0;
    if (monkey > 0) {
      //giraffe is effective final
      var giraffe = monkey++;
      String name;
      //name is effective final
      name = "geoffrey";
    }
    //this is not effective final, as it's changed later
    String name = "milly";
    //food is not effective final
    var food = 10;
    while (monkey <= 10) {
      food = 0;
    }
    name = null;
  }
}
