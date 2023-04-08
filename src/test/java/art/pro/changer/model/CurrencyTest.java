package art.pro.changer.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CurrencyTest {

    @Test
    public void testGetIndex() {
        Assertions.assertEquals(5, Currency.USD_TO_AMD.getIndex());
        Assertions.assertEquals(6, Currency.AMD_TO_USD.getIndex());
        Assertions.assertEquals(7, Currency.EUR_TO_AMD.getIndex());
        Assertions.assertEquals(8, Currency.AMD_TO_EUR.getIndex());
        Assertions.assertEquals(9, Currency.RUR_TO_AMD.getIndex());
        Assertions.assertEquals(10, Currency.AMD_TO_RUR.getIndex());
        Assertions.assertEquals(11, Currency.GBP_TO_AMD.getIndex());
        Assertions.assertEquals(12, Currency.AMD_TO_GBP.getIndex());
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("USD_TO_AMD", Currency.USD_TO_AMD.getName());
        Assertions.assertEquals("AMD_TO_USD", Currency.AMD_TO_USD.getName());
        Assertions.assertEquals("EUR_TO_AMD", Currency.EUR_TO_AMD.getName());
        Assertions.assertEquals("AMD_TO_EUR", Currency.AMD_TO_EUR.getName());
        Assertions.assertEquals("RUR_TO_AMD", Currency.RUR_TO_AMD.getName());
        Assertions.assertEquals("AMD_TO_RUR", Currency.AMD_TO_RUR.getName());
        Assertions.assertEquals("GBP_TO_AMD", Currency.GBP_TO_AMD.getName());
        Assertions.assertEquals("AMD_TO_GBP", Currency.AMD_TO_GBP.getName());
    }
}