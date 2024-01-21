package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Locale.Category;

public class FormattingCurrency {

  public static void main(String[] args) {
    new FormattingCurrency().defaultNoEffect();
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

  //While three distinct locale values are set,
  // the one that is used for formatting text is Category.FORMAT.
  // For this reason, the ITALY locale is used to format the data with the €
  void categoryFormat() {
    double amount = 12.3D;
    Locale.setDefault(Locale.US);
    Locale.setDefault(Category.FORMAT, Locale.ITALY);
    Locale.setDefault(Category.DISPLAY, Locale.UK);

    System.out.print(NumberFormat.getCurrencyInstance()
        .format(amount));  //12,30 €
  }

  void defaultNoEffect() {
    double amount = 12.3D;
    Locale.setDefault(Locale.US);
    Locale.setDefault(Category.FORMAT, Locale.ITALY);
    Locale.setDefault(Category.DISPLAY, Locale.UK);

    //since I pass the specific locale to the method, the default set has no effect
    System.out.print(NumberFormat.getCurrencyInstance(Locale.US)
        .format(amount));  //$12.30
  }

}
