package org.enricogiurin.ocp17.book.ch14.io;

import java.io.File;

public class MethodsOfFile {

  public static void main(String[] args) {
    MethodsOfFile instance = new MethodsOfFile();
    //instance.infoFile(new File("/tmp"));
    instance.delete();
  }

  void methods() {
    File file = buildFile();
    String name = file.getName();
    System.out.println(name);  //a.txt
    String parent = file.getParent();
    System.out.println(parent); //tmp
    boolean absolute = file.isAbsolute();
    System.out.println(absolute); //true
  }

  void delete() {
    File file = buildFile();
    boolean deleted = file.delete();
    System.out.println(deleted); //true

    File notExisting = new File("notExistingFile");
    //if the file does not exist, it does not throw an exception
    boolean isDeleted = notExisting.delete();
    System.out.println(isDeleted); //false


  }

  void infoFile(File file) {
    if (file.exists()) {
      System.out.println("absolute path: " + file.getAbsolutePath());
      System.out.println("is Directory: " + file.isDirectory());
      System.out.println("parent path: " + file.getParent());
      if (file.isFile()) {
        System.out.println("length: " + file.length());
        System.out.println("last modified: " + file.lastModified());
      } else {
        for (File f : file.listFiles()) {
          System.out.println(f.getName());
        }
      }
    }
  }

  private File buildFile() {
    return new File("/tmp", "a.txt");
  }

}
