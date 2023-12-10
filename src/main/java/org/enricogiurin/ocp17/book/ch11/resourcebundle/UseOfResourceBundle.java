package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class UseOfResourceBundle {

  public static void main(String[] args) {
    new UseOfResourceBundle().zoo();
  }

  void zoo() {
    Locale it = new Locale(Locale.ITALIAN.getLanguage(), Locale.ITALY.getCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("ch11.Zoo", it);
    //Ciao, Lo zoo è aperto
    System.out.println(bundle.getString("hello") + ", " + bundle.getString("open"));
    ResourceBundle defaultBundle = ResourceBundle.getBundle("ch11.Zoo");
    //Hello, The Zoo is open
    System.out.println(defaultBundle.getString("hello") + ", " + defaultBundle.getString("open"));
  }
}
