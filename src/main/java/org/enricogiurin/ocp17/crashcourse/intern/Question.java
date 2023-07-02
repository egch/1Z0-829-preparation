package org.enricogiurin.ocp17.crashcourse.intern;

public class Question {
    public static void main(String[] args) {
        String s1 = "hel" + "lo";
        String s3 = "hello";
        String s4 = s3.toLowerCase();
        String s2 = "hello".concat("");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}
