package org.example;

public class BasketballNewsPage extends NewsPage {
    private final int basePrice = 250;
    private boolean isEuroleague;
    private boolean isBarcaOrMadrid;

    public BasketballNewsPage(String headline, String text, int punctuation, boolean isEuroleague, boolean isBarcaOrMadrid) {
        super(headline, text, punctuation);
        this.isEuroleague = isEuroleague;
        this.isBarcaOrMadrid = isBarcaOrMadrid;
    }

    @Override
    public int calculateNewsPagePrice() {
        int price = super.getPrice() + basePrice;
        if (isEuroleague) {price += 75;}
        if (isBarcaOrMadrid) {price += 75;}
        return price;
    }
}
