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
// $5 + 10CHF = $10 (환율 2:1)
// Money 반올림?
// hashCode
// equal null
// equal object -> dollar가 아닌 게 들어오면?
// Dollar/Franc 중복 제거
// 공용 equals
// 공용 times

// 1. red
// 2. green
// 3. refactoring (중복 제거 + 의미를 드러내기)

public class MoneyTest {
    @Test
    public void testSample() {
//        assertEquals(Dollar(5), Dollar(5) + Fran(10));
    }

    @Test
    public void dollar() {
        Dollar dollar = new Dollar(5);
        assertEquals(new Dollar(10), dollar.times(2));
        assertEquals(new Dollar(15), dollar.times(3));
    }

    @Test
    public void equality() {
        int amount = 5;
        Dollar dollar = new Dollar(amount);
        assertTrue(new Dollar(amount).equals(dollar));
        assertFalse(new Dollar(amount + 1).equals(dollar));
    }

    @Test
    public void francMuliplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
