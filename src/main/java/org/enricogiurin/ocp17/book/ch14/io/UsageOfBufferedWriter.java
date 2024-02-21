package org.enricogiurin.ocp17.book.ch14.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsageOfBufferedWriter {

  public static void main(String[] args) throws IOException {
    new UsageOfBufferedWriter().write();
  }

  //check with $cat /tmp/example.txt
  void write() throws IOException {
    String outFile = "/tmp/example.txt";
    try (FileWriter fw = new FileWriter(outFile);
        BufferedWriter bw = new BufferedWriter(fw)) {
      bw.write("hello,");
      bw.newLine();
      bw.write("World");
      bw.newLine();
    }
  }

}
