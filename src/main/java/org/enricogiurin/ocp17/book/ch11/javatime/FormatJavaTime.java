package org.enricogiurin.ocp17.book.ch11.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatJavaTime {

  public static void main(String[] args) {
    new FormatJavaTime().format();
  }

  void format() {
    LocalDateTime now = LocalDateTime.now();
    String isoLocalDT = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    System.out.println(isoLocalDT); //2023-09-22T20:42:11.232448

    String isoDT = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(isoDT); //2023-09-22
  }

  void customFormat() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy - hh:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String time = now.format(dateTimeFormatter);
    System.out.println(time);  //22-09-2023 - 08:44:55
  }

  void customFormatWithText() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
        "'Today is: 'dd-MM-yyy' with time: ' hh:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String time = now.format(dateTimeFormatter);
    System.out.println(time);  //Today is: 22-09-2023 with time:  08:46:36
  }

  void formatWithMMM() {
    LocalDate polarBearDay = LocalDate.of(2022, 2, 27);
    var formatter = DateTimeFormatter.ofPattern("yyyy dd MM"); //2022 27 02  (MM)
    System.out.println(polarBearDay.format(formatter));

    formatter = DateTimeFormatter.ofPattern("yyyy dd MMM"); //2022 27 Feb (MMM)
    System.out.println(polarBearDay.format(formatter));
  }

  void customFormat_mixingMethods() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy - hh:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    //calling format in  LDT
    String time = now.format(dateTimeFormatter);
    System.out.println(time);  //22-09-2023 - 08:49:27

    //calling format in  DTF
    time = dateTimeFormatter.format(now);
    System.out.println(time);  //22-09-2023 - 08:49:27
  }

  void trickyDateFormatter() {
    //mind the single quotes
    final String pattern = """
        'yyyy-MM'""";

    //The date pattern uses single quotes to escape the date values,
    // meaning the output is yyyy-MM for all valid inputs.
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    LocalDate today = LocalDate.now();
    String result = today.format(dateTimeFormatter);
    System.out.println(result); //yyyy-MM
  }

  void formatWithComplexPattern() {
    //mind the double apostrophe next to "o'clock"
    String pattern = "MMMM dd' at 'hh' o''clock'";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    LocalDateTime now = LocalDateTime.now();
    String result = now.format(dateTimeFormatter);
    System.out.println(result);  //January 03 at 02 o'clock
  }

}
