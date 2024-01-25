package org.enricogiurin.ocp17.book.ch5;

import java.time.LocalDate;

public class FinalLocalVariables {

  public static void main(String[] args) {
    new FinalLocalVariables().finalObject();
  }
  void finalVariables() {
    final int x = 5;
    //x = 6; // DOES NOT COMPILE!
  }
  void finalInitializationWIthIf() {
    final int age;
    if(LocalDate.now().getDayOfMonth()%2==0){
      age = 40;
    } else{
      age = 30;
    }
  }

  void finalInitializationWIthIfOnlyCase(){
    final int x;
    if(Math.random()>0.5){
      x = 6;
    }
    //Variable 'x' might not have been initialized
    //System.out.println(x);  //DOES NOT COMPILE!
  }

  void finalObject() {
    final StringBuilder sb = new StringBuilder("ocp 17");
    //sb is final but only the reference to it
    sb.append(" - exam");
    //Cannot assign a value to final variable 'sb'
    //sb = new StringBuilder("OCP 8"); //DOES NOT COMPILE!

    System.out.println(sb);  //ocp 17 - exam
  }

}
