package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    // Стан кавомашини (за замовчуванням)
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printState();


        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                buy(scanner);
                break;
            case "fill":
                fill(scanner);
                break;
            case "take":
                take();
                break;
        }


        System.out.println();
        printState();
    }


    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }


    public static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            water -= 250;
            beans -= 16;
            money += 4;
        } else if (choice == 2) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            money += 7;
        } else if (choice == 3) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
        }
        cups -= 1;
    }


    public static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        cups += scanner.nextInt();
    }


    public static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}