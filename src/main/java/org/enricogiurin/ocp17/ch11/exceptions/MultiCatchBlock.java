package org.enricogiurin.ocp17.ch11.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiCatchBlock {

  public static void main(String[] args) {
    new MultiCatchBlock().parse();
  }

  void parse() {
    String[] array = {"a"};
    try {
      Integer.parseInt(array[1]);
    }catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      e.printStackTrace();
    }
  }

  void wrongMultiCatch() {
    try {
      FileReader fileReader = new FileReader("/tmp/a");

      fileReader.close();
      //Types in multi-catch must be disjoint: 'java.io.FileNotFoundException' is a subclass of 'java.io.IOException'
      /*} catch (IOException | FileNotFoundException e) { */
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

}
