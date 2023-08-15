package org.enricogiurin.ocp17.ch11;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Questions {

  public static void main(String[] args) {
    double d = 100_102.2;
    new Questions().localDateTimeFormatter();
  }

  void uselessCatch() {
    try {
      System.out.println("ciao");
    } catch (ArithmeticException e) {
      System.out.println();
    }
  }

  void throwsSignature() throws IOException {

    //all of these can ba valid, if declared independently
    System.out.println("ciao");
    throw new IOException();
    //throw new IllegalArgumentException();
    //throw new RuntimeException();

  }

  public void print(double t) {
    //100K
    //100K
    //£100,102.20
    System.out.print(NumberFormat.getCompactNumberInstance().format(t));
    System.out.println();
    System.out.print(NumberFormat.getCompactNumberInstance(
        Locale.getDefault(), NumberFormat.Style.SHORT).format(t));
    System.out.println();
    System.out.print(NumberFormat.getCurrencyInstance().format(t));
  }

  void format() {
    String pattern = "#,###,000.0#";
    //<005.21> <008.49> <1,234.0>
    var message = DoubleStream.of(5.21, 8.49, 1234)
        .mapToObj(v -> new DecimalFormat(pattern).format(v))
        .collect(Collectors.joining("> <"));
    System.out.println("<" + message + ">");
  }

  void throwError() {
    //I am not forced to catch Error
    throw new Error("");
  }

  void localDateTimeFormatter() {
    try {
      LocalDateTime book = LocalDateTime.of(2022, 4, 5, 12, 30, 20);
      //this prints 30 (minutes)
      System.out.print(book.format(DateTimeFormatter.ofPattern("m")));
      //this line throws an exception
      System.out.print(book.format(DateTimeFormatter.ofPattern("z")));
      System.out.print(DateTimeFormatter.ofPattern("y").format(book));
    } catch (Throwable e) {
      //java.time.DateTimeException: Unable to extract ZoneId from temporal 2022-04-05T12:30:20
      e.printStackTrace();
    }

  }
}
