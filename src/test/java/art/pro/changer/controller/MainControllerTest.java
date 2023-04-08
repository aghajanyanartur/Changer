package art.pro.changer.controller;

import art.pro.changer.dom.RateParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.io.IOException;

public class MainControllerTest {

    private RateParser parser;
    private MainController mainController;

    @BeforeEach
    public void setup() throws IOException {
        parser = new RateParser();
        mainController = new MainController(parser);
    }

    @Test
    public void homePageTest() {
        String result = mainController.homePage();
        Assertions.assertEquals("homepage", result);
    }

    @Test
    public void resultPageTest() {

        double inputtedAmount = 10.0;
        String currencyFrom = "USD";
        String currencyTo = "EUR";
        Model model = new ExtendedModelMap();
        String result = mainController.resultPage(inputtedAmount, currencyFrom, currencyTo, model);
        Assertions.assertEquals("result-page", result);
        Assertions.assertEquals(currencyFrom, model.asMap().get("from"));
        Assertions.assertEquals(currencyTo, model.asMap().get("to"));
        Assertions.assertEquals(inputtedAmount, model.asMap().get("inputtedamount"));
        Assertions.assertEquals(parser.changeMoney(currencyFrom, currencyTo, inputtedAmount), model.asMap().get("changeresult"));
        Assertions.assertEquals(parser.getBestBank(), model.asMap().get("bestbank"));
        Assertions.assertEquals("https://www.google.com/maps/search/" + parser.getBestBank(), model.asMap().get("mapurl"));
    }

    @Test
    public void resultPageInvalidAmountTest() throws IOException {
        parser = new RateParser();
        double inputtedAmount = 0.0;
        String currencyFrom = "USD";
        String currencyTo = "EUR";
        Model model = new ExtendedModelMap();
        String result = mainController.resultPage(inputtedAmount, currencyFrom, currencyTo, model);
        Assertions.assertEquals("homepage", result);
    }
}