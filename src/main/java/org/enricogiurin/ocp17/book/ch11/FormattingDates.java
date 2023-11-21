package org.enricogiurin.ocp17.book.ch11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingDates {

  public static void main(String[] args) {
    new FormattingDates().customFormat_mixingMethods();
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

}
