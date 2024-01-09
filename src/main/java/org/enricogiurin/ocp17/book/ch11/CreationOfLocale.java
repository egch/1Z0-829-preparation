package org.enricogiurin.ocp17.book.ch11;

import java.util.Locale;
import java.util.Locale.Builder;

public class CreationOfLocale {

  public static void main(String[] args) {
    new CreationOfLocale().builder();
  }

  void newLocale() {
    Locale italy = new Locale("it", "IT");
    //country: IT - language: IT
    System.out.println(
        "country: %s - language: %S".formatted(italy.getCountry(), italy.getLanguage()));
  }

  void defaultLocale() {
    Locale aDefault = Locale.getDefault();
  }

  void builder() {
    Locale italy = new Builder()
        .setLanguage("it")
        .setRegion("IT")
        .build();
  }

  void staticLocale() {
    Locale italian = Locale.ITALIAN;
    System.out.println("country: %s - language: %S".formatted(italian.getCountry(),
        italian.getLanguage())); //country:  - language: IT

    Locale italy = Locale.ITALY;
    System.out.println("country: %s - language: %S".formatted(italy.getCountry(),
        italy.getLanguage()));  //country: IT - language: IT

  }


}
