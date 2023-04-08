package art.pro.changer.dom;

import java.io.IOException;

import art.pro.changer.model.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class RateParser {

    private final Document document =
            Jsoup.connect("https://rate.am/en/armenian-dram-exchange-rates/banks/cash").get();

    public RateParser() throws IOException {}

    private final Element mainTable = document.getElementById("rb");
    private final Elements bankNames = mainTable.getElementsByClass("bank");
    private final Element[] banks = new Element[18];
    private String bestBank;

    public double changeMoney(String currencyFrom, String currencyTo, double amount) {

        double changeResult;
        selectBanks();
        if(!(currencyFrom.equals(currencyTo))){
            if(currencyFrom.equals(Currency.AMD.getName())){
                changeResult = amount / findBestOffer(Currency.valueOf("AMD_TO_" + currencyTo));
            }
            else if(currencyTo.equals(Currency.AMD.getName())) {
                changeResult = amount * findBestOffer(Currency.valueOf(currencyFrom + "_TO_AMD"));
            }
            else {
                changeResult = amount * findBestOffer(Currency.valueOf(currencyFrom + "_TO_AMD"),
                        Currency.valueOf("AMD_TO_" + currencyTo));
            }
        } else {
            changeResult = -1; // to avoid double choice of the same currency
        }
        return Double.parseDouble(String.format("%.2f", changeResult));
    }

    private double findBestOffer(Currency currency) {
        int index = currency.getIndex();
        boolean toAMD = index % 2 != 0;
        double best = Double.parseDouble(banks[0].child(index).text());

        for(Element bank : banks) {
            if(!(bank.child(index).text().equals(""))) {
                double currentBankOffer = Double.parseDouble(bank.child(index).text());
                if(toAMD) {
                    if(currentBankOffer > best) {
                        best = currentBankOffer;
                        setBestBank(bank.child(1).text());
                    }
                } else {
                    if(currentBankOffer < best) {
                        best = currentBankOffer;
                        setBestBank(bank.child(1).text());
                    }
                }
            }
        }
        return best;
    }

    private double findBestOffer(Currency currencyFrom, Currency currencyTo) {

        int indexFrom = currencyFrom.getIndex();
        int indexTo = currencyTo.getIndex();
        double best = Double.parseDouble(banks[0].child(indexFrom).text()) / Double.parseDouble(banks[0].child(indexTo).text());

        for(Element bank : banks) {
            if(!(bank.child(indexFrom).text().equals("") || bank.child(indexTo).text().equals(""))) {
                double from = Double.parseDouble(bank.child(indexFrom).text());
                double to = Double.parseDouble(bank.child(indexTo).text());
                if(from / to > best) {
                    best = from / to;
                    setBestBank(bank.child(1).text());
                }
            }
        }
        return best;
    }

    private void selectBanks() {
        for(int i = 0; i < banks.length; i++) {
            banks[i] = bankNames.get(i).parent();
        }
    }

    public String getBestBank() {
        return bestBank;
    }

    private void setBestBank(String bestBank) {
        this.bestBank = bestBank;
    }
}