package org.enricogiurin.ocp17.book.ch14;

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
    //new FilesCopyStream().copyOutputStream();
    new FilesCopyStream().copyInputStream();
  }

  void copyInputStream() throws IOException {
    Path out = Path.of("/tmp/sentences.txt");
    //copy files
    try (InputStream resourceAsStream = getClass().getResourceAsStream("/files/sentences.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream)) {
      long bytesRead = Files.copy(bufferedInputStream, out, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("bytes read: %s".formatted(bytesRead));  //43
    }
  }

  void copyOutputStream() throws IOException {
    Path source = Path.of("/tmp/a.txt");

    try (OutputStream outputStream = new FileOutputStream("/tmp/b.txt")) {
      long bytes = Files.copy(source, outputStream);
      System.out.println("written " + bytes + " bytes");
    }
  }

}
