package org.enricogiurin.ocp17.book.ch14.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UsageOfPrintWriter {

  public static void main(String[] args) throws IOException {
    new UsageOfPrintWriter().copy();
  }

  void copy() throws IOException {
    File source = new File(".gitignore");
    File dest = new File("/tmp/copy-ignore");
    try (FileReader fileReader = new FileReader(source);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter printWriter = new PrintWriter(dest)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        printWriter.println(line);
      }
    }
  }

}
