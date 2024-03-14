package org.enricogiurin.ocp17.book.ch14.filesmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesMove {

  public static void main(String[] args) throws IOException {
    new FilesMove().replaceAnEmptyDirWIthAFile();
  }


  void moveFile() throws IOException {
    Path pippo = Path.of("/tmp/pippo.txt");
    Path move = Files.move(pippo, Path.of("/tmp/pluto.txt"), StandardCopyOption.REPLACE_EXISTING);
    System.out.println(move);
  }

  void moveFileAtomic() throws IOException {
    Path pippo = Path.of("/tmp/pluto.txt");
    Path move = Files.move(pippo, Path.of("/tmp/pippo.txt"), StandardCopyOption.REPLACE_EXISTING,
        StandardCopyOption.ATOMIC_MOVE);
    System.out.println(move);
  }

  //  $ touch /tmp/newFile.txt  / rm -rf /tmp/anEmptyDir
  void replaceAnEmptyDirWIthAFile() throws IOException {
    Path emptyDir = Path.of("/tmp/anEmptyDir");
    Path aNewFile = Path.of("/tmp/newFile.txt");
    Path directories = Files.createDirectories(emptyDir);

    Path newPath = Files.move(aNewFile,
        emptyDir, StandardCopyOption.REPLACE_EXISTING);
    System.out.println(newPath);  ///tmp/anEmptyDir
  }


}
