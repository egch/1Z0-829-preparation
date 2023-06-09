package org.enricogiurin.ocp17.ch8;

public class PassingLambda {

    void calculate(Run run, int a, int b){
        int result = run.speed(a,b);
        System.out.println(result);
    }

    public static void main(String[] args) {
        PassingLambda passingLambda = new PassingLambda();
        passingLambda.calculate((a,b)->a*b, 3,4);
    }
}

@FunctionalInterface
interface Run {
    int speed(int a, int b);
}
