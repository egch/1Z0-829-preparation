package org.enricogiurin.ocp17.book.ch11.trywithresources;

import java.util.Scanner;

public class OutOfScope {
  void tryWithResource() {
    try(Scanner sc = new Scanner(System.in)) {
      String s = sc.nextLine();
    }catch (Exception e) {
      //sc at this point is out of scope!
      //System.out.println(sc); does not compile!
    }
  }

}
