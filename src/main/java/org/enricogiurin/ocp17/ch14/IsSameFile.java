package org.enricogiurin.ocp17.ch14;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IsSameFile {

  public static void main(String[] args) throws IOException {
    new IsSameFile().mismatch();

  }

  void isSameFile() throws IOException {
    //from /tmp folder I ran this: $ ln -s /tmp/a/b link
    Path realF = Path.of("/tmp/a/b");
    Path symbolicLink = Path.of("/tmp/link");
    boolean sameFile = Files.isSameFile(realF, symbolicLink);
    //true
    System.out.println(sameFile);
  }

  void isSymbolicLink() throws IOException {
    Path symbolicLink = Path.of("/tmp/link");
    boolean isSL = Files.isSymbolicLink(symbolicLink);

    //true
    System.out.println(isSL);
  }

  void mismatch() throws IOException {
    Path hello = Path.of("/tmp/hello.txt");
    Path helloWorld = Path.of("/tmp/helloworld.txt");
    long mismatch = Files.mismatch(helloWorld, hello);

    //-1 if the contents are the same
    //or the first index the 2 files differ
    System.out.println(mismatch);
  }

  void comparePaths() throws IOException {
    var p1 = Path.of("/lizard", ".").resolve(Path.of("walking.txt"));
    var p2 = new File("/lizard/././actions/../walking.txt").toPath();
    //Exception in thread "main" java.nio.file.NoSuchFileException: /lizard/./walking.txt
    System.out.print(Files.isSameFile(p1, p2));
    System.out.print(" ");
    System.out.print(p1.equals(p2));
    System.out.print(" ");
    System.out.print(Files.mismatch(p1, p2));
  }

}
