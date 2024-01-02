package org.enricogiurin.ocp17.book.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemErrClosed {

  public static void main(String[] args) throws IOException {
    //you need to enter some chars to make it working
    //new SystemErrClosed().exceptionSystemErrIsClosed();
    new SystemErrClosed().exceptionSystemErrIsClosed();
  }

  //here the System.err is closed because defined in the try with
  //so the exception generated on line : var fetchAgain
  //is not logged in the System.err
  void exceptionSystemErrIsClosed() throws IOException {
    var retriever = new BufferedReader(new InputStreamReader(System.in));
    //you can see that we get the Syste,err within the try-with-resource
    try (retriever; var sErr = System.err) {
      String fetch = retriever.readLine();
      System.out.println("line: %s".formatted(fetch));
    }
    var fetchAgain = retriever.readLine();
    System.out.println(fetchAgain + " fetched again!");
  }

  //here the system err is closed so the exception generated on line: var fetchAgain
  //is logged in the System.err and we have this:
  //fetched in   4.2 secondsException in thread "main" java.io.IOException: Stream closed

  void exceptionButSystemErrIsNotClosed() throws IOException {
    var retriever = new BufferedReader(new InputStreamReader(System.in));
    //here I have commented out the line to get the System.err
    try (retriever; /*var husky = System.err*/) {
      String fetch = retriever.readLine();
      System.out.println("line: %s".formatted(fetch));
    }
    var fetchAgain = retriever.readLine();
    System.out.println(fetchAgain + " fetched again!");
  }

}
