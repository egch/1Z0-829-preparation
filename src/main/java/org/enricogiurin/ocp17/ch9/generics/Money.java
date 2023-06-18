package org.enricogiurin.ocp17.ch9.generics;

import java.math.BigDecimal;

public class Money<T> {
    private T currency;
    private BigDecimal amount;


    public Money(T currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public BigDecimal getAmountInDollars() {
        return amount;
    }

    public static void main(String[] args) {
        //Money<Dollar> dollar = new Money<>()

    }


}

class Dollar {}
