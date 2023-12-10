package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import java.util.stream.Stream;

public class UsageOfCompactNumberFormat {

  public static void main(String[] args) {
    new UsageOfCompactNumberFormat().roundAmount();
  }

  void simpleCompactNumberInstance() {
    NumberFormat compactNumberInstance = NumberFormat.getCompactNumberInstance();
    String format = compactNumberInstance.format(1_000_000);
    System.out.println(format); //1M

  }

  void compactNumberInstance() {
    Locale swissGermanLocale = new Locale("de", "CH");

    double value = 152_000.45;
    Stream<NumberFormat> formatters = Stream.of(
        NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT),
        NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.LONG),
        NumberFormat.getCompactNumberInstance(Locale.ITALY, Style.SHORT),
        NumberFormat.getCompactNumberInstance(Locale.ITALY, Style.LONG),
        NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT),
        NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG),
        NumberFormat.getCompactNumberInstance(swissGermanLocale, Style.SHORT),
        NumberFormat.getCompactNumberInstance(swissGermanLocale, Style.LONG),
        NumberFormat.getNumberInstance()
    );
    formatters
        .map(s -> s.format(value))
        .forEach(System.out::println);
    //152K
    //152 thousand
    //152.000
    //152 mila
    //152K
    //152 thousand
    //152’000
    //152 Tausend
    //152,000.45

  }

  void roundAmount() {
    double amount = 1_900_000.0D;
    var longFormat = NumberFormat.getCompactNumberInstance(
        Locale.getDefault(), Style.LONG);
    var shortFormat = NumberFormat.getCompactNumberInstance();

    System.out.println(longFormat.format(amount));  //2 million
    System.out.println(shortFormat.format(amount));  //2M

  }


}
