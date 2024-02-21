package org.enricogiurin.ocp17.book.ch2;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

@JarMockTest
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

  void intChar() {
    Character c = 5;
    char d = 4;
    System.out.println(d);

    char diff = 'z' - 26;
    int diffInt = 'z' - 26;
    System.out.println(diff);  //`
    System.out.println(diffInt); //96
    int delta = 'z' - 'a';
    System.out.println(delta);  //25
  }

  /**
   * Character is not a numeric type and therefore doesn’t supply a byteValue() or intValue method
   * method.
   */
  void methodsOfCharacter() {
    Character a = Character.valueOf('a');
    char c = a.charValue();
    //there ain't intValue()
    //a.intValue()  //does not compile!

  }

}
