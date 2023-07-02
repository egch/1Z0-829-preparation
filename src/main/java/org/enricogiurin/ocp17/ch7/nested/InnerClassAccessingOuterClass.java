package org.enricogiurin.ocp17.ch7.nested;

public class InnerClassAccessingOuterClass {
    public static void main(String[] args) {
        new Outer().hello();
    }
}


class Outer {
    private int x = 10;

    void hello() {
        abstract class Inner {
            String buildMessage() {
                //Outer.this.x is the correct way to refer to x in the Outer class.
                return "x is " + Outer.this.x;
            }
        }
        Inner inner = new Inner() {
        };
        String s = inner.buildMessage();
        System.out.println(s);
    }

}



