package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"diff\" - for differentiated payments,");
        System.out.println("type \"annuity\" - for annuity payments:");
        String type = scanner.nextLine();

        if (type.equals("diff")) {
            calculateDiff(scanner);
        } else if (type.equals("annuity")) {
            calculateAnnuity(scanner);
        } else {
            System.out.println("Incorrect parameters");
        }
    }

    private static void calculateDiff(Scanner scanner) {
        try {
            System.out.println("Enter the loan principal:");
            double p = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            int n = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            double interest = scanner.nextDouble();

            // Валідація на від'ємні значення
            if (p < 0 || n < 0 || interest < 0) {
                System.out.println("Incorrect parameters");
                return;
            }

            double i = interest / (12 * 100); // номінальна ставка
            double totalPaid = 0;

            for (int m = 1; m <= n; m++) {
                // Формула: Dm = P/n + i * (P - (P * (m - 1)) / n)
                double dm = Math.ceil(p / n + i * (p - (p * (m - 1)) / n));
                System.out.printf("Month %d: payment is %.0f%n", m, dm);
                totalPaid += dm;
            }

            System.out.printf("%nOverpayment = %.0f%n", totalPaid - p);
        } catch (Exception e) {
            System.out.println("Incorrect parameters");
        }
    }

    private static void calculateAnnuity(Scanner scanner) {
        try {
            System.out.println("What do you want to calculate?");
            System.out.println("type \"n\" - for periods, \"a\" - for payment, \"p\" - for principal:");
            String action = scanner.next();

            System.out.println("Enter the loan interest:");
            double interest = scanner.nextDouble();
            if (interest < 0) {
                System.out.println("Incorrect parameters");
                return;
            }
            double i = interest / (12 * 100);

            if (action.equals("n")) {
                System.out.println("Enter the loan principal:");
                double p = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                double a = scanner.nextDouble();

                if (p < 0 || a < 0) {
                    System.out.println("Incorrect parameters");
                    return;
                }

                int n = (int) Math.ceil(Math.log(a / (a - i * p)) / Math.log(1 + i));
                printTime(n);
                System.out.printf("Overpayment = %.0f%n", (n * a) - p);

            } else if (action.equals("a")) {
                System.out.println("Enter the loan principal:");
                double p = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int n = scanner.nextInt();

                if (p < 0 || n < 0) {
                    System.out.println("Incorrect parameters");
                    return;
                }

                double a = Math.ceil(p * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
                System.out.printf("Your monthly payment = %.0f!%n", a);
                System.out.printf("Overpayment = %.0f%n", (n * a) - p);

            } else if (action.equals("p")) {
                System.out.println("Enter the annuity payment:");
                double a = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int n = scanner.nextInt();

                if (a < 0 || n < 0) {
                    System.out.println("Incorrect parameters");
                    return;
                }

                double p = Math.floor(a / ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1)));
                System.out.printf("Your loan principal = %.0f!%n", p);
                System.out.printf("Overpayment = %.0f%n", (n * a) - p);
            }
        } catch (Exception e) {
            System.out.println("Incorrect parameters");
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