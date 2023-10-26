package org.enricogiurin.ocp17.ch2;

public class Ternary {

  public static void main(String[] args) {
    //  new Ternary().trickyTernary();
    new Ternary().ternaryNoParenthesis();
  }

  void trickyTernary() {
    int a = 1, b = 1;
    int c = a <= 10 ? a++ : b++;
    System.out.println("a: " + a + " - b: " + b);  //2,1

    a = 1;
    b = 1;
    c = a > 10 ? a++ : b++;
    System.out.println("a: " + a + " - b: " + b);  //1,2
  }

  void ternaryNoLeftAssigment() {
    int x = 2 > 0 ? 1 : 0;
    //this does not compile as no left assignment
    //2>0?1:0;
  }

  void ternaryNoParenthesis() {
    int time = 9;
    int day = 3;
    var dinner = ++time>= 10 ? day-- <= 2
        ? "Takeout" : "Salad" : "Leftovers";
    System.out.println(dinner);//Salad
  }


  void complexTernary() {
    int a1 = 2, a2 = 4, a3 = 2;
    System.out.println(a1 > 2 ? --a3 : a2++);  //4
    System.out.println(a2 = (a1 != a3 ? a1 : a2++));  //5  (the old a2)
    System.out.println(a1 > a2 ? a2 < a3 ? a2 : 2 : 1);  //1
  }
}
