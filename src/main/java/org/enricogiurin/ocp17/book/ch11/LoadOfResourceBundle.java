package org.enricogiurin.ocp17.book.ch11;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoadOfResourceBundle {

  public static void main(String[] args) {
    new LoadOfResourceBundle().fruitsUsingDefault();
  }

  void load() {

    //1. Dolphins_fr.properties
    //2. Dolphins.properties

    //Once a bundle is chosen, only resources in that hierarchy are allowed
    //so if we start with  Dolphins_fr.properties we cannot later go with  Dolphins_en.properties
    //even if it's the default locale

    var fr = new Locale("fr");
    Locale.setDefault(new Locale("en", "US"));
    var b = ResourceBundle.getBundle("ch11.Dolphins", fr);
    String name = b.getString("name");
    String age = b.getString("age");
    //name: Dolly - age: 0
    System.out.println(String.format("name: %s - age: %s", name, age));
  }

  void fruits() {
    Locale.setDefault(new Locale("it", "CH"));
    Locale italy = new Locale(Locale.ITALIAN.getLanguage(), Locale.ITALY.getCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("ch11.Fruits", italy);
    String value = bundle.getString("grapes"); //Uva Ialia (it_IT)
    System.out.println(value);
    value = bundle.getString("peach"); //pesca (it)
    System.out.println(value);
    value = bundle.getString("strawberry"); //strawberry ()
    System.out.println(value);
    //Can't find resource for bundle java.util.PropertyResourceBundle, key mango
    //mango is (only) defined in it_CH but it won't be considered
    try {
      value = bundle.getString("mango");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    //reading message
    value = bundle.getString("message");
    System.out.println(MessageFormat.format(value, "Pere", "Kiwi"));
  }

  void fruitsUsingDefault() {
    Locale.setDefault(new Locale("it", "CH"));
    Locale us = new Locale("en", "US");
    ResourceBundle bundle = ResourceBundle.getBundle("ch11.Fruits", us);
    //there ain't bundle for US, so it will be used the default
    String value = bundle.getString("grapes"); //Uva (it)
    System.out.println(value);
    value = bundle.getString("mango"); //(it-ch)
    System.out.println(value);
  }
}
