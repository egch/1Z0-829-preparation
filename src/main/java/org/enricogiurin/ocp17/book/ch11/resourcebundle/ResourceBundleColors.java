package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleColors {

  public static void main(String[] args) {
    new ResourceBundleColors().keySet();
  }

  /**
   * The only valid properties files are: - Colors_en.properties - Colors_en_US.properties -
   * Colors_es.properties
   * <p>
   * 1. Looking for Colors_fr_CH.properties: No Match 2. Looking for Colors_fr.properties: No Match
   * 3. Moving to default Locale -> it_CH: 4. Looking for Colors_it_CH.properties: No Match 5.
   * Looking for Colors_it.properties: No Match 6. Looking for Colors.properties: No Match 7.
   * MissingResourceException
   */

  void loadMissingResourceException() {
    Locale loc = new Locale("fr", "CH");
    Locale.setDefault(new Locale("it", "CH"));
    //RB is under resources/ch11
    ResourceBundle rb = ResourceBundle.getBundle("ch11.Colors", loc);
    //name is present in all the properties file of the RB Colors
    //Exception in thread "main" java.util.MissingResourceException: Can't find a bundle for base name ch11.Colors, locale fr_CH
    String name = rb.getString("name");
    System.out.println(name);
  }

  void keySet() {
    Locale us = new Locale("en", "US");
    ResourceBundle rb = ResourceBundle.getBundle("ch11.Colors", us);
    //key: name - value: John @NY
    for (String key : rb.keySet()) {
      String value = rb.getString(key);
      System.out.println("key: %s - value: %s".formatted(key, value));
    }
  }

}
