package org.enricogiurin.ocp17.book.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Converter {

  Long convert(Double value);
}

@FunctionalInterface
interface Check {

  boolean check(String s);
}

@FunctionalInterface
interface Creator {

  String create();
}

@FunctionalInterface
interface StringCopier {

  String create(String value);
}

public class MethodReference {

  public static void main(String[] args) {
    new MethodReference().charAt();
  }

  void charAt() {
    BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
    Character c = stringIntegerCharacterBiFunction.apply("John", 2);
    System.out.println(c);
  }

  void staticMethod() {
    Converter roundMR = Math::round;
    Converter roundLambda = d -> Math.round(d);
    System.out.println(roundMR.convert(5.3D));
    System.out.println(roundLambda.convert(5.8D));
  }

  void instanceMethod() {
    String aString = "something";
    String prefix = "s";
    Check checkMR = aString::startsWith;
    Check checkLambda = s -> aString.startsWith(s);

    System.out.println(checkMR.check(prefix));
    System.out.println(checkLambda.check(prefix));
  }

  void constructor() {
    Creator creatorMR = String::new;
    Creator createLambda = () -> new String();

    System.out.println(creatorMR.create());
    System.out.println(createLambda.create());
  }

  void constructorWithParameter() {
    /*
    you can't always determine which method can be called by looking at the method reference.
    Instead, you have to look at the context to see what parameters are used and if there is a return type.
     */
    StringCopier creatorMR = String::new;
    StringCopier createLambda = (x) -> new String(x);

    System.out.println(creatorMR.create("enrico"));
    System.out.println(createLambda.create("enrico"));
  }

  void createArrayList() {
    Function<Integer, List<Integer>> lambda = (n) -> new ArrayList<>(n);
    Function<Integer, List<Integer>> methodReference = ArrayList::new;

    List<Integer> result = lambda.apply(5);
    List<Integer> listMR = methodReference.apply(5);
  }

}


