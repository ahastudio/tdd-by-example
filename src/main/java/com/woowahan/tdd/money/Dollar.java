package com.woowahan.tdd.money;

public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object other) {
        Dollar dollar = (Dollar) other;
        return this.amount == dollar.amount;
    }
}
