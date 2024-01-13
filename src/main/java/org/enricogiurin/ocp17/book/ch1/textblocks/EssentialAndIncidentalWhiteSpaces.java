package org.enricogiurin.ocp17.book.ch1.textblocks;

import static org.enricogiurin.ocp17.various.helper.TextHelper.wrap;

public class EssentialAndIncidentalWhiteSpaces {

  public static void main(String[] args) {
    new EssentialAndIncidentalWhiteSpaces().triple();
  }
  void usage() {
    var tb = """
               \s""";
    System.out.println(wrap(tb));
  }

  void title(){
    var tb = """
        "1Z0-829 
         preparation""";
    System.out.println(wrap(tb));
  }

  void triple(){
    var tb = """
        \"Here we go\"""";
    System.out.println(tb);

    var tb2 = """
       "Here we go\"""";
    System.out.println(tb2);
  }

}
