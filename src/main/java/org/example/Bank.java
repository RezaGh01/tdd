package org.example;

import java.util.Hashtable;
import java.util.Objects;

public class Bank {

    private final Hashtable<Pair<String, String>, Double> exchangeRate = new Hashtable<>();

    public Bank() {
        exchangeRate.put(new Pair("USD", "CHF"), 2d);
        exchangeRate.put(new Pair("CHF", "USD"), 0.5d);
    }

    public Money exchange(Money money, String toCurrency) {
        return new Money(
                money.amount * getExchangeRate(money.currency, toCurrency),
                toCurrency
        );
    }

    private double getExchangeRate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return 1;
        }
        return this.exchangeRate.get(new Pair<>(fromCurrency, toCurrency));
    }

    public class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

}
