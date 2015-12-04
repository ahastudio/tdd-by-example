package com.woowahan.tdd.money;

public class Money {
    protected int amount;

    @Override
    public boolean equals(Object other) {
        Money money = (Money) other;
        return this.getClass() == other.getClass() &&
                this.amount == money.amount;
    }
}
