package org.enricogiurin.ocp17.crashcourse.casting;

public class Q {

  public static void main(String[] args) {
    Object obj = "Hel";
    System.out.println(obj instanceof String str && str.length() > 3 ?
        str : "Nope");

    if (!(obj instanceof String str) || str.length() <= 3) {
      System.out.println("Nope");
    } else {
      System.out.println(str);
    }
  }
}
