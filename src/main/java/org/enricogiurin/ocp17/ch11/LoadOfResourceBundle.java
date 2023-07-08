package org.enricogiurin.ocp17.ch11;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoadOfResourceBundle {

    public static void main(String[] args) {
        new LoadOfResourceBundle().load();
    }
    void load(){

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
}
