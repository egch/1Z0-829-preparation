package org.enricogiurin.ocp17.book.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvePaths {

  public static void main(String[] args) throws IOException {
    new ResolvePaths().toRealPathNotExisting();
  }

  void resolve() {
    //absolute & relative
    //p1 resolve to p2: /tmp/relative
    //p2 resolve to p1: /tmp
    resolve(Path.of("/tmp"), Path.of("relative"));

    //absolute & absolute
    //p1 resolve to p2: /tmp2
    //p2 resolve to p1: /tmp1
    resolve(Path.of("/tmp1"), Path.of("/tmp2"));

    //relative & relative
    //p1 resolve to p2: relative1/relative2
    //p2 resolve to p1: relative2/relative1
    resolve(Path.of("relative1"), Path.of("relative2"));
  }

  private void resolve(Path p1, Path p2) {
    System.out.println("p1: " + p1);
    System.out.println("p2: " + p2);
    System.out.println("p1 resolve to p2: " + p1.resolve(p2));
    System.out.println("p2 resolve to p1: " + p2.resolve(p1));
  }

  void normalize() {
    var p1 = Path.of("/tmp/../../dog/cat/../pippo.txt");
    //  /dog/pippo.txt
    System.out.println(p1.normalize());

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

  //we assume the link exist and also the corresponding target folder /tmp/a/b
  //when executed the second time it throws an exception
  //Exception in thread "main" java.nio.file.FileAlreadyExistsException: /tmp/link/joey
  ///tmp/a/b/joey

  void resolveFolderExisting() throws IOException {
    var path = Paths.get("/tmp/link");
    if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
      Files.createDirectory(path.resolve("joey"));
    }
  }

}
