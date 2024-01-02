package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class ReadAttributes {

  public static void main(String[] args) throws IOException {
    new ReadAttributes().modifyAttributeCreationTime();
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
    System.out.println("size of file: " + attributes.size()); //288
  }

  void readAttributesMac() throws IOException {
    Path tmp = Path.of("/tmp");
    PosixFileAttributes posixFileAttributes = Files.readAttributes(tmp, PosixFileAttributes.class);
    Set<PosixFilePermission> permissions = posixFileAttributes.permissions();
    for (PosixFilePermission posixFilePermission : permissions) {
      System.out.println(posixFilePermission);
    }

  }

  void modifyingAttributes() throws IOException {

    //execute before t$ touch /tmp/helloworld.txt
    Path hw = Path.of("/tmp/helloworld.txt");
    BasicFileAttributeView view = Files.getFileAttributeView(hw,
        BasicFileAttributeView.class);
    BasicFileAttributes attributes = Files.readAttributes(hw, BasicFileAttributes.class);
    System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());
    //now we change the get lastModified Time to now
    FileTime now = FileTime.from(Instant.now().minus(1, ChronoUnit.DAYS));
    //change last modified time of a file
    view.setTimes(now, now, now);
    attributes = Files.readAttributes(hw, BasicFileAttributes.class);
    System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());
  }

  void modifyAttributeCreationTime() throws IOException {
    //run $ touch a.txt before
    Path path = Path.of("/tmp/a.txt");
    BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
    FileTime fileTime = basicFileAttributes.creationTime();
    System.out.println("creation time is: %s".formatted(fileTime));
    FileTime now = FileTime.from(Instant.now().minus(1, ChronoUnit.DAYS));

    //I need this to modify creation time of the file a.txt
    BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path,
        BasicFileAttributeView.class);
    fileAttributeView.setTimes(now, now, now);
    basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
    FileTime fileTimeUpdated = basicFileAttributes.creationTime();
    System.out.println("creation time is now: %s".formatted(fileTimeUpdated));

  }

}
