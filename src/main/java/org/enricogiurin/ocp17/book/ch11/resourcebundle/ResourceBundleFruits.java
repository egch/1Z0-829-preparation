package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleFruits {

  public static void main(String[] args) {
    new ResourceBundleFruits().fruits();
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
    } catch (MissingResourceException e) {
      System.err.println(e.getMessage());
    }

    //reading message
    value = bundle.getString("message");
    //Mi piacciono le Pere e Kiwi
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
