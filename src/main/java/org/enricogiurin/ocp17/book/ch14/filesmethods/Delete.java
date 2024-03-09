package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Delete {

  public static void main(String[] args) throws IOException {
    new Delete().deleteIfExist();
  }

  //it throws a NoSuchFileException if the file or directory does not exist
  void delete() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    Files.delete(pippo);
  }

  //mind the IOException!
  void deleteIfExist() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    boolean deleted = Files.deleteIfExists(pippo);
    System.out.println(deleted);
  }

}
