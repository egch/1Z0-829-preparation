package org.enricogiurin.ocp17.book.ch7.useofenum;

import org.enricogiurin.ocp17.various.helper.Enthuware;

@Enthuware
public class EnumWithStaticNotFinalField {

  enum Api {
    UPDATE("update the data"), READ("read the data");
    private String description;
    private static String version = "2.0";
    private static final String firstVersion = "1.0";

    Api(String description) {
      this.description = description;
      System.out.println(firstVersion);  //this is fine

      //It is illegal to access (not final) static member 'version' from enum constructor or instance initializer
      //( JLS 8.9.2 )
      //System.out.println(version);  //does not compile

    }
  }

}
