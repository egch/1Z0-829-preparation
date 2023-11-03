package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class CopyAndMoveFiles {

  public static void main(String[] args) throws IOException {
    new CopyAndMoveFiles().copy_replace();
  }

  //if file already exist
  //Exception in thread "main" java.nio.file.FileAlreadyExistsException: /tmp/pom.xml
  void copy() throws IOException {
    Path pom = Path.of("pom.xml");
    Path target = Path.of("/tmp/pom.xml");
    ///tmp/pom.xml
    Path copy = Files.copy(pom, target);
    System.out.println(copy);
  }

  void copy_replace() throws IOException {
    Path pom = Path.of("pom.xml");
    Path target = Path.of("/tmp/pom.xml");
    ///tmp/pom.xml
    //replace the existing, no exception is thrown
    Path copy = Files.copy(pom, target, StandardCopyOption.REPLACE_EXISTING);
    System.out.println(copy);
  }

  void copyAllFilesWithinFolder() {
    Path docs = Path.of("docs");
    //make sure you have grants to write in the target folder
    //in this case I have set chmod 777 on /tmp/nio
    Path target = Path.of("/tmp/nio");

    //java.nio.file.FileSystemException: /tmp: Operation not permitted
    copy(docs, target);
  }


  //recursive function
  void copy(Path source, Path target) {
    try {
      Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
      if (Files.isDirectory(source)) {
        try (Stream<Path> stream = Files.list(source)) {
          stream.forEach(
              path -> copy(path, target.resolve(path.getFileName())));
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void moveFile() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    Path move = Files.move(pippo, Path.of("/tmp/pluto.txt"), StandardCopyOption.REPLACE_EXISTING);
    System.out.println(move);
  }

  void moveFileAtomic() throws IOException {
    Path pippo = Path.of("/tmp/pluto.txt");
    Path move = Files.move(pippo, Path.of("/tmp/pippo.txt"), StandardCopyOption.REPLACE_EXISTING,
        StandardCopyOption.ATOMIC_MOVE);
    System.out.println(move);
  }

  //it throws a NoSuchFileException if the file or directory does not exist
  void delete() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    Files.delete(pippo);
  }

  void deleteIfExist() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    boolean deleted = Files.deleteIfExists(pippo);
    System.out.println(deleted);
  }


}
