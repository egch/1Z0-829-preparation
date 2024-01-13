package org.enricogiurin.ocp17.book.ch4.string;

import static org.enricogiurin.ocp17.various.helper.TextHelper.wrap;

public class StripString {

  public static void main(String[] args) {
    StripString instance = new StripString();
    instance.strip();
    instance.stripIndent();
    instance.stripLeading();
    instance.stripTrailing();
  }
  static final char space = '\u0020';
  static final String original = space+"12345"+space;
  void strip() {

    String strip = original.strip();
    //before: # 12345 # - after: #12345#
    System.out.println("before: %s - after: %s".formatted(wrap(original), wrap(strip)));
  }

  void stripIndent() {
    String stripIndent = original.stripIndent();
    //before: # 12345 # - after: #12345#
    System.out.println("before: %s - after: %s".formatted(wrap(original), wrap(stripIndent)));
  }

  void stripLeading() {
    String stripLeading = original.stripLeading();
    //before: # 12345 # - after: #12345 #
    System.out.println("before: %s - after: %s".formatted(wrap(original), wrap(stripLeading)));
  }

  void stripTrailing() {
    String stripTrailing = original.stripTrailing();
    //before: # 12345 # - after: # 12345#
    System.out.println("before: %s - after: %s".formatted(wrap(original), wrap(stripTrailing)));


  }



}
