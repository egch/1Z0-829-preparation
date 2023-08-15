package org.enricogiurin.ocp17.crashcourse.day1;


import java.util.List;

public class Questions18 {

  public static void main(String[] args) {
    new Questions18().stringConcat();
  }

  void orderOperators() {
    int j = 3, k = 12, z = 2;
    System.out.println(j + k / z - j);  //6
  }

  void assignment() {

    int x = 10;

    //Variable expected - does not compile
    //System.out.println("value is: "+ (x++ = 99));

    //this is fine
    System.out.println("value is: " + (x = 99));

    int i = 0, j = 0;

    //not valid!!!!!
    //  ++i = ++j;

  }

  void singleAnd() {

    //bitwise vs logical and
    int x = -1;
    System.out.println(Integer.toBinaryString(x));  //1111111111
    System.out.println(Integer.toBinaryString(-2));  //1111111111
    //5 -> 000101
    System.out.println(x & 5);  //5

  }


  void stringConcat() {
    String s = "hello";
    String t = "hello";
    String q = "hell";
    q += "o";
    String z = "hell" + "o";
    System.out.println(s == t);  //true
    System.out.println(s == q);  //false
    System.out.println(s == z);  //true
  }


  //StringBuilder does not override equals
  void sbEquals() {
    StringBuilder sb1 = new StringBuilder("hello");
    StringBuilder sb2 = new StringBuilder("hello");
    System.out.println(sb1.equals(sb2));  //false

  }

  void listEquals() {
    List<String> list1 = List.of("enrico", "alberto");
    List<String> list2 = List.of("enrico", "alberto");
    System.out.println(list1.equals(list2));  //true
  }

  void stringPool() {
    String s1 = "hello";
  }


}
