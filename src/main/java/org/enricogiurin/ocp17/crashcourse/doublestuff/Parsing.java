package org.enricogiurin.ocp17.crashcourse.doublestuff;

public class Parsing {
    public static void main(String[] args) {
        System.out.println(Double.parseDouble("Infinity"));
        System.out.println(Double.parseDouble("-Infinity"));
        System.out.println(Double.parseDouble("+Infinity"));
        System.out.println(Double.parseDouble("NaN"));
    }
}
