package org.enricogiurin.ocp17.ch14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IOStream {

  public static void main(String[] args) throws IOException {
    new IOStream().copyTextFile();
  }

  void copyTextFile() throws IOException {
    File src = new File("pom.xml");
    File dest = new File("/tmp/pom.xml");
    try (var reader = new BufferedReader(new FileReader(src));
        var writer = new PrintWriter(dest)) {
      String line;
      while ((line = reader.readLine()) != null) {
        writer.println(line);
      }
    }
  }


}


