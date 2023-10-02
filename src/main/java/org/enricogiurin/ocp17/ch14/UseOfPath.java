package org.enricogiurin.ocp17.ch14;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UseOfPath {

  public static void main(String[] args) throws IOException {
    //new FileAndPath().file();
    //new FileAndPath().path();
    UseOfPath useOfPath = new UseOfPath();
    useOfPath.infoPath(Path.of("/tmp/a.txt"));
  }



  //same as org/enricogiurin/ocp17/ch14/io/MethodsOfFile.java
  //but with Path
  void infoPath(Path path) throws IOException {
    if(Files.exists(path)){
      System.out.println("absolute path: "+path.toAbsolutePath());
      System.out.println("is Directory: "+Files.isDirectory(path));
      System.out.println("parent path: "+path.getParent());
      if(Files.isRegularFile(path)){
        System.out.println("length: "+Files.size(path));
        System.out.println("last modified: "+Files.getLastModifiedTime(path));
      }else{
        try(Stream<Path> stream = Files.list(path)) {
          stream.forEach(System.out::println);
        }
      }
    }
  }



  void fileToPath() {
    File tmp = new File("/tmp");
    //file to path
    Path path = tmp.toPath();
    //path to file
    File tmp2 = path.toFile();
  }
}
