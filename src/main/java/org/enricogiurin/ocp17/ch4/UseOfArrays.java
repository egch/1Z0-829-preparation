package org.enricogiurin.ocp17.ch4;

import java.util.Arrays;

public class UseOfArrays {
    public static void main(String[] args) {
        new UseOfArrays().mismatch();
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

    void sort(){
        var arr = new String[] { "PIG", "pig", "123"};
        //Numbers sort before letters and uppercase sorts before lowercase.
        Arrays.sort(arr);  //"123", "PIG", "pig"
        int position = Arrays.binarySearch(arr, "Pippa");

        //result : -insertionPoint -1
        //insertionPoint ideally would be 2 (after "PIG")
        //-> result = -2 -1 = -3
        System.out.println(position);  //-3

    }

    void mismatch() {
        String[] s1 = { "Camel", "Peacock", "Llama"};
        String[] s2 = { "Camel", "Llama", "Peacock"};
        int position = Arrays.mismatch(s1, s2); //first element to differ is at position 1
        System.out.println(position);
    }
}
