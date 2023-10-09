package org.enricogiurin.ocp17.ch14;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

  public static void main(String[] args) throws IOException {
    new UserInput().console();
  }

  void readFromInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Type your name: ");
    String input = reader.readLine();
    System.out.println("your name is: " + input);
  }


  void console() {
    Console console = System.console();
    if (console != null) {
      String input = console.readLine("Type your name: ");
      System.out.println("your name is: " + input);
      char[] pwd = console.readPassword("Type your pwd: ");
      //not really secure this code :-)
      System.out.println("your pwd is: " + new String(pwd));
    }
  }



}
