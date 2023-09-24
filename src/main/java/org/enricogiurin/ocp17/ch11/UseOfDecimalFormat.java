package org.enricogiurin.ocp17.ch11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class UseOfDecimalFormat {

  public static void main(String[] args) {
    new UseOfDecimalFormat().formatWithDefault();
  }

  void format() {
    double wealth = 500_000.45;
    final String format = "###,###,###.000";
    NumberFormat nf = new DecimalFormat(format);
    String result = nf.format(wealth);
    System.out.println(result); //500,000.450
  }

  void formatWithDefault() {
    double wealth = 500_000.45;
    DecimalFormatSymbols customSymbols = new DecimalFormatSymbols(Locale.getDefault());
    customSymbols.setGroupingSeparator('.');
    customSymbols.setDecimalSeparator(',');
    final String format = "###,###,###.000";
    NumberFormat nf = new DecimalFormat(format, customSymbols);
    String result = nf.format(wealth);
    System.out.println(result); //500.000,450

  }

  void chatGPT() {
    String pattern = "###,###.##"; // Thousands separator is a period, decimal separator is a comma

    // Create a DecimalFormat object with the pattern
    DecimalFormatSymbols customSymbols = new DecimalFormatSymbols(Locale.getDefault());
    customSymbols.setGroupingSeparator('.');
    customSymbols.setDecimalSeparator(',');

    DecimalFormat decimalFormat = new DecimalFormat(pattern, customSymbols);

    // Double value representing the money amount
    double moneyAmount = 1000.45;

    // Format the money amount using the DecimalFormat
    String formattedMoneyAmount = decimalFormat.format(moneyAmount);

    // Print the formatted money amount
    System.out.println("Formatted Money Amount: " + formattedMoneyAmount);
  }

}
