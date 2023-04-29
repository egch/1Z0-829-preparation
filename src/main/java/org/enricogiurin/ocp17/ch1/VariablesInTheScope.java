package org.enricogiurin.ocp17.ch1;

public class VariablesInTheScope {
    {
        int hairs = 3_000_0;
    }
    //hairs here get out of the scope

    long water, air = 2;
    boolean twoHumps = true;

    public void spit(float distance) {
        var path = "";
        {
            double teeth = 32 + distance++;
        }
        //teeth here get out of the scope
        while (water > 0) {
            int age = twoHumps ? 1 : 2;
            short i = -1;
            for (i = 0; i < 10; i++) {
                var Private = 2;
            }
// SCOPE }
            //total here 7 variables in scope
            System.out.println(water+" "+air+ " "+twoHumps+" "+distance+" "+path+" "+age+" "+i);
        }
    }

    public static void main(String[] args) {
        new VariablesInTheScope().spit(3F);
    }
}
