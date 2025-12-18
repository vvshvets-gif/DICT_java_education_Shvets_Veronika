package CoffeeMachine;

public class CoffeeMachine {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int hasWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int hasMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int hasBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int needCups = scanner.nextInt();

        int canMakeWater = hasWater / 200;
        int canMakeMilk = hasMilk / 50;
        int canMakeBeans = hasBeans / 15;
        int possibleCups = Math.min(canMakeWater, Math.min(canMakeMilk, canMakeBeans));

        if (possibleCups == needCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > needCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCups - needCups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}
