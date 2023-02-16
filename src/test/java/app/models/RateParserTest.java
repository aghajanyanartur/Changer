package app.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RateParserTest {

    private RateParser rateParser;

    @BeforeEach
    public void setup() throws Exception {
        rateParser = new RateParser();
    }

    @Test
    public void testChangeMoney() {
        // Test changing from USD to AMD with an amount of 100
        double result = rateParser.changeMoney("USD", "AMD", 100);
        Assertions.assertTrue(result > 0);

        // Test changing from AMD to USD with an amount of 50000
        result = rateParser.changeMoney("AMD", "USD", 50000);
        Assertions.assertTrue(result > 0);

        // Test changing from USD to GBP with an amount of 1000
        result = rateParser.changeMoney("USD", "GBP", 1000);
        Assertions.assertTrue(result > 0);
    }

    @Test
    public void testGetBestBank() {
        // Test that the best bank is not null after calling changeMoney()
        rateParser.changeMoney("USD", "AMD", 100);
        String bestBank = rateParser.getBestBank();
        Assertions.assertNotNull(bestBank);
    }
}