package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Locale.Builder;

public class Formatting {

  public static void main(String[] args) throws ParseException {
    new Formatting().price();
  }


  void formatNumbers() {
    int salary = 147_000;
    int salaryPerMonth = salary / 12;

    NumberFormat us = NumberFormat.getInstance(Locale.US);
    //12,250
    System.out.println(us.format(salaryPerMonth));

    NumberFormat it = NumberFormat.getInstance(Locale.ITALY);
    //12.250
    System.out.println(it.format(salaryPerMonth));

    NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
    //12 250
    System.out.println(fr.format(salaryPerMonth));
  }

  void price() {
    double price = 40;
    NumberFormat locale = NumberFormat.getCurrencyInstance();
    //£40.00
    System.out.println(locale.format(price));

    NumberFormat italy = NumberFormat.getCurrencyInstance(Locale.ITALY);
    //40,00 €
    System.out.println(italy.format(price));

    Locale ch = new Builder()
        .setLanguage(Locale.GERMAN.getLanguage())
        .setRegion("CH")
        .build();

    NumberFormat swissCurrency = NumberFormat.getCurrencyInstance(ch);
    //CHF 40.00
    System.out.println(swissCurrency.format(price));
  }

  void parse() throws ParseException {
    String value = "80.5";
    NumberFormat us = NumberFormat.getInstance(Locale.US);
    //80.5
    System.out.println(us.parse(value));

    NumberFormat italy = NumberFormat.getInstance(Locale.ITALY);
    //805
    System.out.println(italy.parse(value));

    String valueIT = "80,5";
    //80.5
    System.out.println(italy.parse(valueIT));

  }

  void currency() {
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.ITALY);
    String price = currencyInstance.format(2D);
    System.out.println(price);

    currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
    price = currencyInstance.format(2D);
    System.out.println(price);

    currencyInstance = NumberFormat.getCurrencyInstance(new Locale.Builder()
        .setRegion("CH")
        .build());
    price = currencyInstance.format(2D);
    System.out.println(price);
  }

  void percentage() {

    double passingValue = 0.72D;
    NumberFormat percentInstanceIT = NumberFormat.getPercentInstance(Locale.GERMANY);
    System.out.println(percentInstanceIT.format(passingValue)); //72 %

    NumberFormat percentInstanceUS = NumberFormat.getPercentInstance(Locale.US);
    System.out.println(percentInstanceUS.format(passingValue)); //72%
  }
}
