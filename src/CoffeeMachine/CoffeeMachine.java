package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    private enum State {
        CHOOSING_ACTION, CHOOSING_COFFEE, FILLING_WATER, FILLING_MILK, FILLING_BEANS, FILLING_CUPS, EXIT
    }

    private State currentState = State.CHOOSING_ACTION;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        System.out.println("Write action (buy, fill, take, remaining, exit):");

        while (machine.currentState != State.EXIT) {
            System.out.print("> ");
            String input = scanner.next();
            machine.processInput(input);
        }
    }

    public void processInput(String input) {
        switch (currentState) {
            case CHOOSING_ACTION -> handleMainAction(input);
            case CHOOSING_COFFEE -> handleBuy(input);
            case FILLING_WATER -> { water += Integer.parseInt(input); System.out.println("Write how many ml of milk you want to add:"); currentState = State.FILLING_MILK; }
            case FILLING_MILK -> { milk += Integer.parseInt(input); System.out.println("Write how many grams of coffee beans you want to add:"); currentState = State.FILLING_BEANS; }
            case FILLING_BEANS -> { beans += Integer.parseInt(input); System.out.println("Write how many disposable cups of coffee you want to add:"); currentState = State.FILLING_CUPS; }
            case FILLING_CUPS -> { cups += Integer.parseInt(input); currentState = State.CHOOSING_ACTION; System.out.println("\nWrite action (buy, fill, take, remaining, exit):"); }
        }
    }

    private void handleMainAction(String action) {
        switch (action) {
            case "buy" -> {
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                currentState = State.CHOOSING_COFFEE;
            }
            case "fill" -> {
                System.out.println("\nWrite how many ml of water you want to add:");
                currentState = State.FILLING_WATER;
            }
            case "take" -> {
                System.out.println("\nI gave you " + money);
                money = 0;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            }
            case "remaining" -> {
                printState();
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            }
            case "exit" -> currentState = State.EXIT;
        }
    }

    private void handleBuy(String choice) {
        if (!choice.equals("back")) {
            switch (choice) {
                case "1" -> makeCoffee(250, 0, 16, 4);
                case "2" -> makeCoffee(350, 75, 20, 7);
                case "3" -> makeCoffee(200, 100, 12, 6);
            }
        }
        currentState = State.CHOOSING_ACTION;
        if (currentState != State.EXIT) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        }
    }

    private void makeCoffee(int needWater, int needMilk, int needBeans, int cost) {
        if (water < needWater) System.out.println("Sorry, not enough water!");
        else if (milk < needMilk) System.out.println("Sorry, not enough milk!");
        else if (beans < needBeans) System.out.println("Sorry, not enough coffee beans!");
        else if (cups < 1) System.out.println("Sorry, not enough disposable cups!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= needWater;
            milk -= needMilk;
            beans -= needBeans;
            cups--;
            money += cost;
        }
    }

    private void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}