package org.enricogiurin.ocp17.ch14.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadWriteFile {

  public static void main(String[] args) throws IOException {
    new ReadWriteFile().echo();
  }

  private void echo() throws IOException {
    var o = new FileWriter("/tmp/new-zoo.txt");
    try (var f = new FileReader("/tmp/zoo-data.txt");
        var b = new BufferedReader(f);
        o) {
      o.write(b.readLine());
    }//here I close the try-with-resources
    //at this point the stream is closed (try with resources)
    //Exception in thread "main" java.io.IOException: Stream closed

    //the file /tmp/new-zoo.txt will contain a single text line
    o.write("");
  }

}
