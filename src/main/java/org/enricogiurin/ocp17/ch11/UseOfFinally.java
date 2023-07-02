package org.enricogiurin.ocp17.ch11;

public class UseOfFinally {
    public static void main(String[] args) {
        UseOfFinally instance = new UseOfFinally();

        //int calculate = instance.calculate();
        //System.out.println(calculate);

        instance.systemExit();


    }

    //it always returns 3
    int calculate() {
        try {
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    void systemExit() {
        try {
            System.out.println("try");
            //it exits here
            System.exit(1);
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            //in this case the finally won't be executed
            System.out.println("finally");
        }

    }
}
