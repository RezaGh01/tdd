package org.example;

public class Sum implements Expression {
    public final Money augend;
    public final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

}
