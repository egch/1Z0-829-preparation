package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

public class RBNoDefaultProperties {

  public static void main(String[] args) {
    new RBNoDefaultProperties().load_Default();
  }

  void load_MissingResourceException() {
    //we make sure to set a default locale for which the properties file does not exist.
    Locale.setDefault(Locale.GERMAN);
    Locale fr = new Builder()
        .setLanguage(Locale.FRENCH.getLanguage())
        .build();
    //here we have none of these: NoDefaultProperties_de.properties, NoDefaultProperties_fr.properties, NoDefaultProperties.properties,
    // java.util.MissingResourceException: Can't find bundle for base name ch11.NoDefaultProperties, locale fr
    ResourceBundle rb = ResourceBundle.getBundle("ch11.NoDefaultProperties", fr);
  }

  void load_Default() {
    //we make sure to set a default locale for which the properties file does exist.
    Locale.setDefault(Locale.ITALIAN);
    Locale fr = new Builder()
        .setLanguage(Locale.FRENCH.getLanguage())
        .build();
    //here we have none of these: NoDefaultProperties_fr.properties, NoDefaultProperties.properties.
    //but we have NoDefaultProperties_it.properties
    ResourceBundle rb = ResourceBundle.getBundle("ch11.NoDefaultProperties", fr);
    String hello = rb.getString("hello"); //ciao
    System.out.println(hello);
  }

}
