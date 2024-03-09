package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateDirectories {

  public static void main(String[] args) throws IOException {
    new CreateDirectories().createDirectory();
  }

  //if the folder already exists:
  // Exception in thread "main" java.nio.file.FileAlreadyExistsException: /tmp/aaa
  void createDirectory() throws IOException {
    Path aaa = Path.of("/tmp/aaa");
    Path directory = Files.createDirectory(aaa);
    System.out.println(directory);
  }

  //this won't throw an exception if the directory already exists
  void createDirectories() throws IOException {
    Path aaa = Path.of("/tmp/aaa");
    Path directory = Files.createDirectories(aaa);
    System.out.println(directory);
  }

  //this won't throw an exception if the directory already exists
  void createNotExistingDirectories() throws IOException {
    Path aaa = Path.of("/tmp/aaa");
    Path directory = Files.createDirectories(aaa);
    System.out.println(directory);
  }

}
