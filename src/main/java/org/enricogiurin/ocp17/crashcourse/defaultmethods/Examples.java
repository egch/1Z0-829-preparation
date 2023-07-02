package org.enricogiurin.ocp17.crashcourse.defaultmethods;

interface IntX {
    //  void doStuff();
    default void doStuff() {
        System.out.println("IntX.doStuff()");
    }
}

interface IntY {
    //  default void doStuff() {
//    System.out.println("IntY.doStuff()");
//  }
    void doStuff();
}

class ClQ implements IntX, IntY {
    @Override
    public void doStuff() {
        IntX.super.doStuff();
//    IntY.super.doStuff();
    }
}

public class Examples {
    public static void main(String[] args) {
        new ClQ().doStuff();
    }
}
