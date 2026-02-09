package org.example;

public class TenisNewsPage extends NewsPage{
    private final int basePrice = 150;
    private boolean isFedererOrNadalOrDjokovik;

    public TenisNewsPage(String headline, String text, int punctuation, boolean isFedererOrNadalOrDjokovik) {
        super(headline, text, punctuation);
        this.isFedererOrNadalOrDjokovik = isFedererOrNadalOrDjokovik;
    }

    @Override
    public int calculateNewsPagePrice() {
        int price = super.getPrice() + basePrice;
        if (isFedererOrNadalOrDjokovik) {price += 100;}
        return price;
    }
}
