package org.enricogiurin.ocp17.book.ch11.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooResourceBundle {

  public static void main(String[] args) {
    new ZooResourceBundle().specificKeysWithDefaultItalian();
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

  /**
   * "f a key is found in Italian, the program no longer searches for keys in the default path (german)
   */
  void specificKeys(){
    Locale it = Locale.ITALIAN;
    Locale de = Locale.GERMAN;
    Locale.setDefault(de);
    ResourceBundle bundle = ResourceBundle.getBundle("ch11.Zoo", it);
    String onlyit = bundle.getString("onlyit");
    //Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key onlyde
    String onlyde = bundle.getString("onlyde");
    System.out.println("onlyit: %s - onlyde: %s".formatted(onlyit, onlyde));
  }

  /**
   * here we test the inverse condition: Default Italian, chosen German.
   * You can see that here once that we find a path with german, it no longer goes to the default path (italian)
   */
  void specificKeysWithDefaultItalian(){
    Locale it = Locale.ITALIAN;
    Locale de = Locale.GERMAN;
    Locale.setDefault(it);
    ResourceBundle bundle = ResourceBundle.getBundle("ch11.Zoo", de);
    String onlyde = bundle.getString("onlyde");
    //Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key onlyit
    String onlyit = bundle.getString("onlyit");
    System.out.println("onlyit: %s - onlyde: %s".formatted(onlyit, onlyde));
  }
}
