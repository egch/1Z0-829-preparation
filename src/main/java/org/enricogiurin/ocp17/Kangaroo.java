package org.enricogiurin.ocp17;

class Marsupial {
    protected int age = 2;

    public static boolean isBiped() {
        return false;
    }
}

public class Kangaroo extends Marsupial {
    protected int age = 6;

    public static boolean isBiped() {
        return true;
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        Marsupial moey = joey;
        System.out.println(joey.isBiped());  //true
        System.out.println(moey.isBiped());  //false
        System.out.println(joey.age);  //6
        System.out.println(moey.age);   //2
    }
}