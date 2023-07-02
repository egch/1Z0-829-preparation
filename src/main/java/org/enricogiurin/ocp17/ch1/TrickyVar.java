package org.enricogiurin.ocp17.ch1;

//var is not a reserved keyword
public class TrickyVar {

    public static void main(String[] args) {
        Var var = new Var();
        var.var();

    }


}

class Var {
    public void var() {
        var var = "var";
    }

    public void Var() {
        Var var = new Var();
    }
}
