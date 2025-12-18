package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Просимо ввести основну суму
        System.out.println("Enter the loan principal:");
        int principal = scanner.nextInt();

        // 2. Вибір дії
        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"p\" – for the monthly payment:");
        String action = scanner.next();

        if (action.equals("m")) {
            // РОЗРАХУНОК КІЛЬКОСТІ МІСЯЦІВ
            System.out.println("Enter the monthly payment:");
            int payment = scanner.nextInt();

            // Формула: principal / payment (округлення вгору)
            int months = (int) Math.ceil((double) principal / payment);
            System.out.println("It will take " + months + " months to repay the loan");

        } else if (action.equals("p")) {
            // РОЗРАХУНОК ЩОМІСЯЧНОГО ПЛАТЕЖУ
            System.out.println("Enter the number of months:");
            int periods = scanner.nextInt();

            // Рахуємо платіж з округленням вгору
            int payment = (int) Math.ceil((double) principal / periods);

            // Рахуємо останній платіж за формулою з ТЗ
            int lastPayment = principal - (periods - 1) * payment;

            if (lastPayment != payment && lastPayment > 0) {
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment + ".");
            } else {
                System.out.println("Your monthly payment = " + payment);
            }
        }
    }
}