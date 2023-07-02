package org.enricogiurin.ocp17.ch3;

public class SwitchYield {

    public static void main(String[] args) {
        new SwitchYield().exampleWithYield(6);
    }

    void exampleWithYield(int x) {
        var result = switch (x) {
            case 1 -> "x is 5";
            default -> {
                //yield is used instead of return
                if (x > 5) yield "greater than 5";
                else yield "lower or equal than 5";
            }
        };
        System.out.println(result);
    }


}

