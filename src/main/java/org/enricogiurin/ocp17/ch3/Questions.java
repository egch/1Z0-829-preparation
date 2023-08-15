package org.enricogiurin.ocp17.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Questions {

  public static void main(String[] args) {
    //new Questions().supportedType();
    new Questions().printAll();
  }

  void supportedType() {
    var x = new Random().nextInt(11);
    switch (x) {
      case 0:
        System.out.println("is zero");
        break;
      default:
        System.out.println("is greater than zero");

    }
  }

  void printReptile(int category) {
    var type = switch (category) {
      case 1, 2 -> "Snake";
      case 3, 4 -> "Lizard";
      case 5, 6 -> "Turtle";
      case 7, 8 -> "Alligator";
      //we need the default otherwise it won't compile
      default -> "unknown";
    };
    System.out.print(type);
  }

  void codeNotReachable() {
    List<Integer> myFavoriteNumbers = new ArrayList<>();
    myFavoriteNumbers.add(10);
    myFavoriteNumbers.add(14);
    for (var a : myFavoriteNumbers) {
      System.out.print(a + ", ");
      break;
    }
    for (int b : myFavoriteNumbers) {

      continue;
      //this code won't compile if adding the following line
      //Unreachable statement
      //System.out.print(b + ", ");
    }
    for (Object c : myFavoriteNumbers) {
      System.out.print(c + ", ");
    }

  }

  void printAll() {
    int[] array = new int[]{0, 1, 2, 3};

    for (int i = 0; i <= array.length - 1; ++i) {

      System.out.println(i + ": " + array[i]);
    }
  }

  void notInScope(Object fish) {
    if (!(fish instanceof String guppy)) {
      System.out.print("Eat!");
    }

    //guppy is still in the scope here
    // else if (!(fish instanceof String guppy)) {
    //       throw new RuntimeException(); }
    System.out.print("Swim!");

  }


}
