package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadLines {

  public static void main(String[] args) throws IOException {
    new ReadLines().lines();
  }

  void lines() throws IOException {
    //it returns a stream
    Stream<String> lines = Files.lines(Path.of("pom.xml"));
    lines.forEach(System.out::println);
  }

  void readAllLines() throws IOException {
    //it returns a list in memory
    List<String> list = Files.readAllLines(Path.of("pom.xml"));
    list.forEach(System.out::println);
  }

}
