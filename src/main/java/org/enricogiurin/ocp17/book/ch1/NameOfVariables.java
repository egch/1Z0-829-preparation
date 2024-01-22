package org.enricogiurin.ocp17.book.ch1;

public class NameOfVariables {

  void names() {
    var x = 5;
    var z = 1____3___4;  //valid

    var _a = "";
    var _b_ = "";
    var ______ = "";
    //a single underscore is not allowed!
    //var _ = 3;
  }

  void currencyNames() {
    //I can use any currencies as variable names
    int $ = 5;
    int € = 66;
    int €$_ = 55;
    //all currencies all the world
    int £€$ = 55;
  }

}
