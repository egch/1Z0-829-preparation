package org.enricogiurin.ocp17.ch11;

import java.util.Locale;

public class UseOfLocale {

  public static void main(String[] args) {
    new UseOfLocale().locale();
  }

  void locale() {
    Locale italy = new Locale.Builder()
        .setLanguage(Locale.ITALIAN.getLanguage())
        .setRegion(Locale.ITALY.getCountry())
        .build();
    //it_IT
    System.out.println(italy);
  }
}
