package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BrowsingPaths {

  public static void main(String[] args) throws IOException {
    new BrowsingPaths().findFileWithinADirectory();
  }

  void list() throws IOException {
    Path currentDir = Path.of(".");
    Stream<Path> stream = Files.list(currentDir);
    stream
        .filter(path -> Files.isRegularFile(path))
        .forEach(System.out::println);
    //./LICENSE
    //./pom.xml
    //./README.md
    //./.gitignore
  }

  //File found: /Users/enrico/github/ocp17/1Z0-829-preparation/./src/main/java/org/enricogiurin/ocp17/ch10/UseOfOptional.java
  void findFileWithinADirectory() throws IOException {
    Path dir = Path.of(".");
    Path pathToSearch = Path.of("UsageOfOptional.java");
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
