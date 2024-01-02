package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
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

  //File found: /Users/enrico/github/ocp17/1Z0-829-preparation/./src/main/java/org/enricogiurin/ocp17/ch10/UseOfOptional.java
  void findFileWithinADirectory() throws IOException {
    Path dir = Path.of(".");
    Path pathToSearch = Path.of("UseOfOptional.java");
    BiPredicate<Path, BasicFileAttributes> matcher = (path, attr) -> attr.isRegularFile() &&
        path.getFileName().toString().equals(pathToSearch.getFileName().toString());

    Files.find(dir, Integer.MAX_VALUE, matcher)
        .forEach(file -> System.out.println("File found: " + file.toAbsolutePath()));
  }


  //TODO - review this
  void findSymbolicLink() throws IOException {
    var f = Path.of("/tmp");
    try (Stream<Path> stream = Files.find(f, 10, (p, a) -> a.isSymbolicLink())) { // y1
      stream.map(s -> s.toString())
          .peek(System.out::println)
          .collect(Collectors.toList())
          .stream()
          //   .filter(s -> s.toString().endsWith(".txt")) // y2
          .forEach(System.out::println);
    }
  }


}
