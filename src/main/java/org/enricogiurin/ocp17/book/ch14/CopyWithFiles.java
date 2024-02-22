package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class CopyWithFiles {

  public static void main(String[] args) throws IOException {
    new CopyWithFiles().readAllBytes();
  }

  void readStringAndWriteString() throws IOException {
    Path pom = Path.of("pom.xml");
    Path dest = Path.of("/tmp/pom-copied.xml");
    String contents = Files.readString(pom);
    Files.writeString(dest, contents);
  }

  void readAllBytes() throws IOException {
    Path pom = Path.of("pom.xml");

    byte[] bytes = Files.readAllBytes(pom);
    System.out.println("read %d bytes".formatted(bytes.length));
  }

  void copyByLines() throws IOException {
    Path pom = Path.of("pom.xml");
    Path dest = Path.of("/tmp/" + System.currentTimeMillis() + "_pom.xml");
    //note: this returns a list, not a stream. And this is all in memory
    List<String> listOfLines = Files.readAllLines(pom);
    Files.write(dest, listOfLines);
  }

  //to avoid OutOfMemoryError
  void readLazy() throws IOException {
    Path pom = Path.of("pom.xml");
    Path dest = Path.of("/tmp/" + System.currentTimeMillis() + "_pom.xml");
    //here we have a stream
    try (Stream<String> stream = Files.lines(pom)) {
      stream
          .peek(System.out::println)
          .forEach(s -> {
            try {
              Files.writeString(dest, s);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
    }
  }

  void bufferedWithFiles() throws IOException {
    Path pom = Path.of("pom.xml");
    Path dest = Path.of("/tmp/" + System.currentTimeMillis() + "_pom.xml");
    try (var reader = Files.newBufferedReader(pom);
        var writer = Files.newBufferedWriter(dest)) {
      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
      }
    }
  }
}
