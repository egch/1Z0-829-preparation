package org.enricogiurin.ocp17.ch3;

public class DoWhile {
    public static void main(String[] args) {
        new DoWhile().scope();
    }

    void scope() {
        do {
            int x = 0;
            System.out.println("ciao");
            //}while (x<=5)  x is out of scope here
        } while (2 <= 5);
    }
}
