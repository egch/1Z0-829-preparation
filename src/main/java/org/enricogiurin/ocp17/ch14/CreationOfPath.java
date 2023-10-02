package org.enricogiurin.ocp17.ch14;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreationOfPath {

  public static void main(String[] args) {
    new CreationOfPath().fileSystems();
  }
  void pathOf(){
    Path path = Path.of("/tmp", "/subfolder", "fileName.txt");
    System.out.println(path);
  }

  void pathsGet(){
    Path path = Paths.get("/folderA", "folderB", "file");
    System.out.println(path);
  }

  //Paths.get() and Path.of() are shortcuts for this FileSystem method.
  void fileSystems() {
    Path path = FileSystems.getDefault().getPath("first", "second", "third");
    System.out.println(path);
  }

}
