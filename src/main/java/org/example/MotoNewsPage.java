package org.example;

public class MotoNewsPage extends NewsPage{
    private final int basePrice = 100;
    private boolean isHondaOrYamaha;

    public MotoNewsPage(String headline, String text, int punctuation, boolean isHondaOrYamaha) {
        super(headline, text, punctuation);
        this.isHondaOrYamaha = isHondaOrYamaha;
    }

    @Override
    public int calculateNewsPagePrice() {
        int price = super.getPrice() + basePrice;
        if (isHondaOrYamaha) {price += 50;}
        return price;
    }
}
