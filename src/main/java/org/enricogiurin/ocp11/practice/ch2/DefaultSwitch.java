package org.enricogiurin.ocp11.practice.ch2;

public class DefaultSwitch {
    public static void main(String... args) {
        var flavours = 30;
        int eaten=0;
        switch (flavours) {
            case 30:
                eaten++;
            case 40:
                eaten += 2;
            default:
                eaten--;
        }
        //it prints 2 (0+1+2-1) as it goes in all the cases: 30/40/default as there ain't break
        System.out.println(eaten);

    }
}
