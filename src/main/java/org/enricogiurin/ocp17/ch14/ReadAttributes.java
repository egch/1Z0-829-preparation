package org.enricogiurin.ocp17.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;

public class ReadAttributes {

  public static void main(String[] args) throws IOException {
    new ReadAttributes().modifyingAttributes();
  }

  /*
  isDirectory: true
  isSymbolicLink: false
  isRegularFile: false
  creationTime: 2023-07-13T12:51:54Z
  lastAccessTime: 2023-08-01T23:49:06.832143827Z
  lastModifiedTime: 2023-08-01T21:18:23.829916279Z
   */
  void readAttributes() throws IOException {
    Path tmp = Path.of("/tmp");
    BasicFileAttributes attributes = Files.readAttributes(tmp, BasicFileAttributes.class);
    System.out.println("isDirectory: " + attributes.isDirectory());
    System.out.println("isSymbolicLink: " + attributes.isSymbolicLink());
    System.out.println("isRegularFile: " + attributes.isRegularFile());
    System.out.println("creationTime: " + attributes.creationTime());
    System.out.println("lastAccessTime: " + attributes.lastAccessTime());
    System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());
  }

  void modifyingAttributes() throws IOException {
    Path hw = Path.of("/tmp/helloworld.txt");
    BasicFileAttributeView view = Files.getFileAttributeView(hw,
        BasicFileAttributeView.class);
    FileTime now = FileTime.from(Instant.now().minus(Duration.ofDays(1)));
    //change last modified time of a file
    view.setTimes(now, null, null);
  }

}
