package org.enricogiurin.ocp17.book.ch1.textblocks;

import static org.enricogiurin.ocp17.various.helper.TextHelper.wrap;

public class TextBlocksEscape {

  public static void main(String[] args) {
    new TextBlocksEscape().escapeS();
  }

  void example() {
    var message = """
        otter\
        pup \s
        play
        "toy"
        """;

    //<otterpup
    //play
    //"toy"
    //>
    System.out.println(wrap(message));
  }

  void escapeS() {
    var text = """
        John\sDoe""";
    //John Doe
    System.out.println(text);
  }

}
