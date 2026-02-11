package org.example;

public class F1NewsPage extends NewsPage{
    private final int basePrice = 100;
    private boolean isFerrariOrMercedes;

    public F1NewsPage(String headline, String text, int punctuation, boolean isFerrariOrMercedes, Editor editor) {
        super(headline, text, punctuation, editor);
        this.isFerrariOrMercedes = isFerrariOrMercedes;
    }

    @Override
    public int calculateNewsPagePrice() {
        int price = super.getPrice() + basePrice;
        if (isFerrariOrMercedes) {price += 50;}
        return price;
    }
}
