package com.exampe.money;

public interface Expression {
    Money reduce(Bank bank, String currency);
}
