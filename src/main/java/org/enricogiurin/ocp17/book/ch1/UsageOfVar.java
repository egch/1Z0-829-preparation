package org.enricogiurin.ocp17.book.ch1;

public class UsageOfVar {

  public static void main(String[] args) {
    new UsageOfVar().whatType();
  }

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

  //does not compile: var can only be used as local variable
/*    int varAsArgument(var x){
        return 0;
    }
*/

  void twoVariables() {
    //does not compile:
    // int x = 0, var y = 5;
  }

  void lawfulUseOfVar() {
    //not allowed, var cannot be initialized to null
    //var spring = null;

    var fall = "leaves";
    var evening = 2;
    //not allowed, var type is int
    //evening = null;

    var night = Integer.valueOf(3);
    //lawful, var is checked at compile time
    var day = 1 / 0;

    //'var' is not allowed in a compound declaration
    //var winter = 12, cold;

    //'var' is not allowed in a compound declaration
    //var fall = 2, autumn = 2;
    var morning = "";
    morning = null;


  }

  void whatType() {
    var type = 2 / 3;
    //in this case is an int
    System.out.println(type);
  }

  void multipleVar() {
    //not allowed
    //var is not allowed in a compound declaration
    //var x=5, y=6;

    //but this is fine!
    var x= 5;
    var y=6;
  }
}


