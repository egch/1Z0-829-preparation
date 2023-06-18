package org.enricogiurin.ocp17.ch9;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StaticMethodGenerics {
    public static <U extends  Exception> void printMessage(U u){
        System.out.println(u.getMessage());
    }

    public static void main(String[] args) {
        printMessage(new FileNotFoundException("not found"));
        StaticMethodGenerics.<NullPointerException>printMessage(new NullPointerException
                ("D"));

    }
}
