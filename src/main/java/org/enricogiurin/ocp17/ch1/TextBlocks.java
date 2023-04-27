package org.enricogiurin.ocp17.ch1;

public class TextBlocks {
    public static void main(String[] args) {
        /*
        starts with """ and ends with """
        text blocks requires a break between beginning and the end
        example:
        String s = """aaa"""; //does not compile
         */
        printPyramid();
    }

    static void printTextBlock() {
        String s = """
                Today is thursday
                and I guess tomorrow is friday
                """;
        System.out.println(s);

    /*
    output:

    Today is thursday
    and I guess tomorrow is friday
     */
    }

    static void printPyramid(){
        String pyramid = """
                *
               * *
              * * *
             * * * *
            * * * * *
                """;
        System.out.println(pyramid);
    }



}
