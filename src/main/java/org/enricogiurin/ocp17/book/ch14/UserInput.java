package org.enricogiurin.ocp17.book.ch14;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * To execute this code type from cli:
 * $ java -cp target/classes org.enricogiurin.ocp17.book.ch14.UserInput
 */
public class UserInput {

  public static void main(String[] args) throws IOException {
    new UserInput().console_reader();
  }

  void readFromInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Type your name: ");
    String input = reader.readLine();
    System.out.println("your name is: " + input);
  }


  //using console.readLine() we do not need to declare any
  //checked exception
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

  //with this we throw the IOException
  void console_reader() throws IOException {
    Console console = System.console();
    if(console==null) {
      throw new RuntimeException("console is null");
    }
    System.out.print("Type your name: ");
    Reader reader = console.reader();
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line = bufferedReader.readLine();
    System.out.println("your name is %s".formatted(line));
  }


}
