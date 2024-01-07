package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsageOfCompactNumberInstance {

  public static void main(String[] args) {
    new UsageOfCompactNumberInstance().round();
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
    // rounds to the nearest whole number within the three-digit range
    double amount = 1_900_000.0D;
    var longFormat = NumberFormat.getCompactNumberInstance(
        Locale.getDefault(), Style.LONG);
    var shortFormat = NumberFormat.getCompactNumberInstance();

    System.out.println(longFormat.format(amount));  //2 million
    System.out.println(shortFormat.format(amount));  //2M
    amount = 1_900;
    System.out.println(longFormat.format(amount));  //2 thousand
    System.out.println(shortFormat.format(amount));  //2K
  }

  void round() {
    var shortFormat = NumberFormat.getCompactNumberInstance();
    List<Double> list = List.of(1_900_000D, 23_021D, 21_365_891D, 123.5D, 960_010D, 0.123D);
    String result = list.stream()
        .map(d -> shortFormat.format(d))
        .collect(Collectors.joining(", "));
    System.out.println(result);  //2M, 23K, 21M, 124, 960K, 0
  }

  void roundAmountShort() {
    double amount = 123_456.789;
    NumberFormat compactNumberInstance = NumberFormat.getCompactNumberInstance(
        Locale.getDefault(), Style.SHORT);
    System.out.print(compactNumberInstance.format(amount)); //123K
  }


}
