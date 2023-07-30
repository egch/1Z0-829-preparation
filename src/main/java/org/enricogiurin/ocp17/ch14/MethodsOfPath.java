package org.enricogiurin.ocp17.ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MethodsOfPath {
    public static void main(String[] args) throws IOException {
        new MethodsOfPath().report();
        new MethodsOfPath().list();
    }
    void report() throws IOException {
        //relative path
        Path pom = Path.of("pom.xml");
        System.out.println(pom.isAbsolute());
        System.out.println(Files.isDirectory(pom));
        ///Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
        System.out.println(pom.toAbsolutePath());
        System.out.println(pom.getParent());

        //true
        if(Files.isRegularFile(pom)){
            //977
            System.out.println(Files.size(pom));
            //2023-04-19T21:15:14.783684507Z
            System.out.println(Files.getLastModifiedTime(pom));
        }
    }

    void list() throws IOException {
        Path tmp = Path.of("/tmp");
        if(Files.isDirectory(tmp)) {
            try(Stream<Path> stream = Files.list(tmp)) {
                //some files present in the /tmp folder
                stream.forEach(path -> System.out.println(path.getFileName()));
            }
        }
    }
}
