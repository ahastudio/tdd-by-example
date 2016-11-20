package com.exampe.money;

public class Money implements Expression {
    public static final String USD = "USD";
    public static final String CHF = "CHF";

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, USD);
    }

    public static Money franc(int amount) {
        return new Money(amount, CHF);
    }

    @Override
    public boolean equals(Object obj) {
        Money other = (Money) obj;
        if (currency != other.currency) {
            return false;
        }
        return this.amount == other.amount;
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public Expression plus(Money other) {
        return new Sum(this, other);
    }

    public Money reduce(Bank bank, String currency) {
        int rate = bank.rate(this.currency, currency);
        return new Money(amount / rate, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money: " + amount + " (" + currency + ")";
    }
}
