package org.enricogiurin.ocp17.ch1;

public class VariablesInTheScope {
    long water, air = 2;
    //hairs here get out of the scope
    boolean twoHumps = true;

    {
        int hairs = 3_000_0;
    }

    public static void main(String[] args) {
        new VariablesInTheScope().spit(3F);
    }

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
            System.out.println(water + " " + air + " " + twoHumps + " " + distance + " " + path + " " + age + " " + i);
        }
    }
}
