package org.enricogiurin.ocp17.book.ch14.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class UsageOfFile {

  public static void main(String[] args) throws IOException {
    new UsageOfFile().createDeleteFile();
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

  void fileCreation() {
    //existing path: /weather/winter/snow.dat
    File fileA = new File("/weather/winter/snow.dat");
    File fileB = new File(new File("/weather/winter"), "snow.dat");
    File fileC = Path.of("/weather/winer/snow.dat").toFile();
    //fileA, B, C represent the same file
  }

  void createDeleteFile() throws IOException {
    File file = new File("/tmp/aaa.txt");
    if(!file.exists()){
      boolean newFile = file.createNewFile();
      if(newFile){
        System.out.println("file %s has been successfully created".formatted(file.getName()));
      }
    }else{
      file.deleteOnExit();
      System.out.println("file %s has been successfully deleted".formatted(file.getName()));
    }
  }


}
