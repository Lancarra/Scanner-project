package app;

import java.util.Scanner;

public class Main {

    static String choice;      //Variable to save the user's selection from the menu

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);   // Creating a Scanner object to read user input

        // Do-while loop for displaying menus and processing user selections
        do {
            showMenu();     // Display the menu
            choice = scanner.nextLine();      // Read user selection
            switch (choice) {

                case "1":
                    // Choice 1: Tax calculation
                    System.out.println("Enter sum amount of income: ");     // Request to enter the amount of income
                    double income = Double.valueOf(scanner.nextLine());     // Read and convert user input to double type
                    double tax = calculateTax(income);      // Tax calculation
                    System.out.println("Sum of tax: " + tax);       // Output the amount of tax
                    break;

                case "2":
                    // Select 2: End work
                    System.out.println("Work's done. Have a nice day.");    // Message about completion of work
                    break;

                default:
                    // Wrong choice
                    System.out.println("Wrong choice. Please, try again :)");   // Notification of incorrect selection
            }

        }while (!"2".equals(choice));       // The loop continues until the user selects ‘2’

            scanner.close();        // Close Scanner to free up resources
    }

    // Method for displaying the menu
    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Start of work (tax calculation)");
        System.out.println("2. Finish the work ");

    }

    // Method for calculating tax based on the amount of income
    public static double calculateTax (double income){
        double tax = 0.0;       // Initial value of tax

        // Conditional structures for calculating tax depending on the amount of income
        if (income <= 10000){
            tax = income * 0.025;       // 2.5% for income up to and including 10,000
        } else if (income <= 25000){
            tax = 10000 * 0.025 + (income - 10000) * 0.043;      // 2.5% for the first 10000 and 4.3% for the amount from 10000 to 25000 inclusive
        } else {
            tax = 10000 * 0.025 + 15000 * 0.043 + (income - 25000) * 0.067;     // 2.5% for the first 10,000, 4.3% for the next 15,000, and 6.7% for amounts over 25,000
        }
        return tax;     // Output the tax amount
    }

}