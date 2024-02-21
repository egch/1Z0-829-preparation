package org.enricogiurin.ocp17.book.ch11.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ParseJavaTime {

  public static void main(String[] args) {
    new ParseJavaTime().parse_ofPattern();
  }

  /**
   * This method throws an exception The string sent to the parse() method contains a time
   * component, but ISO_LOCAL_DATE is used as the formatter.
   */
  void wrongParse() {
    //Exception in thread "main" java.time.format.DateTimeParseException: Text '2022-01-21T12:00:00' could not be parsed, unparsed text found at index 10
    LocalDateTime localDateTime = LocalDateTime.parse("2022-01-21T12:00:00",
        DateTimeFormatter.ISO_LOCAL_DATE);
  }

  void parse() {
    LocalDateTime localDateTime = LocalDateTime.parse("2022-01-21T12:00:00",
        DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    System.out.println(localDateTime);  //2022-01-21T12:00
  }

  void parse_ofPattern() {
    LocalDateTime localDateTime = LocalDateTime.parse("2022-01-21T12:00:00",
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    System.out.println(localDateTime);  //2022-01-21T12:00
  }

  public static class FormatJavaTime {

    public static void main(String[] args) {
      new FormatJavaTime().trickyDateFormatter();
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

    void ofLocalizedDate() {
      LocalDate localDate = LocalDate.of(2023, Month.NOVEMBER, 10);
      LocalTime localTime = LocalTime.of(0, 0);
      LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

      //The DateTimeFormatter is created with ofLocalizedDate().
      // It knows how to format date fields but not time field
      DateTimeFormatter dtfOfLocalizedDate = DateTimeFormatter
          .ofLocalizedDate(FormatStyle.SHORT);
      //this can handle date
      dtfOfLocalizedDate.format(localDate);
      //this can also handle date
      dtfOfLocalizedDate.format(localDateTime);
      //this has no clue what a date is
      //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
      dtfOfLocalizedDate.format(localTime);
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

  }
}
