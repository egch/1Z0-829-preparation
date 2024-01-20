package org.enricogiurin.ocp17.book.ch5;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

@JarMockTest
public class AnotherStaticInitializer {
  public static void main(String[] args){
    //10
    System.out.println(Sub.ID);
  }
}

class Super { static String ID = "10"; }

class Sub extends Super{
  static { System.out.print("static Sub");
  }
}

