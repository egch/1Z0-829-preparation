package org.enricogiurin.ocp17.ch4;

public class Arrays {
    public static void main(String[] args) {
        new Arrays().callProcess();
    }

    void callProcess() {
        //not compile
        //process({0,1,2);
        process(new int[]{1,2,3});
    }
    void process(int[] array){
        for (int element:array) {
            System.out.println(element);
        }
    }
}
