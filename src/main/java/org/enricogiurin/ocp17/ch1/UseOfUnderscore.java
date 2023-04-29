package org.enricogiurin.ocp17.ch1;

public class UseOfUnderscore {
    void useOfUnderscore(){
        //this is a valid use of underscore.
        var x = 5_______1;
        System.out.println(x);
    }

    public static void main(String[] args) {
        new UseOfUnderscore().useOfUnderscore();
    }
}
