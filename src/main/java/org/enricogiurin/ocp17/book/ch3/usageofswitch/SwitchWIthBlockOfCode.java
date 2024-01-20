package org.enricogiurin.ocp17.book.ch3.usageofswitch;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class SwitchWIthBlockOfCode {

  public static void main(String[] args) {
    new SwitchWIthBlockOfCode().switchDefault();
  }

  @JarMockTest
  void switchDefault() {
    var k = 9;
    int result = 5;
    switch (k) {
      default:
        if (k == 10) {
          result *= 2;
        } else {
          result += 5;
          break;
        }
      case 8:
        result = 2;
    }
    System.out.println(result);  //10
  }

}
