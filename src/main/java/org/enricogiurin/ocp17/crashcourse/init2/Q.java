package org.enricogiurin.ocp17.crashcourse.init2;

import static java.lang.System.out;

class Parent {
    static int x = 99;

    static {
        out.print(", P-si: x is " + Parent.x);
    }

    int y = 100;

    {
        y++;
        out.print(", P-i: y is " + y);
    }

    Parent(int x) {
        y += x;
        out.print(", P-c: y is " + y);
    }
}

class Child extends Parent {
    static int y = 300;

    static {
        out.print(", C-si: y is " + y);
    }

    int x = 200;

    {
        out.print(", C-i x: is " + x);
    }

    Child() {
        super(y);
    }

    Child(int x) {
        this();
    }
}

class InitOrder3 {
    public static void main(String[] args) {
        out.print("Hello!");
        new Child(-1);
        out.println(" Goodbye!");
    }
}

public class Q {
}
