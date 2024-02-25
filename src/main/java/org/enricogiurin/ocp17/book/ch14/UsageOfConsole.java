package org.enricogiurin.ocp17.book.ch14;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Usage: $ java -cp target/ocp17-preparation-1.0-SNAPSHOT.jar
 * org.enricogiurin.ocp17.book.ch14.UsageOfConsole
 */
public class UsageOfConsole {

  public static void main(String[] args) throws IOException {
    new UsageOfConsole().console();
  }


  //using console.readLine() we do not need to declare any
  //checked exception
  void console() {
    Console console = System.console();
    if (console == null) {
      throw new RuntimeException("console is null");
    }
    String input = console.readLine("Type your name: ");
    try (PrintWriter writer = console.writer()) {
      writer.println("your name is: " + input);
      char[] pwd = console.readPassword("Type your pwd: ");
      //not really secure this code :-)
      System.out.println("your pwd is: " + new String(pwd));
    }
  }

  //we need this throws IOE
  void console2() throws IOException {
    String line;
    var c = System.console();
    Writer w = c.writer();
    //writer.close() throws IOE
    //Writer is abstract but implements Closeable which throws IOE
    try (w) {
      if ((line = c.readLine("Enter your username: ")) != null)
      //this throws IOE
      {
        w.append(line);
      }
      ////this throws IOE
      w.flush();
    }
  }

  //with this we throw the IOException
  void console_reader() throws IOException {
    Console console = System.console();
    if (console == null) {
      throw new RuntimeException("console is null");
    }
    System.out.print("Type your name: ");
    try (Reader reader = console.reader();
        //does not exist!
        //reader.readLine() ;  //does NOT compile

        BufferedReader bufferedReader = new BufferedReader(reader);
        PrintWriter writer = console.writer()) {
      String line = bufferedReader.readLine();
      writer.println("your name is %s".formatted(line));
    }
  }

}
