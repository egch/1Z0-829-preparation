package org.enricogiurin.ocp17.book.ch14;

import java.io.PrintStream;

public class UsageOfPrintStream {

  public static void main(String[] args) {
    new UsageOfPrintStream().error();
  }

  void close() {
    try (PrintStream out = System.out) {
      out.println("this will be printed!");
    }
    //this won't be printed because I close the stream
    //in the try resources
    System.out.println("this won't be printed!");
  }

  void error() {
    try (PrintStream err = System.err) {
      err.println("this will be printed!");
    }
    //this won't be printed because I close the stream
    //in the try resources
    System.err.println("this won't be printed!");
  }

}
