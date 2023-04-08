package art.pro.changer.controller;

import art.pro.changer.dom.RateParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final RateParser parser;

    public MainController(RateParser parser){
        this.parser = parser;
    }

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @PostMapping("/analyze")
    public String resultPage(@RequestParam("inputted-amount") double inputtedAmount,
                             @RequestParam("currency-from") String currencyFrom,
                             @RequestParam("currency-to") String currencyTo, Model model) {

        double changeResult = parser.changeMoney(currencyFrom, currencyTo, inputtedAmount);

        if(changeResult == -1 || inputtedAmount == 0) {
            return "homepage";
        }

        String bestBank = parser.getBestBank();
        String googleMapUrl = "https://www.google.com/maps/search/" + bestBank;

        model.addAttribute("from", currencyFrom);
        model.addAttribute("to", currencyTo);
        model.addAttribute("inputtedamount", inputtedAmount);
        model.addAttribute("changeresult", changeResult);
        model.addAttribute("bestbank", bestBank);
        model.addAttribute("mapurl", googleMapUrl);

        return "result-page";
    }
}