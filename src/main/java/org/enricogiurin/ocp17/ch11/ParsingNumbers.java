package org.enricogiurin.ocp17.ch11;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class ParsingNumbers {

  public static void main(String[] args) throws ParseException {
    new ParsingNumbers().parseSwissSalaries();
  }

  void parse() throws ParseException {
    String value = "30.85";
    NumberFormat numberFormat = NumberFormat.getInstance(Locale.ITALY);
    Number parse = numberFormat.parse(value);
    System.out.println(parse); //3085
    //In Italy we use comma, to separate

    numberFormat = NumberFormat.getInstance(Locale.US);
    parse = numberFormat.parse(value);
    System.out.println(parse); //30.85

    Locale swissGerman = new Locale("de", "CH", "Zurich");
    numberFormat = NumberFormat.getInstance(swissGerman);
    parse = numberFormat.parse(value);
    System.out.println(parse); //30.85
  }

  void parseIncome() throws ParseException {
    String income = "$92,807.99";
    var cf = NumberFormat.getCurrencyInstance(Locale.US);
    double value = (Double) cf.parse(income);
    System.out.println(value);  // 92807.99
  }

  //TODO - fix this code
  void parseSwissSalaries() throws ParseException {
    String salary = "153,000.25 CHF";
    Locale swissGerman = new Locale("de", "CH");
    Currency chfCurrency = Currency.getInstance("CHF");
    String chf = chfCurrency.getCurrencyCode();
    System.out.println(chf);
    var cf = NumberFormat.getCurrencyInstance(swissGerman);
    cf.setCurrency(chfCurrency);
    //Exception in thread "main" java.text.ParseException: Unparseable number: "CHF153’000.25"
    double value = (Double) cf.parse(salary);
    System.out.println(value);
  }

}
