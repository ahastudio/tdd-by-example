package com.exampe.money;

public class Sum implements Expression {
    private Money augend;
    private Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String currency) {
        int amount = augend.reduce(bank, currency).amount +
                addend.reduce(bank, currency).amount;
        return new Money(amount, currency);
    }
}
