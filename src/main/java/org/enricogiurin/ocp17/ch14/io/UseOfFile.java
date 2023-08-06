package org.enricogiurin.ocp17.ch14.io;

import java.io.File;

public class UseOfFile {

  public static void main(String[] args) {
    new UseOfFile().notExistingFile();
  }

  void file() {
    File pom = new File("/Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml");
    File notExisting = new File("/notExistingFolder/notAFile");
    //true
    System.out.println(pom.exists());
    //false
    System.out.println(notExisting.exists());
  }

  void notExistingFile() {
    //no exception is thrown here
    File notExistingFile = new File("notExisting.txt");
    //false
    System.out.println("file exists? " + notExistingFile.exists());
    //this method does not throw an exception but returns false
    boolean deleted = notExistingFile.delete();
    System.out.println("file deleted? " + deleted);


  }


}
