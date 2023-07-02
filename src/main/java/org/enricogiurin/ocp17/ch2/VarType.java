package org.enricogiurin.ocp17.ch2;

public class VarType {

    public static void main(String[] args) {
        new VarType().printVarType();
    }

    void printVarType() {
        var x = 5;
        Object obj = x;
        System.out.println(obj.getClass().getName());
        //will print java.lang.Integer
    }
}
