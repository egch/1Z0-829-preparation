package org.enricogiurin.ocp17.book.ch14;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IsSameFile {

  public static void main(String[] args) throws IOException {
    new IsSameFile().simpleIsSameFile();

  }

  void isSameFile() throws IOException {
    //from /tmp folder I ran this: $ ln -s /tmp/a/b link

    //if I do not run the ln command I got this:
    //Exception in thread "main" java.nio.file.NoSuchFileException: /tmp/a/b
    Path realF = Path.of("/tmp/a/b");
    Path symbolicLink = Path.of("/tmp/link");
    boolean sameFile = Files.isSameFile(realF, symbolicLink);
    //true
    System.out.println(sameFile);
  }

  void simpleIsSameFile() throws IOException {
    Path p1 = Path.of("src/a");
    Path p2 = Path.of("src/a");
    //in this case it does not check if the two Path really exist because they are the same
    boolean result = Files.isSameFile(p1, p2);
    System.out.println(result);

    p2 = Path.of("src/../src/a");

    //in this case the method check if they file exist and it throws an exception
    //Exception in thread "main" java.nio.file.NoSuchFileException: src/a
    result = Files.isSameFile(p1, p2);
    System.out.println(result);
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
