package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import java.util.stream.Stream;

public class UseOfCompactNumberFormat {

  public static void main(String[] args) {
    new UseOfCompactNumberFormat().format();
  }

  void format() {
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
  }

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
