package org.enricogiurin.ocp17.book.ch10;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Supplier;

public class UsageOfOptional {

  public static void main(String[] args) {
    new UsageOfOptional().map();
  }

  void use() {
    Optional<Integer> optionalInteger = Optional.of(10);
    if (optionalInteger.isPresent()) {
      System.out.println(optionalInteger.get());
    }
    //lambda usage
    optionalInteger.ifPresent(System.out::println);

    Optional<Integer> empty = Optional.empty();

    //.NoSuchElementException: No value present
    Integer value = empty.get();
  }

  void optionalThrow() {
    Optional<String> optional = Optional.empty();

    //Exception in thread "main" java.util.NoSuchElementException: No value present
    optional.orElseThrow();
  }

  void orElseThrow() {
    Optional<String> optional = Optional.empty();

    //Exception in thread "main" java.lang.RuntimeException: no value!
    optional.orElseThrow(() -> new RuntimeException("no value!"));
    //wrong way
    //optional.orElseThrow(() -> throw new RuntimeException("no value!"));  //does not compile!!
  }

  void orElseThrow2() {
    Supplier<RuntimeException> supplier = () -> new RuntimeException("missing value");
    Optional<String> optional = Optional.empty();
    optional.orElseThrow(supplier);
  }

  void orElseGet() {
    Optional<String> optional = Optional.empty();
    String result = optional.orElseGet(() -> "default value"); //default
    Optional<String> optionalVersion = Optional.of("Java 17");
    String version = optionalVersion.orElseGet(() -> "Java 11");  //Java 17
  }

  void orElse() {
    Exception e = new IOException();
    Optional<Exception> opt = Optional.of(e);
    Exception e1 = opt.orElse(new RuntimeException());
    System.out.println(e1); //java.io.IOException
    e = null;
    opt = Optional.ofNullable(e);
    Exception e2 = opt.orElse(new RuntimeException());
    System.out.println(e2); //java.lang.RuntimeException
  }

  void optionalOfNull() {
    String message = null;
    //this does not throw any exception
    var optOfNullable = Optional.ofNullable(message);

    try {
      //but if I call the get yes.
      //java.util.NoSuchElementException: No value present
      String tmp = optOfNullable.get();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //this throws a NPE at runtime as I pass the null value
    try {
      //java.lang.NullPointerException
      Optional<String> optMessage = Optional.of(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void map() {
    Optional<Integer> op = Optional.of(12);
    op.map(n -> "" + n)
        .filter(s -> s.length() > 1)
        .ifPresent(System.out::println);

  }
}
