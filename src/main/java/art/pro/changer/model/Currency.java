package art.pro.changer.model;

public enum Currency {

    AMD("AMD"),
    RUR("RUR"),
    USD("USD"),
    GBP("GBP"),

    USD_TO_AMD(5, "USD_TO_AMD"),
    AMD_TO_USD(6, "AMD_TO_USD"),
    EUR_TO_AMD(7, "EUR_TO_AMD"),
    AMD_TO_EUR(8, "AMD_TO_EUR"),
    RUR_TO_AMD(9, "RUR_TO_AMD"),
    AMD_TO_RUR(10, "AMD_TO_RUR"),
    GBP_TO_AMD(11, "GBP_TO_AMD"),
    AMD_TO_GBP(12, "AMD_TO_GBP");

    private String name;
    private int index;

    Currency(String name){
        this.name = name;
    }
    Currency(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName(){
        return name;
    }
}