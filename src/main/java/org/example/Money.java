package org.example;

public class Money {
    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    public Money plus(Money money) {
        return new Money(this.amount + money.amount, this.currency);
    }

}
