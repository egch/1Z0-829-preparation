package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Builder;

public class UseOfLocale {

  public static void main(String[] args) {
    new UseOfLocale().printCHF();
  }

  void locale() {
    Locale italy = new Locale.Builder()
        .setLanguage(Locale.ITALIAN.getLanguage())
        .setRegion(Locale.ITALY.getCountry())
        .build();
    //it_IT
    System.out.println(italy);
  }

  void localeZurich() {
    Locale ch = new Builder()
        .setLanguage(Locale.GERMAN.getLanguage())
        .setRegion("CH")
        .build();
    System.out.println(ch);

  }

  void printLocale() {
    Locale defaultLocale = Locale.getDefault();
    System.out.println(defaultLocale); //en_GB
  }


  void callPrintCurrency() {
    double amount = 153_000.25;
    printCurrency(Locale.ITALY, amount);
    printCurrency(Locale.US, amount);
    printCurrency(new Locale("DE", "CH"), amount);
    //£153,000.25, Italian
    //£153,000.25, English
    //£153,000.25, German
  }

  private void printCurrency(Locale locale, double money) {
    String format = NumberFormat.getCurrencyInstance().format(money) + ", " +
        locale.getDisplayLanguage();
    System.out.println(format);
  }

  void printCHF() {
    double amount = 153_000.25;
    Locale swissGerman = new Locale("DE", "CH");
    String format = NumberFormat.getCurrencyInstance(swissGerman).format(amount);
    System.out.println(format); //CHF 153’000.25

  }


}
