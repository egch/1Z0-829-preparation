package org.enricogiurin.ocp17.ch3;

public class Loop {
    public static void main(String[] args) {
        new Loop().loopWithDouble();
    }
    void loopWithDouble(){
        for(double x=0; x<10; x++){
            System.out.println(x);
        }
    }
}
