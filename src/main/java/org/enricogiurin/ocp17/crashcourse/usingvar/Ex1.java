package org.enricogiurin.ocp17.crashcourse.usingvar;

//class X {
//  var x = 99;
//}

public class Ex1 {
//  void doStuff(var x) { }
//  void doStuff() {
//    var x;
//    x = 100;
//  }
//  void doStuff() {
//    var x = 100;
//  }
//  void doStuff() {
//    var x = null;
//  }

  public static void main(String[] args) throws Throwable {
//    for (var x = 0; x < 3; x++)
//      System.out.println(x);

//    try (var in = new FileReader("");
//         var out = new FileWriter("")) {
//    }

//    try (FileReader in = new FileReader("")) {
//    } catch (var ex) { }


// nope, can't change base type during autoboxing
//    Long i = 2_000_000_000;

    var x = true ? "99" : 99;

//    Integer in = null; // also for String :)
//    in.compareTo... and others

//    int goto;
//    var var = "var";
    int var = 99;
  }

//  void doStuff() {
//    var x = new int[]{ 1, 2, 3 };
//  }

//  void doStuff() {
//    var x = { 1, 2, 3 };
//  }

//  void showStuff(CharSequence [] csa) {}
//  void useIt() {
//    showStuff(new String[]{"a", "b"});
//  }
}

//class var {}