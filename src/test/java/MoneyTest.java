import org.example.Bank;
import org.example.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Money fiveDollars = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveDollars.times(2));
        assertEquals(Money.dollar(15), fiveDollars.times(3));

        Money fiveFrancs = Money.franc(5);
        assertEquals(Money.franc(10), fiveFrancs.times(2));
        assertEquals(Money.franc(15), fiveFrancs.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(6));
        assertNotEquals(Money.franc(5), Money.dollar(5));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleSum(){
        assertEquals(Money.dollar(10), Money.dollar(5).plus(Money.dollar(5)));
        assertEquals(Money.franc(10), Money.franc(5).plus(Money.franc(5)));
    }

  /*  @Test
    public void testComplexSum(){
        assertEquals(Money.dollar(15), Money.dollar(5).plus(Money.franc(5)));
    }*/

    @Test
    public void testBankExchangeRate(){
        Bank bank = new Bank();
        assertEquals(bank.exchange(Money.dollar(10), "CHF"),Money.franc(20));
    }

}
