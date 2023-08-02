package org.enricogiurin.ocp17.ch14;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserInput {

  public static void main(String[] args) throws IOException {
    new UserInput().mark();
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
      System.out.print("Type your name: ");
      String input = console.readLine();
      System.out.println("your name is: " + input);
    }
  }

  void mark() throws IOException {
    final String name = "enrico";
    try (InputStream inputStream = new ByteArrayInputStream(name.getBytes())) {
      if (inputStream.markSupported()) {
        inputStream.mark(1);
        System.out.println((char) inputStream.read());
        System.out.println((char) inputStream.read());
        inputStream.reset();
      }
      System.out.println((char) inputStream.read());
      System.out.println((char) inputStream.read());
    }

  }

}
