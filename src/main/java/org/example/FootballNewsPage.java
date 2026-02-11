package org.example;

public class FootballNewsPage extends NewsPage{
    private final int basePrice = 300;
    private boolean isChampions;
    private boolean isBarcaOrMadrid;
    private boolean isFerranTorresOrBenzema;

    public FootballNewsPage(String headline, String text, int punctuation, boolean isChampions, boolean isBarcaOrMadrid, boolean isFerranTorresOrBenzema, Editor editor) {
        super(headline, text, punctuation, editor);
        this.isChampions = isChampions;
        this.isBarcaOrMadrid = isBarcaOrMadrid;
        this.isFerranTorresOrBenzema = isFerranTorresOrBenzema;
    }

    @Override
    public int calculateNewsPagePrice() {
        int price = super.getPrice() + basePrice;
        if (isChampions) {price += 100;}
        if (isBarcaOrMadrid) {price += 100;}
        if (isFerranTorresOrBenzema) {price += 50;}
        return price;
    }
}
