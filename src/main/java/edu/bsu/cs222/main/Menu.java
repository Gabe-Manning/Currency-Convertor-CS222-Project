package edu.bsu.cs222.main;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public void displayMenu() {
        while (true) {
            String menuSelection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.println("Please make a selection:\n" +
                    "1) Convert Currency(with or without amount)\n" +
                    "2) Get Historical Record\n" +
                    "3) View All Exchange Rates\n"
            );
            menuSelection = scanner.nextLine();

            if (menuSelection.equals("1")){
                convertCurrency();
            } else if (menuSelection.equals("2")) {
                historyData();
            } else if (menuSelection.equals("3")) {

            }

        }
    }

    public void convertCurrency(){
        String convertSelection = scanner.nextLine();
        String startingCurrency, finalCurrency;
        System.out.println("Enter starting currency: ");
        startingCurrency = scanner.nextLine();
        System.out.println("Enter final currency: ");
        finalCurrency = scanner.nextLine();
        System.out.println("Please make a selection:\n" +
                "1) Convert Currencies With A Starting Amount\n" +
                "2) View Specific Exchange Rates\n");

        if(convertSelection.equals("1")){
            String startingAmount;
            System.out.println("Enter Starting Amount: ");
            startingAmount = scanner.nextLine();

        }
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
