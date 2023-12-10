package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class OrderLoadingResourceBundle {

  public static void main(String[] args) {
    new OrderLoadingResourceBundle().loadMissingResourceException();
  }

  /**
   * 1. Looking for Colors_fr_CH.properties: No Match
   * 2. Looking for Colors_fr.properties: No Match
   * 3. Moving to default Locale -> it_CH:
   * 4. Looking for Colors_it_CH.properties: No Match
   * 5. Looking for Colors_it.properties: No Match
   * 6. Looking for Colors.properties: No Match
   * 7. MissingResourceException
   */

  void loadMissingResourceException() {
    Locale loc = new Locale("fr", "CH");
    Locale.setDefault(new Locale("it", "CH"));
    //RB is under resources/ch11
    ResourceBundle rb = ResourceBundle.getBundle("ch11.Colors", loc);
    //name is present in all the properties file of the RB Colors
    //Exception in thread "main" java.util.MissingResourceException: Can't find bundle for base name ch11.Colors, locale fr_CH
    String name = rb.getString("name");
    System.out.println(name);
  }

}
