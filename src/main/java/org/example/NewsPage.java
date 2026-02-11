package org.example;

public abstract class NewsPage {
    private String headline;
    private String text;
    private int punctuation;
    private int price = 0;
    private Editor editor;

    public NewsPage(String headline, String text, int punctuation, Editor editor) {
        this.headline = headline;
        this.text = text;
        this.punctuation = punctuation;
        this.editor = editor;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public abstract int calculateNewsPagePrice();
}
