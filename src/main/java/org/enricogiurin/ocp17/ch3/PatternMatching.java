package org.enricogiurin.ocp17.ch3;

public class PatternMatching {

    public static void main(String[] args) {
        new PatternMatching().pattern("Hello");
    }


    void pattern(Object object){
        if(object instanceof String s){
            System.out.println("length of string is "+s.length());
        }
    }
}
