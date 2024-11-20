package org.example;

public class Bank {
    public Money exchange(Money money, String currency) {
        return new Money(money.amount * 2, currency);
    }
}
