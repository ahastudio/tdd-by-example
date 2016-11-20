package com.example.money;

import com.exampe.money.Bank;
import com.exampe.money.Expression;
import com.exampe.money.Money;
import com.exampe.money.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MoneyTest {
    @Test
    public void muliplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void equality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(6).equals(Money.dollar(5)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(6).equals(Money.franc(5)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void currency() {
        assertEquals(Money.USD, Money.dollar(5).currency());
        assertEquals(Money.CHF, Money.franc(5).currency());
        assertNotEquals(Money.dollar(5).currency(), Money.franc(5).currency());
    }

    @Test
    public void simpleAddtion() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, Money.USD);
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void reduceMoney() {
        Expression five = Money.dollar(5);
        Bank bank = new Bank();
        Money reduced = bank.reduce(five, Money.USD);
        assertEquals(Money.dollar(5), reduced);
    }

    @Test
    public void changeWithReduce() {
        Bank bank = new Bank();
        bank.addRate(Money.CHF, Money.USD, 2);
        Money reduced = bank.reduce(Money.franc(10), Money.USD);
        assertEquals(Money.dollar(5), reduced);
    }

    @Test
    public void pair() {
        assertEquals(new Pair(Money.USD, Money.CHF),
                new Pair(Money.USD, Money.CHF));
        assertNotEquals(new Pair(Money.USD, Money.CHF),
                new Pair(Money.CHF, Money.USD));
    }

    @Test
    public void mixedAddtion() {
        Bank bank = new Bank();
        bank.addRate(Money.CHF, Money.USD, 2);
        Expression sum = Money.dollar(5).plus(Money.franc(10));
        Money reduced = bank.reduce(sum, Money.USD);
        assertEquals(Money.dollar(10), reduced);
    }
}
