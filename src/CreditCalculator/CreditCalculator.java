package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        String action = scanner.next();

        if (action.equals("n")) {
            System.out.println("Enter the loan principal:");
            double p = scanner.nextDouble();
            System.out.println("Enter the monthly payment:");
            double a = scanner.nextDouble();
            System.out.println("Enter the loan interest:");
            double interest = scanner.nextDouble();

            double i = interest / (12 * 100);
            double n = Math.ceil(Math.log(a / (a - i * p)) / Math.log(1 + i));

            printTime((int) n);

        } else if (action.equals("a")) {
            System.out.println("Enter the loan principal:");
            double p = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            int n = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            double interest = scanner.nextDouble();

            double i = interest / (12 * 100);
            double pow = Math.pow(1 + i, n);
            double a = Math.ceil(p * (i * pow) / (pow - 1));

            System.out.println("Your monthly payment = " + (int) a + "!");

        } else if (action.equals("p")) {
            System.out.println("Enter the annuity payment:");
            double a = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            int n = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            double interest = scanner.nextDouble();

            double i = interest / (12 * 100);
            double pow = Math.pow(1 + i, n);
            double p = Math.floor(a / ((i * pow) / (pow - 1)));

            System.out.println("Your loan principal = " + (int) p + "!");
        }
    }

    private static void printTime(int totalMonths) {
        int years = totalMonths / 12;
        int months = totalMonths % 12;

        String result = "It will take ";
        if (years > 0) {
            result += years + (years == 1 ? " year" : " years");
        }
        if (years > 0 && months > 0) {
            result += " and ";
        }
        if (months > 0) {
            result += months + (months == 1 ? " month" : " months");
        }
        result += " to repay this loan!";

        System.out.println(result);
    }
}