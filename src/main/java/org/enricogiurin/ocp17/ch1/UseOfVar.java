package org.enricogiurin.ocp17.ch1;

public class UseOfVar {
    //cannot use var as an instance variable
    //var x = 5;
    void localVar() {
        var s = new String("hello");
        var tricky = "Hello";
        System.out.println(s);
    }

    void reAssigment() {
        var x = 5;
        //x as now the type int
        //x = "hello"; //does not compile!

    }

    void wrongVar() {
        //does not compile: Cannot infer type: 'var' on variable without initializer

/*
        var question;
        question = 1;
*/

    }

    void twoVariables() {
        //does not compile:
       // int x = 0, var y = 5;
    }

    //does not compile: var can only be used as local variable
/*    int varAsArgument(var x){
        return 0;
    }
*/
}