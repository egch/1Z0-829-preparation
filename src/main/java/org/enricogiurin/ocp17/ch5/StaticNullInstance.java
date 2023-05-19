package org.enricogiurin.ocp17.ch5;

//StaticNullInstance
public class StaticNullInstance {
    public static void swing() {
        System.out.print("swing");
    }

    public void climb() {
        System.out.println("climb");
    }

    public static void play() {
        swing();
    }

    public static void main(String[] args) {
        StaticNullInstance rope = new StaticNullInstance();
        rope.play();
        StaticNullInstance rope2 = null;
        System.out.print("-");
        //this method is legal as I am calling a static method, not an instance method
        //It does not throw a NullPointerException because play() is a static method
        rope2.play();
    }

    //output: swing-swing
}