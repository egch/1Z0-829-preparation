package org.enricogiurin.ocp17.book.ch14.filesmethods;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesCopy {

  public static void main(String[] args) throws IOException {
    new FilesCopy().copyToSymbolicLink();
  }


  //if file already exist
  //Exception in thread "main" java.nio.file.FileAlreadyExistsException: /tmp/pom.xml
  void copyRecursive() throws IOException {
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
    Path copy = Files.copy(pom, target, REPLACE_EXISTING);
    System.out.println(copy);
  }


  /**
   * $ cd /tmp $  echo 'Hello'>msg.txt $  ln -s msg.txt myMessage
   *
   * @throws IOException
   */
  void copyFromSymbolicLink() throws IOException {
    Path p1 = Path.of("/tmp/myMessage");  //p1 is a symbolic link
    Path p2 = Path.of("/tmp/msg.txt");
    Path copy = Files.copy(p1, p2, REPLACE_EXISTING);
  }

  /**
   * $ cd /tmp $  echo 'Hello'>msg.txt $  ln -s msg.txt myMessage
   *
   * @throws IOException
   */
  void copyToSymbolicLink() throws IOException {
    Path p1 = Path.of("/tmp/msg.txt");
    Path p2 = Path.of("/tmp/myMessage");  //p2 is a symbolic link
    System.out.println(Files.isSymbolicLink(p2));  //true
    Path copy = Files.copy(p1, p2, REPLACE_EXISTING);
    //the symbolic link has been replaced!
    System.out.println(Files.isSymbolicLink(p2));  //false
  }

  void copyAllFilesWithinFolder() {
    Path docs = Path.of("docs");
    //make sure you have grants to write in the target folder
    //in this case I have set chmod 777 on /tmp/nio
    Path target = Path.of("/tmp/nio");

    //java.nio.file.FileSystemException: /tmp: Operation not permitted
    copyRecursive(docs, target);
  }


  //recursive function
  private void copyRecursive(Path source, Path target) {
    try {
      Files.copy(source, target, REPLACE_EXISTING);
      if (Files.isDirectory(source)) {
        try (Stream<Path> stream = Files.list(source)) {
          stream.forEach(
              path -> copyRecursive(path, target.resolve(path.getFileName())));
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
