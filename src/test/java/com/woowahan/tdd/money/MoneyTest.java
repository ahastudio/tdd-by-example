package com.woowahan.tdd.money;

import com.woowahan.tdd.money.Dollar;
import com.woowahan.tdd.money.Franc;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// (V) $5 * 2 = $10
// (V) Dollar side effect? -> FP in Scala
// (V) equality
// (V) amount 필드를 private
// (V) 5CHF * 2 = 10CHF
// (V) equals 중복
// (V) 다른 통화일 때 equals 문제
// $5 + 10CHF = $10 (환율 2:1)
// Money 반올림?
// hashCode
// equal null
// equal object -> dollar가 아닌 게 들어오면?
// Dollar/Franc 중복
// times 중복

// 1. red
// 2. green
// 3. refactoring (중복 제거 + 의미를 드러내기)

public class MoneyTest {
//    @Test
//    public void testSample() {
//        assertEquals(Dollar(5), Dollar(5) + Fran(10));
//    }

    @Test
    public void dollar() {
        assertEquals(new Dollar(10), new Dollar(5).times(2));
        assertEquals(new Dollar(15), new Dollar(5).times(3));
    }

    @Test
    public void franc() {
        assertEquals(new Franc(10), new Franc(5).times(2));
        assertEquals(new Franc(15), new Franc(5).times(3));
    }

    @Test
    public void equality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(6).equals(new Dollar(5)));

        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(6).equals(new Franc(5)));

        assertFalse(new Dollar(5).equals(new Franc(5)));
    }
}
