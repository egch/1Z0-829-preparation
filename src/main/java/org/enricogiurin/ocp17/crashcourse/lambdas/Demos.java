package org.enricogiurin.ocp17.crashcourse.lambdas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;

interface StudentCriterion {

  boolean test(Student s);
}

class Student {

  public int getGpa() {
    return 0;
  }

  public List<String> getCourses() {
    return null;
  }
}

class SmartStudent implements StudentCriterion {

  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3;
  }
}

public class Demos {

  public static void main(String[] args) {
    StudentCriterion sc = new SmartStudent();
    // lambda MUST implement an interface
    // ** context MUST make that interface clear
    // and that interface MUST have ONE abstract method
    // we MUST ONLY desire to provide implementation of THAT ONE method
    // compiler will:
    // write the class using this method
    // instantiate it :)
//    StudentCriterion sc2 = (Student s) -> { return s.getGpa() > 3; };
    // if the argument type is also inferrable, we can leave it out
//    StudentCriterion sc2 = (s) -> { return s.getGpa() > 3; };
    // sometimes, we want to annotate the formal parameter
//    StudentCriterion sc2 = (@Deprecated Student s) -> { return s.getGpa() > 3; };
    // this does NOT work (annotation goes with the TYPE not the formal param
//    StudentCriterion sc2 = (@Deprecated s) -> { return s.getGpa() > 3; };
//    StudentCriterion sc2 = (@Deprecated var s) -> { return s.getGpa() > 3; };
//    StudentCriterion sc2 = (var s) -> { return s.getGpa() > 3; };
    // BUT, you must choose:
    // All formal params, with no type, with explicit type, or with var

    // IF (but only if) you have a SINGLE formal param, with NO TYPE specifier
    // we can leave off the parens (there's nothing to "group")
//    StudentCriterion sc2 = s -> { return s.getGpa() > 3; };

    // OFTEN, our method body simply returns an expression
    // In which case we can leave out "clutter"
    // curlies "group" stuff, but we have only one thing-- leave out
    // return is unnecessary
    // must do both changes at once :)
//    StudentCriterion sc2 = s -> s.getGpa() > 3 ;
//    StudentCriterion sc2 = s -> Boolean.valueOf(s.getGpa() > 3) ;
    StudentCriterion sc2 = s -> {
      Boolean b = null;
      return b;
    };

    // CANNOT DO THIS!
//    Object obj = (Student s) -> {
//      return s.getGpa() > 3;
//    };

    // statement expression, value we can ignore
//    boolean b = List.of().add(0);
//    List.of().add(0);
//    3 + 2;\

    ToIntFunction<String> tofs = s -> Integer.valueOf(s.length());
//    Long lng = 99; // Nope
    Byte b = null;
    long lng = b;

    Object BiPredicate;
//    BiFunction<String, String, Integer> f = (s, t) -> s.length() - t.length();
//    BiPredicate<String> f = (s, t) -> s.length() - t.length();
//    Comparator<String> f = (s, t) -> s.length() - t.length();
//    Supplier<String, Integer> f = (s, t) -> s.length() - t.length();
    BinaryOperator<String> f = (s, t) -> (s.length() - t.length()) + "";
//    BinaryOperator<String> f = (s, t) -> s + t;

//    IntFunction<Integer> f1 = (f) -> f;
//    f1.applyAsInt(Integer.valueOf(0));
  }

  interface BiFunction<A1, A2, R> {

    R apply(A1 a1, A2 a2);
  }

  interface IntFunction<E> {

    E applyAsInt(int i);
  }

  class MyIntFunction implements IntFunction<Integer> {

    @Override
//    public Integer applyAsInt(Integer f) {
    public Integer applyAsInt(int f) {
//      return Integer.valueOf(f);
      return f;
    }

    @Override
//    public boolean equals(MyIntFunction me) { return false; }
    public boolean equals(Object me) {
      return false;
    }


  }
}
