package org.enricogiurin.ocp17.ch1;

public class Egg {
    private int number = 3;

    {
        number = 4;
    }

    public Egg() {
        number = 5;
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);
    }
    /*
    -> 5
    number: 3->4->5
     */
}