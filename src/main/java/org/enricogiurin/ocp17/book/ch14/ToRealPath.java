package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Path;

public class ToRealPath {

  public static void main(String[] args) throws IOException {
    new ToRealPath().toRealPathNotExisting();
  }

  void toRealPath() throws IOException {
    Path pom = Path.of("pom.xml");
    Path pom2 = Path.of("../1Z0-829-preparation/pom.xml");
    ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println(pom.toRealPath());
    ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println(pom2.toRealPath());
  }

  void toRealPathNotExisting() throws IOException {
    Path notAFile = Path.of("cicciopasticcio.txt");
    //Exception in thread "main" java.nio.file.NoSuchFileException: cicciopasticcio.txt
    Path realPath = notAFile.toRealPath();
    System.out.println(realPath);
  }

}
