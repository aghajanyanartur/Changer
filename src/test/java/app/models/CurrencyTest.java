package app.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CurrencyTest {

    @Test
    public void testGetIndex() {
        assertEquals(5, Currency.USD_TO_AMD.getIndex());
        assertEquals(6, Currency.AMD_TO_USD.getIndex());
        assertEquals(7, Currency.EUR_TO_AMD.getIndex());
        assertEquals(8, Currency.AMD_TO_EUR.getIndex());
        assertEquals(9, Currency.RUR_TO_AMD.getIndex());
        assertEquals(10, Currency.AMD_TO_RUR.getIndex());
        assertEquals(11, Currency.GBP_TO_AMD.getIndex());
        assertEquals(12, Currency.AMD_TO_GBP.getIndex());
    }

    @Test
    public void testGetName() {
        assertEquals("USD_TO_AMD", Currency.USD_TO_AMD.getName());
        assertEquals("AMD_TO_USD", Currency.AMD_TO_USD.getName());
        assertEquals("EUR_TO_AMD", Currency.EUR_TO_AMD.getName());
        assertEquals("AMD_TO_EUR", Currency.AMD_TO_EUR.getName());
        assertEquals("RUR_TO_AMD", Currency.RUR_TO_AMD.getName());
        assertEquals("AMD_TO_RUR", Currency.AMD_TO_RUR.getName());
        assertEquals("GBP_TO_AMD", Currency.GBP_TO_AMD.getName());
        assertEquals("AMD_TO_GBP", Currency.AMD_TO_GBP.getName());
    }
}