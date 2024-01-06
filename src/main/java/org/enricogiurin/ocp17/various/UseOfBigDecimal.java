package org.enricogiurin.ocp17.various;

import java.math.BigDecimal;

public class UseOfBigDecimal {

  public static void main(String[] args) {
    new UseOfBigDecimal().addDouble();
  }

  void add() {
    BigDecimal num1 = new BigDecimal("0.2");
    BigDecimal num2 = new BigDecimal("0.1");

    BigDecimal result = num1.add(num2);
    System.out.println(result); // Prints 0.3
  }

  //wrong way
  void addDouble() {
    BigDecimal num1 = new BigDecimal(2D/10);
    BigDecimal num2 = new BigDecimal(1D/10);

    BigDecimal result = num1.add(num2);
    //0.3000000000000000166533453693773481063544750213623046875
    System.out.println(result); // Prints 0.3
  }

}
