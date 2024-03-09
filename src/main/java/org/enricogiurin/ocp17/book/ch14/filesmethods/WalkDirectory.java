package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class WalkDirectory {

  public static void main(String[] args) throws IOException {
    new WalkDirectory().walkAndPrintRealPath();
  }

  void getSize() throws IOException {
    Path path = Path.of("pom.xml");
    long size = Files.size(path);
    //size is: 1216 bytes
    System.out.println("size is: " + size + " bytes");
  }

  //print all the files within the current dir and the subdir
  void walk() throws IOException {
    Path path = Path.of(".");
    try (Stream<Path> stream = Files.walk(path)) {
      stream.forEach(System.out::println);
    }
  }

  void walkDepthLimit() throws IOException {
    Path path = Path.of(".");

    //max file/dir at the depth 5
    try (Stream<Path> stream = Files.walk(path, 5)) {
      stream.forEach(System.out::println);
    }
  }

  void walkAndPrintRealPath() throws IOException {
    Path path = Path.of(".");
    final AtomicLong cnt = new AtomicLong(0);
    try (Stream<Path> pathStream = Files.walk(path)) {
      pathStream.forEach(p -> {
        try {
          cnt.incrementAndGet();
          Path realPath = p.toRealPath();
          System.out.println(realPath);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      });
    }
    //6367 files to date
    System.out.println("counted %s files".formatted(cnt.get()));
  }




}
