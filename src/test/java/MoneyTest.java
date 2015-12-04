import com.woowahan.tdd.money.Dollar;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// (V) $5 * 2 = $10
// (V) Dollar side effect? -> FP in Scala
// (V) equality
// $5 + 10CHF = $10 (환율 2:1)
// amount 필드를 private
// Money 반올림?
// hashCode
// equal null
// equal object -> dollar가 아닌 게 들어오면?

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
        Dollar dollar = new Dollar(5);
        assertEquals(10, dollar.times(2).amount);
        assertEquals(15, dollar.times(3).amount);
    }

    @Test
    public void equality() {
        Dollar dollar = new Dollar(5);
        assertTrue(new Dollar(5).equals(dollar));
        assertFalse(new Dollar(6).equals(dollar));
    }
}
