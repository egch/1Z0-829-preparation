package org.enricogiurin.ocp17.crashcourse.day1;

public class Casting {

    static int x = 99;

    public static void main(String[] args) {

        //do not reject cast to an interface (but a class)
        Parent p = new Child();
        ((Runnable) p).run();
        // ((Thread)p).run(); //fail
    }


}

class Parent {
}

class Child extends Parent {

}
