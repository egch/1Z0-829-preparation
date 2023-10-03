package org.enricogiurin.ocp17.ch14;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyIOStream {

  public static void main(String[] args) throws IOException {
    new CopyIOStream().copyInputStream();
  }

  void copyInputStream() throws IOException {
    try (InputStream resourceAsStream = getClass().getClassLoader()
        .getResourceAsStream("files/sentences.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream)) {
      Path target = Path.of("/tmp/sentences.txt");
      long bytes = Files.copy(bufferedInputStream, target, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("written " + bytes + " bytes");
    }
  }

  //TODO - to be completed

  void copyOutputStream() {
    Path source = Path.of("files/sentences.txt");


  }

}
