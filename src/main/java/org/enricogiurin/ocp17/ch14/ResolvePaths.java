package org.enricogiurin.ocp17.ch14;

import java.io.IOException;
import java.nio.file.Path;

public class ResolvePaths {

  public static void main(String[] args) throws IOException {
    new ResolvePaths().toRealPathNotExisting();
  }

  void resolve() {
    Path path1 = Path.of("/folderA/folderB/file");  //absolute path
    Path path2 = Path.of("folderC"); //relative path
    System.out.println("path: " + path1);
    System.out.println("path: " + path2);
    ///folderA/folderB/file/folderC
    System.out.println(path1.resolve(path2));
    // /folderA/folderB/file  (
    System.out.println(path2.resolve(path1));
  }

  void relativize() {
    Path path1 = Path.of("fish.txt");
    Path path2 = Path.of("friendly/birds.txt");
    //  ../friendly/birds.txt
    System.out.println(path1.relativize(path2));
    // ../../fish.txt
    System.out.println(path2.relativize(path1));
  }

  void relativize_absolute() {
    Path path1 = Path.of("tmp/fish.txt");
    Path path2 = Path.of("/user/friendly/birds.txt");
    //  ../friendly/birds.txt
    System.out.println(path1.relativize(path2));
    // ../../fish.txt
    System.out.println(path2.relativize(path1));
  }

  void toRealPath() throws IOException {
    Path pom = Path.of("pom.xml");
    Path pom2 = Path.of("../1Z0-829-preparation/pom.xml");
    ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println(pom.toRealPath());
    ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println(pom2.toRealPath());
  }

  void toRealPathNotExisting() throws IOException {
    Path notAFile = Path.of("cicciopasticcio.txt");

    //Exception in thread "main" java.nio.file.NoSuchFileException: cicciopasticcio.txt
    System.out.println(notAFile.toRealPath());
  }

}
