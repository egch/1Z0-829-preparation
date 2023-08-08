package org.enricogiurin.ocp17.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvePaths {

  public static void main(String[] args) throws IOException {
    new ResolvePaths().resolveFolderExisting();
  }

  void resolve() {
    Path path1 = Path.of("/folderA/folderB/file");  //absolute path
    Path path2 = Path.of("folderC"); //relative path
    System.out.println("path1: " + path1);
    System.out.println("path2: " + path2);
    ///folderA/folderB/file/folderC
    System.out.println("p1 resolve to p2: "+path1.resolve(path2));
    // /folderA/folderB/file  (
    System.out.println("p2 resolve to p1: "+path2.resolve(path1));
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

  //we assume the link exist and also the corresponding target folder /tmp/a/b
  //when executed the second time it throws an exception
  //Exception in thread "main" java.nio.file.FileAlreadyExistsException: /tmp/link/joey
  ///tmp/a/b/joey

  void resolveFolderExisting() throws IOException {
    var path = Paths.get("/tmp/link");
    if(Files.isDirectory(path) && Files.isSymbolicLink(path))
      Files.createDirectory(path.resolve("joey"));
  }

}
