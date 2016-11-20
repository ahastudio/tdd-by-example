package com.exampe.money;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Pair, Integer> rates = new HashMap<Pair, Integer>();

    public Money reduce(Expression expression, String currency) {
        return expression.reduce(this, currency);
    }

    public void addRate(String source, String target, int rate) {
        rates.put(new Pair(source, target), rate);
    }

    public int rate(String source, String target) {
        return (source == target) ? 1 : rates.get(new Pair(source, target));
    }
}
