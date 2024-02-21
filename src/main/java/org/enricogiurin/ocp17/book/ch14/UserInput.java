package org.enricogiurin.ocp17.book.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * To execute this code type from cli: $ java -cp target/classes
 * org.enricogiurin.ocp17.book.ch14.UserInput
 */
public class UserInput {

  public static void main(String[] args) throws IOException {
    new UserInput().readFromInput();
  }

  void readFromInput() throws IOException {
    //While System.console() throws a NullPointerException if it is not available,
    // System.in DOES NOT,
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print("Type your name: ");
      String input = reader.readLine();
      System.out.println("your name is: " + input);
    }
  }


}
