package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MethodsOfPath {

  public static void main(String[] args) throws IOException {
    // new MethodsOfPath().report();
    // new MethodsOfPath().list();
    new MethodsOfPath().subPath();
  }

  void report() throws IOException {
    //relative path
    Path pom = Path.of("pom.xml");
    System.out.println(pom.isAbsolute());
    System.out.println(Files.isDirectory(pom));
    ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println(pom.toAbsolutePath());
    System.out.println(pom.getParent());

    //true
    if (Files.isRegularFile(pom)) {
      //977
      System.out.println(Files.size(pom));
      //2023-04-19T21:15:14.783684507Z
      System.out.println(Files.getLastModifiedTime(pom));
    }
  }

  void list() throws IOException {
    Path tmp = Path.of("/tmp");
    if (Files.isDirectory(tmp)) {
      try (Stream<Path> stream = Files.list(tmp)) {
        //some files present in the /tmp folder
        stream.forEach(path -> System.out.println(path.getFileName()));
      }
    }
  }

  void nameCount() {
    Path pom = Path.of("pom.xml");
    //path are immutable so left assign it
    pom = pom.toAbsolutePath();
    if (Files.exists(pom)) {
      System.out.println("path: " + pom);
      System.out.println("size of names: " + pom.getNameCount());
      for (int j = 0; j < pom.getNameCount(); j++) {
        System.out.println(pom.getName(j));
      }
    }
  }

  void subPath() {
    Path pom = Path.of("pom.xml").toAbsolutePath();
    //  /Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println("path: " + pom);
    //6
    System.out.println("size of names: " + pom.getNameCount());
    //Users/enrico/github
    System.out.println("sub-path[0,3]: " + pom.subpath(0, 3));

    //github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println("sub-path[2,3]: " + pom.subpath(2, 3));

    try {
      //it's start inclusive, end exclusive so there ain't sub-path from 2 to 1
      pom.subpath(2, 2);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  void subPath2() {
    var p2 = Paths.get("/zoo/animals/bear/koala/food.txt");
    //                       0     1      2    3     4
    System.out.println(p2.subpath(1, 3).getName(1));
  }

  void pathElements() {
    Path pom = Path.of("pom.xml").toAbsolutePath();
    System.out.println("path: " + pom);
    //pom.xml
    System.out.println("file name: " + pom.getFileName());
    ///Users/enrico/github/ocp17/1Z0-829-preparation
    System.out.println("folder name: " + pom.getParent());
    // /
    System.out.println("root name: " + pom.getRoot());
  }
}
