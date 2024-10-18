package edu.bsu.cs222.main;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public void displayMenu() {
        while (true) {
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.println("Please make a selection:\n" +
                    "1) Convert Currency(with or without amount)\n" +
                    "2) Get Historical Record\n"
            );
            selection = scanner.nextLine();

            if (selection.equals("1")){
                convertCurrency();
            } else if (selection.equals("2")) {
                historyData();
            }
        }
    }

    public void convertCurrency(){
        System.out.println("Please make a selection:\n" +
                "1) Convert With A Starting Amount\n" +
                "2) View Exchange Rates");

    }

    public void historyData(){
        String historyCurrency;
        String historyDate;
        System.out.println("Input Currency(ex.USD): ");
        historyCurrency = scanner.nextLine();
        System.out.println("Input Date(ex.2024-03-18): ");
        historyDate = scanner.nextLine();
    }
}
