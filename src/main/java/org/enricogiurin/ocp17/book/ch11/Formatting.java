package org.enricogiurin.ocp17.book.ch11;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class Formatting {

  public static void main(String[] args) throws ParseException {
    new Formatting().percentage();
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



  void percentage() {

    double passingValue = 0.72D;
    NumberFormat percentInstanceIT = NumberFormat.getPercentInstance(Locale.GERMANY);
    System.out.println(percentInstanceIT.format(passingValue)); //72 %

    NumberFormat percentInstanceUS = NumberFormat.getPercentInstance(Locale.US);
    System.out.println(percentInstanceUS.format(passingValue)); //72%
  }
}
