package org.enricogiurin.ocp17.ch7.casting;

public class CastingInterfaces {

  public static void main(String[] args) {
    new CastingInterfaces().instanceOf();
  }
  void classCastException() {
    Enrico enrico = new Enrico();
    //explicit cast is allowed at compile time even if Sport and Lazy are unrelated
    //but it fails at runtime

    //Exception in thread "main" java.lang.ClassCastException: class org.enricogiurin.ocp17.ch7.casting.Enrico cannot be cast to class org.enricogiurin.ocp17.ch7.casting.Sport
    Sport enricoDoesSport = (Sport)enrico;
  }

  void instanceOf() {
    Enrico enrico = new Enrico();
    if(enrico instanceof Sport sport){
      System.out.println("enrico does sport");
    }

  }


}

interface Sport {}
interface Lazy {}

class Enrico implements Lazy {}
