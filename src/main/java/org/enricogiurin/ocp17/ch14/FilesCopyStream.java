package org.enricogiurin.ocp17.ch14;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesCopyStream {

  public static void main(String[] args) throws IOException {
    new FilesCopyStream().copyOutputStream();
  }

  void copyInputStream() throws IOException {
    try (InputStream resourceAsStream = getClass().getClassLoader()
        .getResourceAsStream("files/sentences.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream)) {
      Path target = Path.of("/tmp/sentences.txt");
      long bytes = Files.copy(bufferedInputStream, target, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("read " + bytes + " bytes");
    }
  }


  void copyOutputStream() throws IOException {
    Path source = Path.of("/tmp/a.txt");

    try( OutputStream outputStream = new FileOutputStream("/tmp/b.txt")){
      long bytes = Files.copy(source, outputStream);
      System.out.println("written " + bytes + " bytes");
    }
  }

}
