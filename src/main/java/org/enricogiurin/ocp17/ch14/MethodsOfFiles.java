package org.enricogiurin.ocp17.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MethodsOfFiles {

  public static void main(String[] args) throws IOException {
    new MethodsOfFiles().checkAccessibility();
  }

  void check() {
    Path link = Path.of("/tmp/link");
    System.out.println(Files.isDirectory(link));
    System.out.println(Files.isSymbolicLink(link));
    System.out.println(Files.isRegularFile(link));
  }

  void checkAccessibility() throws IOException {
    //Mac-mini-3:tmp enrico$ ll readableFile
    //-r--r--r--  1 enrico  wheel  0 Aug  4 22:39 readableFile
    Path readableFile = Path.of("/tmp/readableFile");
    System.out.println(Files.isHidden(readableFile));  //false
    System.out.println(Files.isReadable(readableFile));  //true
    System.out.println(Files.isWritable(readableFile));  //false
    System.out.println(Files.isExecutable(readableFile));  //false
  }

  void checkHidden() throws IOException {
    //  Mac-mini-3:tmp enrico$ ll .hiddenFile
    //-rw-r--r--  1 enrico  wheel  0 Aug  4 22:43 .hiddenFile
    Path readableFile = Path.of("/tmp/.hiddenFile");
    System.out.println(Files.isHidden(readableFile));  //true

  }


}
