package org.enricogiurin.ocp17.ch4.string;

public class MethodsOfString {

  public static void main(String[] args) {
    new MethodsOfString().trim();
  }
  void replace() {
    String name = "Enrico";
    StringBuilder sb = new StringBuilder("coII");
    //replace take CharSequence as parameters so I can even pass a Substring
    String result = name.replace("co", sb);
    System.out.println(result);
  }

  void strip() {
    String value = " Enrico Giurin  ";
    //# Enrico Giurin  #
    print(value);

    //remove blank space from the beginning and end of the string
    //#Enrico Giurin#
    print(value.strip());

  }

  void stripNL() {
    String source = "\tTomorrow is saturday\n\t";
    System.out.println(source);
    //#Tomorrow is saturday#
    print(source.strip());
  }

  void stripLeadingTrailing() {
    String source = " ciao ";
   // #ciao #
    print(source.stripLeading());
    //# ciao#
    print(source.stripTrailing());
  }

  void trim() {
    String source = " ciao \n";
    String target = source.trim();
    print(target);
  }


  private void print(String target) {
    System.out.println("#"+target+"#");
  }

}
