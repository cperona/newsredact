package org.example;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Editor> editors = new ArrayList<Editor>();
    private static ArrayList<NewsPage> newsPages = new ArrayList<NewsPage>();
    public static void main(String[] args) {
        //Set salary to all Editors
        Editor.setSalary(1500);
        Scanner sc = new Scanner(System.in);

        System.out.println("" +
                "--------------------\n" +
                "||   NewsRedact   ||\n" +
                "--------------------\n" +
                "The following actions can be made typing a number (1-8): \n" +
                "1. Create new Editor\n" +
                "2. Remove Editor\n" +
                "3. Show all Editors\n" +
                "4. Create a NewsPage\n" +
                "5. Remove a NewsPage\n" +
                "6. Show all NewPages of a given Editor\n" +
                "7. Calculate NewsPage punctuation\n" +
                "8. Calculate NewsPage price\n");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Type the new Editor's name: ");
                String editorName = sc.next();
                System.out.println("Type their ID: ");
                String editorID = sc.next();
                Editor editor = new Editor(editorName, editorID);
                editors.add(editor);
                System.out.printf("New Editor '%s' created\n", editorName);
                clearConsole();
                Main.main(null);
                break;
            case 2:
                System.out.println("Type the Editor's name to be removed: ");
                String editorToRemoveName = sc.next();
                editors.removeAll(findEditorByName(editorToRemoveName));
                System.out.printf("Editor %s removed", editorToRemoveName);
                clearConsole();
                Main.main(null);
                break;
            case 3:
                System.out.println("Showing all editors: ");
                printEditors();

                do {
                    System.out.println("Type 0 to return: ");
                } while (sc.nextInt() != 0);

                clearConsole();
                Main.main(null);
                break;
            case 4:
                System.out.println("Type the Editor name you want to add a NewsPage to: ");
                System.out.println("List of all Editors: ");
                printEditors();
                System.out.println("Type the Editor name here: ");
                String editorToAddNewsPageName = sc.next();
                Editor editorToAddNewsPage = findEditorByName(editorToAddNewsPageName).getFirst();

                System.out.println("Type the headline: ");
                sc.nextLine();
                String headline = sc.nextLine();
                System.out.println("Type corpus: ");
                String text = sc.nextLine();

                System.out.println("What type of NewsPage is? (type 1-5): ");
                printNewsTypes();

                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Is about Champions League? (true|false): ");
                        boolean isChampions = sc.nextBoolean();
                        System.out.println("Is about Madrid or Barça? (true|false): ");
                        boolean isBarcaOrMadridFootball = sc.nextBoolean();
                        System.out.println("Is Ferran Torres or Benzema on the NewsPage? (true|false): ");
                        boolean isFerranTorresOrBenzema = sc.nextBoolean();

                        FootballNewsPage footballNewsPage = new FootballNewsPage(
                                headline,
                                text,
                                12,
                                isChampions,
                                isBarcaOrMadridFootball,
                                isFerranTorresOrBenzema,
                                editorToAddNewsPage
                        );

                        newsPages.add(footballNewsPage);
                        break;

                    case 2:
                        System.out.println("Is about Euroleage? (true|false): ");
                        boolean isEuroleague = sc.nextBoolean();
                        System.out.println("Is about Madrid or Barça? (true|false): ");
                        boolean isBarcaOrMadridBasket = sc.nextBoolean();

                        BasketballNewsPage basketballNewsPage = new BasketballNewsPage(
                                headline,
                                text,
                                12,
                                isEuroleague,
                                isBarcaOrMadridBasket,
                                editorToAddNewsPage
                        );

                        newsPages.add(basketballNewsPage);
                        break;

                    case 3:
                        System.out.println("Is about Federer or Nadal? (true|false): ");
                        boolean isFedererOrNadalOrDjokovik = sc.nextBoolean();

                        TenisNewsPage tenisNewsPage = new TenisNewsPage(
                                headline,
                                text,
                                12,
                                isFedererOrNadalOrDjokovik,
                                editorToAddNewsPage
                        );

                        newsPages.add(tenisNewsPage);
                        break;

                    case 4:
                        System.out.println("Is about Ferrari or Mercedes? (true|false): ");
                        boolean isFerrariOrMercedes = sc.nextBoolean();

                        F1NewsPage f1NewsPage = new F1NewsPage(
                                headline,
                                text,
                                12,
                                isFerrariOrMercedes,
                                editorToAddNewsPage
                        );

                        newsPages.add(f1NewsPage);
                        break;

                    case 5:
                        System.out.println("Is about Honda or Yamaha? (true|false): ");
                        boolean isHondaOrYamaha = sc.nextBoolean();

                        MotoNewsPage motoNewsPage = new MotoNewsPage(
                                headline,
                                text,
                                12,
                                isHondaOrYamaha,
                                editorToAddNewsPage
                        );

                        newsPages.add(motoNewsPage);
                        break;
                }
                clearConsole();
                Main.main(null);
                break;
            case 5:
                System.out.println("Type the NewPage's headline to be removed: ");
                String newsPageHeadline = sc.next();
                newsPages.removeAll(findNewsPageByHeadline(newsPageHeadline));
                System.out.printf("NewsPage %s removed", newsPageHeadline);
                clearConsole();
                Main.main(null);
                break;
            case 6:
                System.out.println("Type the Editor name to show their NewsPages: ");
                System.out.println("List of all Editors: ");
                printEditors();
                printNewsPages(sc.next());
                do {
                    System.out.println("Type 0 to return: ");
                } while (sc.nextInt() != 0);
                clearConsole();
                Main.main(null);
                break;
        }
    }

    private static List<Editor> findEditorByName(String editorName) {
        return editors
                    .stream()
                    .filter(p-> p.getName().equals(editorName))
                    .toList();
    }

    private static List<NewsPage> findNewsPageByEditor(Editor editor) {
        return newsPages
                .stream()
                .filter(p-> p.getEditor().equals(editor))
                .toList();
    }

    private static List<NewsPage> findNewsPageByHeadline(String headline) {
        return newsPages
                .stream()
                .filter(p-> p.getHeadline().equals(headline))
                .toList();
    }

    private static void clearConsole() {
        System.out.println(System.lineSeparator().repeat(50));
    }

    private static void printEditors() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Name", "ID");
        asciiTable.addRule();
        for (Editor e : editors) {
            asciiTable.addRow(e.getName(), e.getID());
            asciiTable.addRule();
        }
        asciiTable.setTextAlignment(TextAlignment.CENTER);
        asciiTable.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        System.out.println(asciiTable.render());
    }

    private static void printNewsTypes() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("1", "Football");
        asciiTable.addRow("2", "Basketball");
        asciiTable.addRow("3", "Tenis");
        asciiTable.addRow("4", "F1");
        asciiTable.addRow("5", "Motocycle");
        asciiTable.addRule();

        asciiTable.setTextAlignment(TextAlignment.CENTER);
        asciiTable.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        System.out.println(asciiTable.render());
    }

    private static void printNewsPages(String editorName) {
        List<NewsPage> newsPageByEditor = findNewsPageByEditor(findEditorByName(editorName).getFirst());

        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Headline", "Text", "Punctuation", "Price");
        asciiTable.addRule();
        for (NewsPage p : newsPageByEditor) {
            asciiTable.addRow(p.getHeadline(), p.getText(), p.getPunctuation(), p.calculateNewsPagePrice());
            asciiTable.addRule();
        }

        asciiTable.setTextAlignment(TextAlignment.CENTER);
        asciiTable.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        System.out.println(asciiTable.render());
    }
}
