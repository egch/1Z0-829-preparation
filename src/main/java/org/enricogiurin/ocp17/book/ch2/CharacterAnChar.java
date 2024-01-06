package org.enricogiurin.ocp17.book.ch2;

import org.enricogiurin.ocp17.various.helper.Enthuware;

@Enthuware
public class CharacterAnChar {

  public static void main(String[] args) {
    new CharacterAnChar().intChar();
  }

  void autobox() {
    char c = 'a';
    Character d = c;

    Character e = 'b';
    Character f = Character.valueOf('a');

    //
  }

  void intChar(){
    Character c = 5;
    char d = 4;
    System.out.println(d);

    char diff = 'z'-26;
    int diffInt = 'z'-26;
    System.out.println(diff);  //`
    System.out.println(diffInt); //96
    int delta = 'z'-'a';
    System.out.println(delta);  //25
  }

}
