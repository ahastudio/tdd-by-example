package com.woowahan.tdd.money;

public class Franc {
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object other) {
        Franc dollar = (Franc) other;
        return this.amount == dollar.amount;
    }
}
