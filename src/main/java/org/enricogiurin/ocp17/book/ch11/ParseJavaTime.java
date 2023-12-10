package org.enricogiurin.ocp17.book.ch11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParseJavaTime {

  public static void main(String[] args) {
    new ParseJavaTime().wrongParse();
  }

  /**
   *   This method throws an exception
   *   The string sent to the parse() method contains a time component,
   *   but ISO_LOCAL_DATE is used as the formatter.
   *
   */
  void wrongParse() {
    //Exception in thread "main" java.time.format.DateTimeParseException: Text '2022-01-21T12:00:00' could not be parsed, unparsed text found at index 10
    LocalDateTime localDateTime = LocalDateTime.parse("2022-01-21T12:00:00",
        DateTimeFormatter.ISO_LOCAL_DATE);
  }

}
