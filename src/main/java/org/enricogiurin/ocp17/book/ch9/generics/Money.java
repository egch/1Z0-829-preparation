package org.enricogiurin.ocp17.book.ch9.generics;

import java.math.BigDecimal;

public class Money<T> {

  private T currency;
  private BigDecimal amount;

  public Money(T currency, BigDecimal amount) {
    this.currency = currency;
    this.amount = amount;
  }

  public static void main(String[] args) {
    //Money<Dollar> dollar = new Money<>()
  }

  public T createT() {
    //Type parameter 'T' cannot be instantiated directly
    // return new T();
    return null;
  }

  public BigDecimal getAmountInDollars() {
    return amount;
  }


}

class Dollar {

}

class CHF {

}
