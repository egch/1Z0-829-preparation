package org.enricogiurin.ocp17.ch11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UseOfCheckedException {

    public static void main(String[] args) {
        new UseOfCheckedException().fileNotFoundException();
    }

    void fileNotFoundException() {
        try {
            File file = new File("example.txt");
            //java.io.FileNotFoundException: example.txt (No such file or directory)
            new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or cannot be accessed.");
            e.printStackTrace();
        }
    }
}
